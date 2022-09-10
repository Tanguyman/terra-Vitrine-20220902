package tools;

import java.io.IOException;
import java.util.regex.Pattern;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class XssFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Création d’une chaîne de wrapper sur les requests
		chain.doFilter( new XssRequestWrapper( (HttpServletRequest) request ), response );
		
	}

	private static class XssRequestWrapper extends HttpServletRequestWrapper {
		
		private static final Pattern [] XSS_PATTERNS = {
				Pattern.compile( "<.*?>" ), // ? -> non gourmand. Permet de ne pas retirer ce qui est à l’interieur du tag.
				Pattern.compile( "&.*?;" ), // Entités html
				Pattern.compile( "%[0-9a-fA-F]*" ) // Caractères en-tête http
		};

		public XssRequestWrapper(HttpServletRequest request) {
			super(request);
			// TODO Auto-generated constructor stub
		}
		
	}
}
