package dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.BeanException;
import beans.ClientsTerraBean;
import tools.PasswordHash;

public class ClientsTerraDao {

	// CREATE if !exist else UPDATE
	public void save(ClientsTerraBean o) throws DaoException {

		Connection connexion = null;
		PreparedStatement ps = null;

		try {
			if (o.getId() != 0) {

//				Database.Connect();
				connexion = Database.connexion;
				ps = Database.connexion
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
				String pHash = PasswordHash.generatePassword(o.getPassword());
				System.out.println(pHash);
				ps.setString(8, pHash);
				ps.setInt(9, o.getAbonnement());
				ps.setInt(10, o.getStatut());
				ps.setBoolean(11, o.isArchiver());
				ps.setString(12, o.getCommentaire());

				ps.setInt(13, o.getId());

				ps.executeUpdate();
				connexion.commit();

			} else {

				connexion = Database.connexion;
				ps = Database.connexion
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
				String pHash = PasswordHash.generatePassword(o.getPassword());
				System.out.println(pHash);
				ps.setString(8, pHash);
				ps.setInt(9, o.getAbonnement());
				ps.setInt(10, o.getStatut());
				ps.setBoolean(11, o.isArchiver());
				ps.setString(12, o.getCommentaire());

				ps.executeUpdate();
				connexion.commit();
			}

			System.out.println("SAVED OK");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SAVED NO");
			try {
				if (connexion != null) {
					connexion.rollback(); // Annuler la transaction
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			throw new DaoException("Impossible de communiquer avec la base de donn??es.");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// READ / RETRIEVE ONE LINE BY mail
	public ClientsTerraBean getByMail(String mail) throws DaoException {

		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT id, nom, mail FROM clientsTerra WHERE mail=?");
			ps.setString(1, mail);

			ResultSet rs = ps.executeQuery();
			// System.out.println(rs);

			if (rs.next()) {

				ClientsTerraBean u = new ClientsTerraBean();
				u.setId(rs.getInt("id"));
				u.setMail(rs.getString("mail"));
				u.setNom(rs.getString("nom"));
				return u;

			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Impossible de communiquer avec la base de donn??es.");
		} catch (BeanException e) {
			e.printStackTrace();
			throw new DaoException("Les donn??es de la base sont invalides.");
		}
	}

	// READ : PASSWORD VERIFICATION
	public ClientsTerraBean isLoginCorrect(String mail, String password) throws DaoException {
		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM clientsTerra WHERE mail=?"); // AND password=?
			ps.setString(1, mail);
			// ps.setString(2, passwordStored); // on ne peut pas le comparer !!!

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				ClientsTerraBean o = new ClientsTerraBean();

				String passwordStored = rs.getString("password");
				boolean isPc = PasswordHash.isPasswordCorrect(password, passwordStored);

				// System.out.println("password du formulaire : " + password);
				// System.out.println( "password hash?? avec le password du formulaire : "
				// + PasswordHash.generatePassword(password) );
				// System.out.println( "password stock?? en BDD : " + passwordStored );
				// System.out.println("is p Correct : " + isPc );

				if (isPc) {
					o.setId(rs.getInt("id"));
					o.setDateEnregistrement(rs.getDate("dateEnregistrement"));
					o.setDateMAJ(rs.getDate("dateMAJ"));
					o.setCivilite(rs.getInt("civilite"));
					o.setNom(rs.getString("nom"));
					o.setPrenom(rs.getString("prenom"));
					o.setTel(rs.getString("tel"));
					o.setMail(rs.getString("mail"));
					o.setPassword(password);
					o.setAbonnement(rs.getInt("abonnement"));
					o.setStatut(rs.getInt("statut"));
					o.setArchiver(rs.getBoolean("archiver"));
					o.setCommentaire(rs.getString("commentaire"));

					return o;
				} else {
					return null;
				}
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Impossible de communiquer avec la base de donn??es.");
		} catch (BeanException e) {
			e.printStackTrace();
			throw new DaoException("Les donn??es de la base sont invalides.");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("Probl??me d???algo sur le mdp.");
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("Probl??me avec le mdp.");
		}
	}

	// READ : IS MAIL IN DATABASE
	public Boolean isMailInDatabase(String mail) throws DaoException {
		try {
			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM clientsTerra WHERE mail=?");
			ps.setString(1, mail);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Impossible de communiquer avec la base de donn??es.");
		}
	}

	// UPDATE : block account
	public void blockAccount(String mail) throws DaoException {

		Connection connexion = null;
		PreparedStatement ps = null;

		try {
			connexion = Database.connexion;

			ps = Database.connexion.prepareStatement("UPDATE `clientsTerra` SET `statut`=1 "
					+ "WHERE `mail`=?");
			ps.setString(1, mail);

			ps.executeUpdate();
			connexion.commit();
			System.out.println("SAVED OK");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SAVED NO");
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new DaoException("Impossible de communiquer avec la base de donn??es.");
		}
	}
}
