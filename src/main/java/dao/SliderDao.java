package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.SliderBean;

public class SliderDao {

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
	public SliderBean getById( int id ) throws DaoException {
		
		Connection connexion = null;
		PreparedStatement ps = null;
		
		try {
			connexion = Database.connexion;
			ps = connexion.prepareStatement("SELECT * FROM slider WHERE id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			SliderBean u = new SliderBean();
			rs.next();
			
			u.setId(rs.getInt("id"));
			u.setTitre(rs.getString("titre"));
			
			return u;

		} catch ( Exception ex ) {
			// ex.printStackTrace();
			// return null;	
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

	// READ / RETRIEVE ALL
	public ArrayList<SliderBean> getAll() throws DaoException {
		
		Connection connexion = null;
		PreparedStatement ps = null;
		ArrayList<SliderBean> list = new ArrayList<SliderBean>();
		
		try {
			
			connexion = Database.connexion;
			ps = connexion.prepareStatement("SELECT * FROM slider");

			ResultSet rs = ps.executeQuery();

			while ( rs.next() ) {
				
				SliderBean o = new SliderBean();
				
				o.setId(rs.getInt("id"));
				o.setTitre(rs.getString("titre"));
				o.setDescription(rs.getString("description"));
				o.setImageURL(rs.getString("imageURL"));
				o.setTitreBouton(rs.getString("titreBouton"));
				o.setUrlBouton(rs.getString("urlBouton"));
				o.setArchiver(rs.getBoolean("archiver"));
				
				list.add(o);
			}
			
			// connexion.commit(); // inutile

			return list;

		} catch (Exception ex) {
			// ex.printStackTrace();
			// return null;
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

			ps = connexion.prepareStatement("DELETE FROM slider WHERE id=?");
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