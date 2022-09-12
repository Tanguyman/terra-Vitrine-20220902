package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement; // ? j’ai du le faire à la mano !!!

// import com.mysql.cj.xdevapi.Statement; // C’est quoi cet import ???

import beans.MessagesTerraBean;

public class MessagesTerraDao {

	// CREATE if !exist else UPDATE
		public void save(MessagesTerraBean o) throws DaoException {
			
			int newId = 0; // Pour récupèrer l’id de la Commande créée
			
			try {
				if (o.getId() != 0) {

					PreparedStatement ps = Database.connexion
							.prepareStatement("UPDATE messagesTerra SET id_ClientTerra=?, "
									+ "idPremierMessage=?, dateEnvoi=?, civilite=?, "
									+ "nom=?, prenom=?, telProspect=?, mailProspect=?, "
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
					
					newId = o.getIdPremierMessage();

				} else {
					
					System.out.println("Dao : " + o);
					
					PreparedStatement ps = Database.connexion
							.prepareStatement(
//									"INSERT INTO messagesTerra "
//									+ "(id_ClientTerra, idPremierMessage, dateEnvoi, civilite, "
//									+ "nom, prenom, telProspect, mailProspect, "
//									+ "objet, corps, "
//									+ "mailEmetteur, mailRecepteur, "
//									+ "statut, archiver) "
									"INSERT INTO `messagesTerra`(`id_ClientTerra`, `idPremierMessage`, `dateEnvoi`, `civilite`, `nom`, `prenom`, `telProspect`, `mailProspect`, `objet`, `corps`, `mailEmetteur`, `mailRecepteur`, `statut`, `archiver`) "
									+ "VALUES (?,?,?,?,"
									+ "?,?,?,?,"
									+ "?,?,"
									+ "?,?,"
									+ "?,?)",
									Statement.RETURN_GENERATED_KEYS

//									"INSERT INTO messagesTerra (id_ClientTerra, idPremierMessage, dateEnvoi, civilite, nom, prenom, telProspect, mailProspect, objet, corps, mailEmetteur, mailRecepteur, statut, archiver) VALUES (1,1,null,1,'MANAS','Tanguy','0680712665','dj.tanguy.paris@gmail.com','Tarif','Rappel','dj.tanguy.paris@gmail.com','dj.tanguy.paris@gmail.com',1,false)"
							);
					
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
//					
//					ps.setInt(1, 1);
//					ps.setInt(2, 1);
//					ps.setDate(3, null);
//					ps.setInt(4, 1);
//					ps.setString(5, "manas");
//					ps.setString(6, "tanguy");
//					ps.setString(7, "0680712665");
//					ps.setString(8, "dj.tanguy.paris@gmail.com");
//					ps.setString(9, "Tarif");
//					ps.setString(10, "Rappelez moi svp");
//					ps.setString(11, "dj.tanguy.paris@gmail.com");
//					ps.setString(12, "toto");
//					ps.setInt(13, 1);
//					ps.setBoolean(14, false);

					ps.executeUpdate();
					
					ResultSet resultat = ps.getGeneratedKeys();
					resultat.next();
					newId = resultat.getInt(1);
					
					System.out.println("L’id de ce nouveau message est : " + newId);
				}

				System.out.println("SAVED OK");

			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("SAVED NO");
				throw new DaoException("Impossible de communiquer avec la base de données.");
			}
		}
}
