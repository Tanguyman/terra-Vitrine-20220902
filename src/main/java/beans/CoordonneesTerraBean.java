package beans;

import tools.RegexValidator;

public class CoordonneesTerraBean {
	
	private int id;
	private String nom;
	private String adresse;
	private String tel;
	private String mail;
	private String logoURL;
	private boolean archiver;
	
	public CoordonneesTerraBean() {
		super();
	}
	
	public CoordonneesTerraBean(int id, String nom, String adresse, String tel, String mail, String logoURL,
			boolean archiver) throws BeanException {
		super();
		this.setId( id );
		this.setNom( nom);
		this.setAdresse( adresse );
		this.setTel( tel );
		this.setMail( mail );
		this.setLogoURL( logoURL );
		this.setArchiver( archiver );
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) throws BeanException {
		if ( nom.length() > 60 ) {
			throw new BeanException("Le <b>nom</b> de votre entreprise ne peut pas dépasser 60 caractères.");
		} else {
			this.nom = nom;			
		}
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) throws BeanException {
		if ( nom.length() > 255 ) {
			throw new BeanException("L’<b>adresse</b> ne peut comporter plus de 255 caractères");
		} else {
			this.adresse = adresse;
		}
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) throws BeanException {
		if ( !RegexValidator.phoneNumberFrenchValidator( tel ) ) {
			throw new BeanException("Votre <b>numéro de téléphone</b> n’est pas au format français.<br>"
					+ "Il doit comprendre 10 chiffres et commencer par 0 "
					+ "suivi d’un chiffre entre 1 et 9.");
		} else {
			this.tel = tel;			
		}
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) throws BeanException {
		if ( !RegexValidator.emailValidator(mail) ) {
			throw new BeanException("Votre <b>email</b> n’est pas au bon format.");
		} else {
			this.mail = mail;			
		}
	}
	
	public String getLogoURL() {
		return logoURL;
	}
	
	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}
	
	public boolean isArchiver() {
		return archiver;
	}
	
	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	@Override
	public String toString() {
		return "CoordonneesTerraBean [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + tel
				+ ", email=" + mail + ", logo=" + logoURL + ", archiver=" + archiver + "]";
	}
}