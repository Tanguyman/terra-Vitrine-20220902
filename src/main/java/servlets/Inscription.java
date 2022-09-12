package servlets;

import java.io.IOException;

import beans.BeanException;
import beans.ClientsTerraBean;
import dao.ClientsTerraDao;
import dao.DaoException;
import dao.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tools.DateManipulator;

/**
 * Servlet implementation class Inscription
 */
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inscription() {
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
		HttpSession session = request.getSession(true);
		Database.Connect();

		if (request.getParameter("buttonInscription") != null) {

			/*
			 * Récupérer les paramètres du Header (POST)
			 */
			String civilite = request.getParameter("civiliteInscription");
			String nom = request.getParameter("nomInscription");
			String prenom = request.getParameter("prenomInscription");
			String tel = request.getParameter("telInscription");
			String mail = request.getParameter("mailInscription");
			String password = request.getParameter("passwordInscription");
			String passwordConfirmation = request.getParameter("passwordConfirmation");
			String abonnement = request.getParameter("abonnement");
//			System.out.println( civilite + nom + prenom + tel + mail + password + passwordConfirmation + abonnement);

			/*
			 * TEST DE SÉCURITÉ
			 */
			try {
				/*
				 * V2
				 */
				ClientsTerraDao user = new ClientsTerraDao();
				ClientsTerraBean isEmailInDatabase;
				isEmailInDatabase = user.getByMail(mail);
				boolean arePasswordsEquals = password.equals(passwordConfirmation);
				
				if ((!civilite.equals("1") && !civilite.equals("2"))
						|| (!abonnement.equals("1") && !abonnement.equals("2"))) {
					
					session.setAttribute("messageInscriptionInvalide", "Me créer une table hacker ?");
					response.sendRedirect("Index#about");

				} else if (isEmailInDatabase != null) {

					session.setAttribute("messageInscriptionInvalide", "Cette email existe déjà...");
					response.sendRedirect("Index#about");

				} else {
					
					ClientsTerraBean ctBean = new ClientsTerraBean();
					
					ctBean.setDateEnregistrement( DateManipulator.dateInSql() );
					ctBean.setDateMAJ( DateManipulator.dateInSql() );
					ctBean.setCivilite( Integer.parseInt( civilite ) );
					ctBean.setNom( nom );
					ctBean.setPrenom( prenom );
					ctBean.setTel( tel );
					ctBean.setMail( mail );
					if (!arePasswordsEquals) {
						String messagePasswordNotEqual = "Les mots de passe saisis ne sont pas identiques.";
						session.setAttribute("messageInscriptionInvalide", messagePasswordNotEqual);
						response.sendRedirect("Index#about");
					}
					ctBean.setPassword( password );
					ctBean.setAbonnement( Integer.parseInt(abonnement) );
					ctBean.setStatut( 0 );
					ctBean.setArchiver( false );
					ctBean.setCommentaire( "commentaire" );
					
					
					ClientsTerraDao ctd = new ClientsTerraDao();
					ctd.save(ctBean);
					
					session.setAttribute("messageInscriptionValide",
							"Un email de confirmation vient de vous être envoyé.");
					response.sendRedirect("Index#about");
				}
				
				/*
				 *  V1
				 */
//				boolean isFirstNameValide = RegexValidator.nameValidator(nom);
//				boolean isLastNameValide = RegexValidator.nameValidator(prenom);
//				boolean isFrenchTelValide = RegexValidator.phoneNumberFrenchValidator(tel);
//				boolean isAnEmail = RegexValidator.emailValidator(mail);
//				boolean isPasswordValide = RegexValidator.passwordValidator(password);				
//				ClientsTerraDao user = new ClientsTerraDao();
//				ClientsTerraBean isEmailInDatabase;
//				isEmailInDatabase = user.getByMail(mail);
//				boolean arePasswordsEquals = password.equals(passwordConfirmation);
				
//				if ((civilite.equals("1") || civilite.equals("2")) 
//						&& arePasswordsEquals && isEmailInDatabase == null
//						&& ( abonnement.equals("1") || abonnement.equals("2") )
//						
//						&& isAnEmail && isPasswordValide 
//						&& isFirstNameValide && isLastNameValide
//						
//						) {
//					
//					ClientsTerraBean ctBean = new ClientsTerraBean();
//					
//					ctBean.setDateEnregistrement( DateManipulator.dateInSql() );
//					ctBean.setDateMAJ( DateManipulator.dateInSql() );
//					ctBean.setCivilite( Integer.parseInt( civilite ) );
//					ctBean.setNom( nom );
//					ctBean.setPrenom( prenom );
//					ctBean.setTel( tel );
//					ctBean.setMail( mail );
//					ctBean.setPassword( password );
//					ctBean.setAbonnement( Integer.parseInt(abonnement) );
//					ctBean.setStatut( 0 );
//					ctBean.setArchiver( false );
//					ctBean.setCommentaire( "commentaire" );
//					
//					System.out.println("Inscription : " + ctBean.toString());
//					ClientsTerraDao ctd = new ClientsTerraDao();
//					ClientsTerraBean ctBeanTest = ctd.isLoginCorrect("tanguy.paris@gmail.com", "@@11aaAA");
//					System.out.println("Inscription : " + ctBeanTest.toString());
//					
//					ctd.save(ctBean);
//					
//					session.setAttribute("messageInscriptionValide",
//							"Un email de confirmation vient de vous être envoyé.");
//					response.sendRedirect("Index#about");
//
//				} else if ((!civilite.equals("1") && !civilite.equals("2"))
//						|| (!abonnement.equals("1") && !abonnement.equals("2"))) {
//
//					System.out.println("Me créer une table hacker !");
//
//				} else if (isEmailInDatabase != null) {
//
//					session.setAttribute("messageEmailIsInDatabase", "Cette email existe déjà...");
//					response.sendRedirect("Index#about");
//
//				} else {
//					if (!isFirstNameValide) {
//						String messageInvalidFirstName = "Votre nom de famille peut être composé de 3 noms au maximum "
//								+ "que vous pouvez séparer par un espace ou un tiret (-).<br>"
//								+ "Votre nom de famille doit commencer et terminer par une lettre "
//								+ "et ne doit pas contenir de chiffres ou de caractères spéciaux.";
//
//						session.setAttribute("messageInvalidFirstName", messageInvalidFirstName);
//
//					}
//
//					if (!isLastNameValide) {
//
//						String messageInvalidLastName = "Votre prénom peut être composé de 3 noms au maximum "
//								+ "que vous pouvez séparer par un espace ou un tiret (-).<br>"
//								+ "Votre prénom doit commencer et terminer par une lettre "
//								+ "et ne doit pas contenir de chiffres ou de caractères spéciaux.";
//
//						session.setAttribute("messageInvalidLastName", messageInvalidLastName);
//
//					}
//
//					if (!isFrenchTelValide) {
//
//						String messageInvalidFrenchTel = "Votre numéro de téléphone n’est pas au format français.<br>"
//								+ "Il doit comprendre 10 chiffres et commencer par 0 "
//								+ "suivi d’un chiffre entre 1 et 9.";
//
//						session.setAttribute("messageInvalidFrenchTel", messageInvalidFrenchTel);
//
//					}
//
//					if (!isAnEmail) {
//
//						String messageInvalidEmail = "Votre email n’est pas conforme.";
//
//						session.setAttribute("messageInvalidEmail", messageInvalidEmail);
//
//					}
//					if (!isPasswordValide) {
//
//						String messageInvalidPassword = "Politique de sécurité concernant les mots de passe :<br>"
//								+ "- au moins un chiffre <br>"
//								+ "- au moins une lettre minuscule <br>"
//								+ "- au moins une lettre majuscule <br>"
//								+ "- au moins un caractère spécial @ # $ % ^ & + = <br>"
//								+ "- minimum 8 caractères <br>"
//								+ "- aucun espace";
//
//						session.setAttribute("messageInvalidPassword", messageInvalidPassword);
//
//					}
//
//					if (!arePasswordsEquals) {
//
//						String messagePasswordNotEqual = "Les mots de passe saisis ne sont pas identiques.";
//
//						session.setAttribute("messagePasswordNotEqual", messagePasswordNotEqual);
//
//					}
//
//					response.sendRedirect("Index#about");
//				}
				
			} catch (DaoException e) {
				
				e.printStackTrace();
				System.out.println("Dans la servlet inscription (anchor jsp about) : " + e.getMessage());
				request.setAttribute("erreur", e.getMessage());
				// Dans le site vitrine dire site en maintenance
				// Dans l’app ou le back office du site vitrine dire contacter le service
				// technique
				// m’envoyer un mail car je suis le dév donc le service technique
				
			} catch (BeanException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute("messageInscriptionInvalide", e.getMessage());
				response.sendRedirect("Index#about");
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
