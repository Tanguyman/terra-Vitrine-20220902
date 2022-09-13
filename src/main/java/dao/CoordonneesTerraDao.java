package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.BeanException;
import beans.CoordonneesTerraBean;

public class CoordonneesTerraDao {

	// CREATE if !exist else UPDATE
	public void save(CoordonneesTerraBean o) throws DaoException {
		
		Connection connexion = null;
		PreparedStatement ps = null;
		
		try {
			if ( o.getId() != 0 ) {
				connexion = Database.connexion;
				ps = Database.connexion
						.prepareStatement("UPDATE `coordonneesTerra` SET `nom`=?,`adresse`=?,"
								+ "`tel`=?,`mail`=?,`logoURL`=?,`archiver`=? "
								+ "WHERE id=?");
				ps.setString(1, o.getNom());
				ps.setString(2, o.getAdresse());
				ps.setString(3, o.getTel());
				ps.setString(4, o.getMail());
				ps.setString(5, o.getLogoURL());
				ps.setBoolean(6, o.isArchiver());
				
				ps.setInt(7, o.getId());
				
				ps.executeUpdate();
				connexion.commit();
			} else {
				connexion = Database.connexion;
				ps = Database.connexion
						.prepareStatement("INSERT INTO `coordonneesTerra`(`nom`, `adresse`, "
								+ "`tel`, `mail`, `logoURL`, `archiver`) "
								+ "VALUES (?,?,?,?,?,?)");
				
				ps.setString(1, o.getNom());
				ps.setString(2, o.getAdresse());
				ps.setString(3, o.getTel());
				ps.setString(4, o.getMail());
				ps.setString(5, o.getLogoURL());
				ps.setBoolean(6, o.isArchiver());
				
				ps.executeUpdate();
				connexion.commit();
			}
			System.out.println("SAVED OK");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SAVED NO");
			try {
				if ( connexion != null ) {
					connexion.rollback(); // Annuler la transaction
				}
			} catch ( SQLException e2 ) {
			}
			throw new DaoException("Impossible de communiquer avec la base de données.");
		}
	}
	
	// READ / RETRIEVE ONE LINE BY id
	public CoordonneesTerraBean getById( int id ) throws DaoException {
		
		Connection connexion = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CoordonneesTerraBean o = new CoordonneesTerraBean();
		
		try {
			connexion = Database.connexion;
			ps = connexion.prepareStatement("SELECT * FROM `coordonneesTerra` WHERE id=?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			rs.next();
			
			o.setId(rs.getInt("id"));
			o.setNom(rs.getString("nom"));
			o.setAdresse(rs.getString("adresse"));
			o.setTel(rs.getString("tel"));
			o.setMail(rs.getString("mail"));
			o.setLogoURL(rs.getString("logoURL"));;
			o.setArchiver(rs.getBoolean("archiver"));
			
			return o;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Impossible de communiquer avec la base de données");
		} catch (BeanException e) {
			e.printStackTrace();
			throw new DaoException("Les données de la base sont invalides");
		}
	}
}
