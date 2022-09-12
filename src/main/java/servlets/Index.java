package servlets;

import java.io.IOException;

import dao.DaoException;
import dao.Database;
import dao.LivreDOrDao;
import dao.LivreDOrLogosDao;
import dao.OffresDao;
import dao.SliderDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Index
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
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
		String names[] = session.getValueNames();
		for ( int i = 0, n = names.length; i < n; i++ ) {
			String key = names[i];
			System.out.println("Session key (Header) : " + key + " -> Session value : " + session.getValue(key));
		}
		/*
		 * Test instance constructeur
		 */
//		OffresBean ob = new OffresBean();
//		try {
//			ob.setTitreAbonnement("toto");
//			System.out.println(ob.getId());
//			System.out.println(ob.getDescription());
//			System.out.println(ob.getTitreAbonnement());
//		} catch (BeanException e1) {
//			// TODO Auto-generated catch block
//			System.out.println("bug");
//			// session.setAttribute("messageConnexion", e1);
//			e1.printStackTrace();
//		}
//		ClientsTerraBean ctb = new ClientsTerraBean();
//		try {
//			ctb.setNom("toto");
//			System.out.println(ctb.getNom());
//		} catch (BeanException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		/*
		 * Fin Test
		 */
		
		Database.Connect();

		SliderDao sliderDao = new SliderDao();
		LivreDOrDao livreDOrDao = new LivreDOrDao();
		LivreDOrLogosDao livreDOrLogosDao = new LivreDOrLogosDao();
		OffresDao offresDao = new OffresDao();
		
		try {

			request.setAttribute("sliders", sliderDao.getAll());
			request.setAttribute("temoignages", livreDOrDao.getAll());
			request.setAttribute("logosPartenaires", livreDOrLogosDao.getAll());
			request.setAttribute("offre1", offresDao.getOne(1));
			request.setAttribute("offre2", offresDao.getOne(2));
//			System.out.println( "offres : " + offresDao.getOne(1) );

		} catch (DaoException e) {

			e.printStackTrace();
			System.out.println("Dans la servlet index : " + e.getMessage());
			request.setAttribute("erreur", e.getMessage());
			// Dans le site vitrine dire site en maintenance
			// Dans l’app ou le back office du site vitrine dire contacter le service
			// technique
			// m’envoyer un mail car je suis le dév donc le service technique
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		/*
		 * Effacer les alerts
		 */
		if ( session.getAttribute("messageInscriptionValide") != null ) {
			session.setAttribute("messageInscriptionValide", null);
		}
		if ( session.getAttribute("messageInscriptionInvalide") != null ) {
			session.setAttribute("messageInscriptionInvalide", null);
		}
		if ( session.getAttribute("messageContactValide") != null ) {
			session.setAttribute("messageContactValide", null);
		}
		if ( session.getAttribute("messageContactInvalide") != null ) {
			session.setAttribute("messageContactInvalide", null);
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