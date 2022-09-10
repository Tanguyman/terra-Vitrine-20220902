package beans;

import tools.RegexValidator;

public class CoordonneesTerraBean {
	
	private int id;
	private String nom;
	private String adresse;
	private String telephone;
	private String email;
	private String logo;
	private boolean archiver;
	
	public CoordonneesTerraBean() {
		super();
	}
	
	public CoordonneesTerraBean(int id, String nom, String adresse, String telephone, String email, String logo,
			boolean archiver) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.logo = logo;
		this.archiver = archiver;
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
			throw new BeanException("Le nom de votre entreprise ne peut pas dépasser 60 caractères.");
		} else {
			this.nom = nom;			
		}
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) throws BeanException {
		if ( nom.length() > 255 ) {
			throw new BeanException("L’adresse ne peut comporter plus de 255 caractères");
		} else {
			this.adresse = adresse;
		}
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) throws BeanException {
		if ( telephone.length() > 10 ) {
			throw new BeanException("Le numéro de téléphone comprend plus de 10 chiffres");
		} else if ( telephone.length() < 10 ) {
			throw new BeanException("Le numéro de téléphone comprend moins de 10 chiffres");
		} else if ( !RegexValidator.phoneNumberFrenchValidator( telephone ) ) {
			throw new BeanException("Le numéro de téléphone n’est pas au bon format.<br>"
					+ "Il doit commencer par zéro suivi d’un chiffre entre 1 et 9<br>"
					+ "et ne peut contenir que des chiffres ");
		} else {
			this.telephone = telephone;			
		}
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) throws BeanException {
		if ( !RegexValidator.emailValidator(email) ) {
			throw new BeanException("Votre email n’est pas au bon format.");
		} else {
			this.email = email;			
		}
	}
	
	public String getLogo() {
		return logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public boolean isArchiver() {
		return archiver;
	}
	
	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	@Override
	public String toString() {
		return "CoordonneesTerraBean [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone
				+ ", email=" + email + ", logo=" + logo + ", archiver=" + archiver + "]";
	}
}