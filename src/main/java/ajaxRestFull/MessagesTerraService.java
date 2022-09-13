package ajaxRestFull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.MessagesTerraBean;
import dao.DaoException;
import dao.Database;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path( "/contact")
public class MessagesTerraService {

	@GET
	@Path( "/get/{id}")
	@Produces( MediaType.APPLICATION_JSON )
	public MessagesTerraBean getById( @PathParam( "id" ) int id ) throws DaoException {
	
		System.out.println("getById : " + id);
		Database.Connect();
		Connection connexion = null;
		PreparedStatement ps = null;
		
		try {
			connexion = Database.connexion;
			ps = connexion.prepareStatement("SELECT * FROM messagesTerra WHERE id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			MessagesTerraBean u = new MessagesTerraBean();
			rs.next();
			
			u.setId( rs.getInt("id"));
			u.setId_ClientTerra( rs.getInt("id_ClientTerra") );
			u.setIdPremierMessage( rs.getInt("idPremierMessage") );
			u.setDateEnvoi( rs.getDate("dateEnvoi") );
			u.setCivilite( rs.getInt("civilite"));
			u.setNom( rs.getString("nom") );
			u.setPrenom( rs.getString("prenom") );
			u.setTelProspect( rs.getString("telProspect") );
			u.setMailProspect( rs.getString("mailProspect") );
			u.setObjet( rs.getString("objet") );
			u.setCorps( rs.getString("corps") );
			u.setMailEmetteur( rs.getString("mailEmetteur") );
			u.setMailRecepteur( rs.getString("mailRecepteur") );
			u.setStatut( rs.getInt("statut") );
			u.setArchiver( rs.getBoolean("archiver") );
			
			return u;
			
		} catch ( Exception e ) {
			e.printStackTrace();
			// return null;	
			throw new DaoException("Impossible de communiquer avec la base de données.");
		}

	}
	
	@GET
	@Path( "/getAll")
	@Produces( MediaType.APPLICATION_JSON )
	public ArrayList<MessagesTerraBean> getAll() throws DaoException {
	
		System.out.println("getAll()");
		Database.Connect();
		Connection connexion = null;
		PreparedStatement ps = null;
		
		try {
			connexion = Database.connexion;
			ps = connexion.prepareStatement("SELECT * FROM messagesTerra");
			

			ResultSet rs = ps.executeQuery();
			ArrayList<MessagesTerraBean> list = new ArrayList<MessagesTerraBean>();
			
			while ( rs.next() ) {				
			
				MessagesTerraBean o = new MessagesTerraBean();
				
				o.setId( rs.getInt("id"));
				o.setId_ClientTerra( rs.getInt("id_ClientTerra") );
				o.setIdPremierMessage( rs.getInt("idPremierMessage") );
				o.setDateEnvoi( rs.getDate("dateEnvoi") );
				o.setCivilite( rs.getInt("civilite"));
				o.setNom( rs.getString("nom") );
				o.setPrenom( rs.getString("prenom") );
				o.setTelProspect( rs.getString("telProspect") );
				o.setMailProspect( rs.getString("mailProspect") );
				o.setObjet( rs.getString("objet") );
				o.setCorps( rs.getString("corps") );
				o.setMailEmetteur( rs.getString("mailEmetteur") );
				o.setMailRecepteur( rs.getString("mailRecepteur") );
				o.setStatut( rs.getInt("statut") );
				o.setArchiver( rs.getBoolean("archiver") );
				
				list.add(o);
			
			}
			return list;
			
		} catch ( Exception e ) {
			e.printStackTrace();
			// return null;	
			throw new DaoException("Impossible de communiquer avec la base de données.");
		}

	}
}
