package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.LivreDOrBean;

public class LivreDOrDao {

	public void save(LivreDOrBean o) throws DaoException {
		Connection connexion = null;
		PreparedStatement ps = null;
		
		try {
			if (o.getId() != 0) {
				connexion = Database.connexion;
				ps = connexion.prepareStatement("UPDATE livre_d_or set dateCommentaire=?, nom=?, commentaire=?, archiver=? "
						+ "WHERE id=?");
				ps.setDate(1, o.getDateCommentaire());
				ps.setString(2, o.getNom());
				ps.setString(3, o.getCommentaire());
				ps.setBoolean(4, o.isArchiver());
				ps.setInt(5, o.getId());
				
				ps.executeUpdate();
				connexion.commit(); // À faire à la fin de la série de requête
				
			} else {
				connexion = Database.connexion;
				ps = connexion.prepareStatement("INSERT INTO slider (dateCommentaire, nom, commentaire, archiver) VALUES(?,?,?,?)");
				ps.setDate(1, o.getDateCommentaire());
				ps.setString(2, o.getNom());
				ps.setString(3, o.getCommentaire());
				ps.setBoolean(4, o.isArchiver());
				
				ps.executeUpdate();
				connexion.commit(); // À faire à la fin de la série de requête
			}
			System.out.println("SAVED OK");

		} catch ( SQLException e ) {
			// ex.printStackTrace();
			System.out.println("SAVED NO");
			try {
				if ( connexion != null ) {
					connexion.rollback(); // Annuler la transaction
				}
			} catch ( SQLException e2 ) {
			}
			throw new DaoException("Impossible de communiquer avec la base de données.");
			
		} finally {
			try {
				if ( connexion != null ) {
					connexion.close();
				}
			} catch ( SQLException e ) {
				throw new DaoException("Impossible de communiquer avec la base de données.");
			}
			
		}
	}

	// READ / RETRIEVE ONE LINE BY ID
//	public SliderBean getById( int id ) throws DaoException {
//		
//		Connection connexion = null;
//		PreparedStatement ps = null;
//		
//		try {
//			connexion = Database.connexion;
//			ps = connexion.prepareStatement("SELECT * FROM slider WHERE id=?");
//			ps.setInt(1, id);
//
//			ResultSet rs = ps.executeQuery();
//			SliderBean u = new SliderBean();
//			rs.next();
//			
//			u.setId(rs.getInt("id"));
//			u.setTitre(rs.getString("titre"));
//			
//			return u;
//
//		} catch ( Exception ex ) {
//			// ex.printStackTrace();
//			// return null;	
//			throw new DaoException("Impossible de communiquer avec la base de données.");
//			
//		} finally {
//			try {
//				if ( connexion != null ) {
//					connexion.close();
//				}
//			} catch ( SQLException e ) {
//				throw new DaoException("Impossible de communiquer avec la base de données.");
//			}
//		}
//	}

	// READ / RETRIEVE ALL
	public ArrayList<LivreDOrBean> getAll() throws DaoException {
		
		Connection connexion = null;
		PreparedStatement ps = null;
		ArrayList<LivreDOrBean> list = new ArrayList<LivreDOrBean>();
		
		try {
			
			connexion = Database.connexion;
			ps = connexion.prepareStatement("SELECT * FROM livre_d_or");

			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				
				LivreDOrBean o = new LivreDOrBean();
				
				o.setId(rs.getInt("id"));
				o.setDateCommentaire(rs.getDate("dateCommentaire"));
				o.setNom(rs.getString("nom"));
				o.setFonction(rs.getString("fonction"));
				o.setPhoto(rs.getString("photo"));
				o.setCommentaire(rs.getString("commentaire"));
				o.setArchiver(rs.getBoolean("archiver"));
				
//				System.out.println(o.toString());
				
				list.add(o);
			}
			
			// connexion.commit();

			return list;

		} catch (Exception ex) {
//			 ex.printStackTrace();
//			 return null;
			 throw new DaoException("Impossible de communiquer avec la base de données.");
		} /*finally {
			try {
				if ( connexion != null ) {
					connexion.close();
				}
			} catch ( SQLException e ) {
				throw new DaoException("Impossible de close la connexion.");
			}
		}*/
	}

	// DELETE
	public void deleteById( int id ) throws DaoException {
		
		Connection connexion = null;
		PreparedStatement ps = null;
		
		try {
			connexion = Database.connexion;

			ps = connexion.prepareStatement("DELETE FROM livre_d_or WHERE id=?");
			ps.setInt(1, id);

			ps.executeUpdate();
			connexion.commit(); // À faire à la fin de la série de requête
			System.out.println("DELETED OK");

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("DELETED NO");
			try {
				if ( connexion != null ) {
					connexion.rollback(); // Annuler la transaction
				}
			} catch ( SQLException e2 ) {
			}
			throw new DaoException("Impossible de communiquer avec la base de données.");
		} finally {
			try {
				if ( connexion != null ) {
					connexion.close();
				}
			} catch ( SQLException e ) {
				throw new DaoException("Impossible de communiquer avec la base de données.");
			}
		}
	}
}
