package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; // ? j’ai du le faire à la mano !!!

import beans.BeanException;

// import com.mysql.cj.xdevapi.Statement; // C’est quoi cet import ???

import beans.MessagesTerraBean;

public class MessagesTerraDao {

	// CREATE if !exist else UPDATE
	public void save(MessagesTerraBean o) throws DaoException {

		Connection connexion = null;
		PreparedStatement ps = null;

		int newId = 0; // Pour récupèrer l’id du message créé

		try {
			connexion = Database.connexion;
			
			if (o.getId() != 0) {

				connexion = Database.connexion;
				ps = Database.connexion
						.prepareStatement("UPDATE messagesTerra "
								+ "SET id_ClientTerra=?, idPremierMessage=?, dateEnvoi=?, "
								+ "civilite=?, nom=?, prenom=?, telProspect=?, mailProspect=?, "
								+ "objet=?, corps=?, "
								+ "mailEmetteur=?, mailRecepteur=?, "
								+ "statut=?, archiver=? "
								+ "WHERE id=?");

				ps.setInt(1, o.getId_ClientTerra());
				ps.setInt(2, o.getIdPremierMessage());
				ps.setDate(3, o.getDateEnvoi());
				ps.setInt(4, o.getCivilite());
				ps.setString(5, o.getNom());
				ps.setString(6, o.getPrenom());
				ps.setString(7, o.getTelProspect());
				ps.setString(8, o.getMailProspect());
				ps.setString(9, o.getObjet());
				ps.setString(10, o.getCorps());
				ps.setString(11, o.getMailEmetteur());
				ps.setString(12, o.getMailRecepteur());
				ps.setInt(13, o.getStatut());
				ps.setBoolean(14, o.isArchiver());

				ps.setInt(15, o.getId());

				ps.executeUpdate();
				connexion.commit();

			} else {

				ps = Database.connexion
						.prepareStatement(
								"INSERT INTO `messagesTerra`"
										+ "(`id_ClientTerra`, `idPremierMessage`, `dateEnvoi`, "
										+ "`civilite`, `nom`, `prenom`, `telProspect`, `mailProspect`, "
										+ "`objet`, `corps`, `mailEmetteur`, `mailRecepteur`, "
										+ "`statut`, `archiver`) "
										+ "VALUES (?,?,?,"
										+ "?,?,?,?,?,"
										+ "?,?,?,?,"
										+ "?,?)",
								Statement.RETURN_GENERATED_KEYS);

				ps.setInt(1, o.getId_ClientTerra());
				ps.setInt(2, o.getIdPremierMessage());
				ps.setDate(3, o.getDateEnvoi());
				ps.setInt(4, o.getCivilite());
				ps.setString(5, o.getNom());
				ps.setString(6, o.getPrenom());
				ps.setString(7, o.getTelProspect());
				ps.setString(8, o.getMailProspect());
				ps.setString(9, o.getObjet());
				ps.setString(10, o.getCorps());
				ps.setString(11, o.getMailEmetteur());
				ps.setString(12, o.getMailRecepteur());
				ps.setInt(13, o.getStatut());
				ps.setBoolean(14, o.isArchiver());

				ps.executeUpdate();

				ResultSet resultat = ps.getGeneratedKeys();
				resultat.next();
				newId = resultat.getInt(1);
				System.out.println("L’id de ce nouveau message est : " + newId);
				
				ps = Database.connexion.prepareStatement("UPDATE messagesTerra "
								+ "SET idPremierMessage=? "
								+ "WHERE id=?");
				ps.setInt(1, newId);
				ps.setInt(2, newId);
				
				ps.executeUpdate();
				connexion.commit();

			}

			System.out.println("SAVED OK");

		} catch ( SQLException e ) {
			e.printStackTrace();
			System.out.println("SAVED NO");
			try {
				if ( connexion != null ) {
					connexion.rollback(); // Annuler la transaction
				}
			} catch ( SQLException e2 ) {
				e2.printStackTrace();
			}
			throw new DaoException("Impossible de communiquer avec la base de données.");	
		}
	}
	
	// READ / RETRIEVE ONE LINE BY ID
	public MessagesTerraBean getById( int id ) throws DaoException {
		Connection connexion = null;
		PreparedStatement ps = null;
		
		try {
			connexion = Database.connexion;
			ps = connexion.prepareStatement("SELECT * FROM slider WHERE id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			MessagesTerraBean o = new MessagesTerraBean();
			rs.next();
			
			o.setId(rs.getInt("id"));
			o.setId_ClientTerra(rs.getInt("id_ClientTerra"));
			o.setIdPremierMessage(rs.getInt("idPremierMessage"));
			o.setDateEnvoi(rs.getDate("dateEnvoi"));
			o.setCivilite(rs.getInt("civilite"));
			o.setNom(rs.getString("nom"));
			o.setPrenom(rs.getString("prenom"));;
			o.setTelProspect(rs.getString("telProspect"));
			o.setMailProspect(rs.getString("mailProspect"));
			o.setObjet(rs.getString("objet"));
			o.setCorps(rs.getString("corps"));
			o.setMailEmetteur(rs.getString("mailEmetteur"));
			o.setMailRecepteur(rs.getString("mailRecepteur"));
			o.setStatut(rs.getInt("statut"));
			o.setArchiver(rs.getBoolean("archiver"));
			
			return o;

		} catch ( SQLException e ) {
			 e.printStackTrace();
			// return null;	
			throw new DaoException("Impossible de communiquer avec la base de données.");
			
		} catch (BeanException e) {
			e.printStackTrace();
			throw new DaoException("Les données de la base sont invalides.");
		}
	}
}
