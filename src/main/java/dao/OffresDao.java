package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.OffresBean;

public class OffresDao {

	// CREATE & UPDATE
//	public void save(OffresBean o) throws DaoException {
//		Connection connexion = null;
//		PreparedStatement ps = null;
//
//		try {
//			if (o.getId() != 0) {
//				connexion = Database.connexion;
//				ps = connexion.prepareStatement("UPDATE slider set titre=? WHERE id=?");
//				ps.setString(1, o.getTitre());
//				ps.setInt(2, o.getId());
//
//				ps.executeUpdate();
//				connexion.commit(); // À faire à la fin de la série de requête
//
//			} else {
//				connexion = Database.connexion;
//				ps = connexion.prepareStatement("INSERT INTO slider (titre) VALUES(?)");
//				ps.setString(1, o.getTitre());
//
//				ps.executeUpdate();
//				connexion.commit(); // À faire à la fin de la série de requête
//			}
//			System.out.println("SAVED OK");
//
//		} catch (SQLException e) {
//			// ex.printStackTrace();
//			System.out.println("SAVED NO");
//			try {
//				if (connexion != null) {
//					connexion.rollback(); // Annuler la transaction
//				}
//			} catch (SQLException e2) {
//			}
//			throw new DaoException("Impossible de communiquer avec la base de données.");
//
//		} finally {
//			try {
//				if (connexion != null) {
//					connexion.close();
//				}
//			} catch (SQLException e) {
//				throw new DaoException("Impossible de communiquer avec la base de données.");
//			}
//
//		}
//	}

	// READ / RETRIEVE ONE
	public OffresBean getOne(int id) throws DaoException {
		
		Connection connexion = null;
		PreparedStatement ps = null;

		try {

			connexion = Database.connexion;
			ps = connexion.prepareStatement("SELECT * FROM offres WHERE id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			rs.next();
			
			OffresBean o = new OffresBean();
			o.setId(rs.getInt("id"));
			o.setTitreAbonnement(rs.getString("titreAbonnement"));
			o.setDescription(rs.getString("description"));
			o.setPrix(rs.getInt("prix"));
			o.setImageURL(rs.getString("imageURL"));
			o.setArchiver(rs.getBoolean("archiver"));

			return o;

		} catch (Exception ex) {
			ex.printStackTrace();
//			  return null;
			throw new DaoException("Impossible de communiquer avec la base de données.");
		} /*
			 * finally { try { if ( connexion != null ) { connexion.close(); } } catch (
			 * SQLException e ) { throw new
			 * DaoException("Impossible de close la connexion."); } }
			 */
	}
	
	// READ / RETRIEVE ALL
	public ArrayList<OffresBean> getAll() throws DaoException {

		Connection connexion = null;
		PreparedStatement ps = null;
		ArrayList<OffresBean> list = new ArrayList<OffresBean>();

		try {

			connexion = Database.connexion;
			ps = connexion.prepareStatement("SELECT * FROM offres");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				OffresBean o = new OffresBean();

				o.setId(rs.getInt("id"));
				o.setTitreAbonnement(rs.getString(2));
				o.setDescription(rs.getString(3));
				o.setPrix(rs.getInt(4));
				o.setImageURL(rs.getString(5));
				o.setArchiver(rs.getBoolean(6));

				list.add(o);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			// return null;
			throw new DaoException("Impossible de communiquer avec la base de données.");
		} /*
			 * finally { try { if ( connexion != null ) { connexion.close(); } } catch (
			 * SQLException e ) { throw new
			 * DaoException("Impossible de close la connexion."); } }
			 */
	}

	// DELETE
//	public void deleteById(int id) throws DaoException {
//
//		Connection connexion = null;
//		PreparedStatement ps = null;
//
//		try {
//			connexion = Database.connexion;
//
//			ps = connexion.prepareStatement("DELETE FROM slider WHERE id=?");
//			ps.setInt(1, id);
//
//			ps.executeUpdate();
//			connexion.commit(); // À faire à la fin de la série de requête
//			System.out.println("DELETED OK");
//
//		} catch (SQLException e) {
//			// e.printStackTrace();
//			System.out.println("DELETED NO");
//			try {
//				if (connexion != null) {
//					connexion.rollback(); // Annuler la transaction
//				}
//			} catch (SQLException e2) {
//			}
//			throw new DaoException("Impossible de communiquer avec la base de données.");
//		} finally {
//			try {
//				if (connexion != null) {
//					connexion.close();
//				}
//			} catch (SQLException e) {
//				throw new DaoException("Impossible de communiquer avec la base de données.");
//			}
//		}
//	}
}
