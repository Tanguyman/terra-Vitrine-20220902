package tools;

import java.io.IOException;
import java.util.regex.Pattern;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

/*
 * TUTO : https://koor.fr/Java/TutorialJEE/jee_attaques_xss.wp
 */
// Activer le filtre
@WebFilter( filterName = "XssFilter", urlPatterns = {"/*"} )
public class XssFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		// Filter.super.init(filterConfig);
	}

	// Si plusieurs filtre sur le site alors chainage
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Création d’une chaîne de wrapper sur les requests
		chain.doFilter(new XssRequestWrapper((HttpServletRequest) request), response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		// Filter.super.destroy();
	}

	private static class XssRequestWrapper extends HttpServletRequestWrapper {

		private static final Pattern[] XSS_PATTERNS = {
				Pattern.compile("<.*?>"), // Tags html
				// ? -> non gourmand. Permet de ne pas retirer ce qui est à l’interieur du tag.
				Pattern.compile("&.*?;"), // Entités html
				Pattern.compile("%[0-9a-fA-F]*") // Caractères en-tête http (valeurs héxadécimales)
		};

		public XssRequestWrapper(HttpServletRequest servletRequest) {
			super(servletRequest);
		}

		@Override
		public String[] getParameterValues(String parameterName) {
			String[] values = super.getParameterValues(parameterName);

			if (values == null)
				return null;

			int count = values.length;
			for (int i = 0; i < count; i++) {
				// On remplace chaque chaîne de caractères
				values[i] = removeTags(values[i]);
			}
			return values;
		}

		@Override
		public String getParameter(String parameter) {
			return removeTags(super.getParameter(parameter));
		}

		@Override
		public String getHeader(String name) {
			return removeTags(super.getHeader(name));
		}

		private String removeTags(String value) {
			if (value != null) {
				// On retire le code ASCII 0, au cas où
				// AZT : add zero terminal
				value = value.replace("\0", "");

				// Supprime l’ensemble des tags et des entités
				for (Pattern pattern : XSS_PATTERNS) {
					value = pattern.matcher(value).replaceAll("");
				}

				// Au cas où les caractères < et > ne seraient pas en nomble pairs
				value = value.replace("<", "");
				value = value.replace(">", "");
			}
			return value;
		}
	}
}