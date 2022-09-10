package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.ClientsTerraBean;

public class ClientsTerraDao {

	// CREATE if !exist else UPDATE
	public static void save(ClientsTerraBean o) throws DaoException {
		try {
			if (o.getId() != 0) {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("UPDATE clientsTerra SET dateEnregistrement=?, dateMAJ=?, "
								+ "civilite=?, nom=?, prenom=?, tel=?, mail=?, password=?, "
								+ "abonnement=?, statut=?, archiver=?, commentaire=? "
								+ "WHERE id=?");

				ps.setDate(1, o.getDateEnregistrement());
				ps.setDate(2, o.getDateMAJ());
				ps.setInt(3, o.getCivilite());
				ps.setString(4, o.getNom());
				ps.setString(5, o.getPrenom());
				ps.setString(6, o.getTel());
				ps.setString(7, o.getMail());
				ps.setString(8, o.getPassword());
				ps.setInt(9, o.getAbonnement());
				ps.setInt(10, o.getStatut());
				ps.setBoolean(11, o.isArchiver());
				ps.setString(12, o.getCommentaire());

				ps.setInt(13, o.getId());

				ps.executeUpdate();

			} else {

				PreparedStatement ps = Database.connexion
						.prepareStatement("INSERT INTO clientsTerra "
								+ "(dateEnregistrement, dateMAJ,"
								+ "civilite, nom, prenom, tel, mail, password,"
								+ "abonnement, statut, archiver, commentaire)"
								+ "VALUES(?,?,"
								+ "?,?,?,?,?,?,"
								+ "?,?,?,?)");

				ps.setDate(1, o.getDateEnregistrement());
				ps.setDate(2, o.getDateMAJ());
				ps.setInt(3, o.getCivilite());
				ps.setString(4, o.getNom());
				ps.setString(5, o.getPrenom());
				ps.setString(6, o.getTel());
				ps.setString(7, o.getMail());
				ps.setString(8, o.getPassword());
				ps.setInt(9, o.getAbonnement());
				ps.setInt(10, o.getStatut());
				ps.setBoolean(11, o.isArchiver());
				ps.setString(12, o.getCommentaire());

				ps.executeUpdate();
			}

			System.out.println("SAVED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
			throw new DaoException("Impossible de communiquer avec la base de données.");
		}
	}

	// READ / RETRIEVE ONE LINE BY mail
	public ClientsTerraBean getByMail(String mail) throws DaoException {

		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT nom, mail FROM clientsTerra WHERE mail=?");
			ps.setString(1, mail);

			ResultSet rs = ps.executeQuery();
			// System.out.println(rs);

			if (rs.next()) {

				ClientsTerraBean u = new ClientsTerraBean();
				u.setMail(rs.getString("mail"));
				u.setNom(rs.getString("nom"));
				return u;

			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Impossible de communiquer avec la base de données.");
		}
	}

	// PASSWORD VERIFICATION
	public ClientsTerraBean passwordVerification(String mail, String password) throws DaoException {
		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM clientsTerra WHERE mail=? AND password=?");
			ps.setString(1, mail);
			ps.setString(2, password);
			// preparedStatement.setString(2,"123");

			ResultSet rs = ps.executeQuery();
			// System.out.println("Resultset de connectionUser() next : " +
			// resultat.next());

			if (rs.next()) {
				ClientsTerraBean o = new ClientsTerraBean();
				o.setId(rs.getInt("id"));
				o.setDateEnregistrement(rs.getDate("dateEnregistrement"));
				o.setDateMAJ(rs.getDate("dateMAJ"));
				o.setCivilite(rs.getInt("civilite"));
				o.setNom(rs.getString("nom"));
				o.setPrenom(rs.getString("prenom"));
				o.setTel(rs.getString("tel"));
				o.setMail(rs.getString("mail"));
				o.setPassword(rs.getString("password"));
				o.setAbonnement(rs.getInt("abonnement"));
				o.setStatut(rs.getInt("statut"));
				o.setArchiver(rs.getBoolean("archiver"));
				o.setCommentaire(rs.getString("commentaire"));

				return o;

			} else {
				return null;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("Impossible de communiquer avec la base de données.");
		}
	}
}
