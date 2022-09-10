package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.LivreDOrLogosBean;
import beans.SliderBean;

public class LivreDOrLogosDao {

	// CREATE & UPDATE
	public void save(SliderBean o) throws DaoException {
		Connection connexion = null;
		PreparedStatement ps = null;

		try {
			if (o.getId() != 0) {
				connexion = Database.connexion;
				ps = connexion.prepareStatement("UPDATE slider set titre=? WHERE id=?");
				ps.setString(1, o.getTitre());
				ps.setInt(2, o.getId());

				ps.executeUpdate();
				connexion.commit(); // À faire à la fin de la série de requête

			} else {
				connexion = Database.connexion;
				ps = connexion.prepareStatement("INSERT INTO slider (titre) VALUES(?)");
				ps.setString(1, o.getTitre());

				ps.executeUpdate();
				connexion.commit(); // À faire à la fin de la série de requête
			}
			System.out.println("SAVED OK");

		} catch (SQLException e) {
			// ex.printStackTrace();
			System.out.println("SAVED NO");
			try {
				if (connexion != null) {
					connexion.rollback(); // Annuler la transaction
				}
			} catch (SQLException e2) {
			}
			throw new DaoException("Impossible de communiquer avec la base de données.");

		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données.");
			}

		}
	}

	// READ / RETRIEVE ALL
	public ArrayList<LivreDOrLogosBean> getAll() throws DaoException {

		Connection connexion = null;
		PreparedStatement ps = null;
		ArrayList<LivreDOrLogosBean> list = new ArrayList<LivreDOrLogosBean>();

		try {

			connexion = Database.connexion;
			ps = connexion.prepareStatement("SELECT * FROM livre_d_or_logos");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				LivreDOrLogosBean o = new LivreDOrLogosBean();

				o.setId(rs.getInt("id"));
				o.setSociete(rs.getString("societe"));
				o.setUrl(rs.getString("url"));
				o.setArchiver(rs.getBoolean("archiver"));

				list.add(o);
			}

			// connexion.commit(); // inutile

			return list;

		} catch (Exception ex) {
			// ex.printStackTrace();
			// return null;
			throw new DaoException("Impossible de communiquer avec la base de données.");
		} /*
			 * finally { try { if ( connexion != null ) { connexion.close(); } } catch (
			 * SQLException e ) { throw new
			 * DaoException("Impossible de close la connexion."); } }
			 */
	}

	// DELETE
	public void deleteById(int id) throws DaoException {

		Connection connexion = null;
		PreparedStatement ps = null;

		try {
			connexion = Database.connexion;

			ps = connexion.prepareStatement("DELETE FROM slider WHERE id=?");
			ps.setInt(1, id);

			ps.executeUpdate();
			connexion.commit(); // À faire à la fin de la série de requête
			System.out.println("DELETED OK");

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("DELETED NO");
			try {
				if (connexion != null) {
					connexion.rollback(); // Annuler la transaction
				}
			} catch (SQLException e2) {
			}
			throw new DaoException("Impossible de communiquer avec la base de données.");
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données.");
			}
		}
	}
}
