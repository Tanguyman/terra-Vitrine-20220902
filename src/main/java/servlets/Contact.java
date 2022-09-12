package servlets;

import java.io.IOException;

import beans.BeanException;
import beans.ClientsTerraBean;
import beans.MessagesTerraBean;
import dao.ClientsTerraDao;
import dao.DaoException;
import dao.Database;
import dao.MessagesTerraDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tools.DateManipulator;

/**
 * Servlet implementation class Contact
 */
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Contact() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession(true);
		Database.Connect();

		if (request.getParameter("buttonContact") != null) {

			/*
			 * Récupérer les paramètres du Header (POST)
			 */
			String civilite = request.getParameter("civiliteContact");
			String nom = request.getParameter("nomContact");
			String prenom = request.getParameter("prenomContact");
			String tel = request.getParameter("telContact");
			String mail = request.getParameter("mailContact");
			String objet = request.getParameter("objetContact");
			String message = request.getParameter("messageContact");

			System.out.println("Objet : " + objet.length());
			System.out.println("Corps : " + message);

			/*
			 * TEST DE SÉCURITÉ
			 */
			try {

				ClientsTerraDao clientDao = new ClientsTerraDao();
				ClientsTerraBean isEmailInDatabase;
				isEmailInDatabase = clientDao.getByMail(mail);

				MessagesTerraBean mtBean = new MessagesTerraBean();

				if (isEmailInDatabase != null) {
					// Si un client passe par ici pour me laisser un message
					mtBean.setId_ClientTerra(isEmailInDatabase.getId());
				}

				// o.setIdPremierMessage(); // Fait dans la DAO avec
				// Statement.RETURN_GENERATED_KEYS
				mtBean.setDateEnvoi(DateManipulator.dateInSql());
				mtBean.setCivilite(Integer.parseInt(civilite));
				mtBean.setNom(nom);
				mtBean.setPrenom(prenom);
				mtBean.setTelProspect(tel);
				mtBean.setMailProspect(mail);

				mtBean.setObjet(objet);
				mtBean.setCorps(message);
				mtBean.setMailEmetteur(mail);
				// mtBean.setMailRecepteur(); // Si l’entreprise évolue
				mtBean.setStatut(0);
				mtBean.setArchiver(false);
				System.out.println(mtBean.toString());

				MessagesTerraDao mtDao = new MessagesTerraDao();
				mtDao.save(mtBean);

				session.setAttribute("messageContactValide", "Nous avons bien reçu votre demande.");
				response.sendRedirect("Index#contact");

			} catch (DaoException e) {

				e.printStackTrace();
				System.out.println("Dans la servlet contact (anchor jsp contact) :" + e.getMessage());
				request.setAttribute("erreur", e.getMessage());
				// Dans le site vitrine dire site en maintenance
				// Dans l’app ou le back office du site vitrine dire contacter le service
				// technique
				// m’envoyer un mail car je suis le dév donc le service technique
				
			} catch (BeanException e) {
				
				e.printStackTrace();
				session.setAttribute("messageContactInvalide", e.getMessage());
				response.sendRedirect("Index#contact");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
