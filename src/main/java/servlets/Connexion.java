package servlets;

import java.io.IOException;

import beans.ClientsTerraBean;
import dao.ClientsTerraDao;
import dao.DaoException;
import dao.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Connexion
 */
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String msg = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Connexion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		HttpSession session = request.getSession(true);
		Database.Connect();

		if (request.getParameter("buttonConnection") != null) {

			// Récupérer les paramètres du Header (POST)
			String mail = request.getParameter("mail");
			String password = request.getParameter("password");

			// TEST DE SÉCURITÉ
			try {
				ClientsTerraDao ctDao = new ClientsTerraDao();
				ClientsTerraBean ctBean = ctDao.isLoginCorrect(mail, password);
				session.setAttribute("messageConnexion", msg);

				if (ctBean != null) {

					if (ctBean.getAbonnement() == 11 || ctBean.getAbonnement() == 21) {

						response.sendRedirect("Index?param=test#about");

						msg = "Votre compte est bloqué pour impayé.</br>"
								+ "Veuillez nous contacter.";
						session.setAttribute("messageConnexion", msg);

					} else if (ctBean.getStatut() == 1) {

						response.sendRedirect("Index#about");

						msg = "Une personne a tenter de se connecter "
								+ "plusieurs fois à votre compte. Afin de sécuriser vos données, "
								+ "nous avons bloqué votre compte temporairement. Si vous n’avez pas "
								+ "reçu le mail de réactivation alors cliquez ci-dessous svp.</br></br>"
								+ "<button>Recevoir le mail de réactivation</button>";
						session.setAttribute("messageConnexion", msg);

					} else if (ctBean.isArchiver()) {

						response.sendRedirect("Index#about");

						msg = "Heureux de vous revoir mais vous n’êtes plus client chez nous.";
						session.setAttribute("messageConnexion", msg);

					} else {
						session.setAttribute("isConnected", true);
						session.setAttribute("messageConnexion", "Vers un autre serveur ou je code l’app ici ?");
						session.setAttribute("userTerra", ctBean);
						response.sendRedirect("Index#about");
					}

				} else {

					if (session.getAttribute("messageConnexion").equals("")) {

						response.sendRedirect("Index?param=test#about");

						msg = "Première tentative sur trois";
						session.setAttribute("messageConnexion", msg);

					} else if (session.getAttribute("messageConnexion").equals("Première tentative sur trois")) {

						response.sendRedirect("Index#about");

						msg = "Attention, plus qu'une tentative pour vous connecter";
						session.setAttribute("messageConnexion", msg);

					} else if (session.getAttribute("messageConnexion")
							.equals("Attention, plus qu'une tentative pour vous connecter")) {

						response.sendRedirect("Index#about");

						msg = "Afin de protéger vos données, votre compte est bloqué.</br>"
								+ "Vous avez reçu un mail de réactivation.</br>"
								+ "Sinon, veuillez contacter l’administrateur.";
						session.setAttribute("messageConnexion", msg);

						if (ctDao.isMailInDatabase(mail)) {
							ctDao.blockAccount(mail);
						}
					}
				}

			} catch (DaoException e) {

				e.printStackTrace();
				System.out.println("Dans la servlet connexion (anchor jsp about) : " + e.getMessage());
				request.setAttribute("erreur", e.getMessage());
				// Dans le site vitrine dire site en maintenance
				// Dans l’app ou le back office du site vitrine dire contacter le service
				// technique
				// m’envoyer un mail car je suis le dév donc le service technique
			}
		}
	}
}