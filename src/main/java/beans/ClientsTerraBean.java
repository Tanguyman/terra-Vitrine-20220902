package beans;

import java.sql.Date;

import tools.RegexValidator;

public class ClientsTerraBean {

	private int id;
	private Date dateEnregistrement;
	private Date dateMAJ;
	private int civilite;
	private String nom;
	private String prenom;
	private String tel;
	private String mail;
	private String password;
	private int abonnement;
	private int statut;
	private boolean archiver;
	private String commentaire;

	public ClientsTerraBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientsTerraBean(int id, Date dateEnregistrement, Date dateMAJ, int civilite, String nom, String prenom,
			String tel, String mail, String password, int abonnement, int statut, boolean archiver, String commentaire) 
					throws BeanException {
		super();
		this.id = id;
		this.dateEnregistrement = dateEnregistrement;
		this.dateMAJ = dateMAJ;
		this.civilite = civilite;
		this.setNom( nom );
		this.setPrenom(prenom);
		this.setTel(tel);
		this.setMail(mail);
		this.password = password;
		this.abonnement = abonnement;
		this.statut = statut;
		this.archiver = archiver;
		this.commentaire = commentaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateEnregistrement() {
		return dateEnregistrement;
	}

	public void setDateEnregistrement(Date dateEnregistrement) {
		this.dateEnregistrement = dateEnregistrement;
	}

	public Date getDateMAJ() {
		return dateMAJ;
	}

	public void setDateMAJ(Date dateMAJ) {
		this.dateMAJ = dateMAJ;
	}

	public int getCivilite() {
		return civilite;
	}

	public void setCivilite(int civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) throws BeanException {
		if ( !RegexValidator.nameValidator(nom) ) {
			throw new BeanException("Votre nom de famille peut être composé de 3 noms au maximum "
					+ "que vous pouvez séparer par un espace ou un tiret (-).<br>"
					+ "Votre nom de famille doit commencer et terminer par une lettre "
					+ "et ne doit pas contenir de chiffres ou de caractères spéciaux.");
		} else {
			this.nom = nom;
		}
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) throws BeanException {
		if ( !RegexValidator.nameValidator(prenom) ) {
			throw new BeanException("Votre prénom peut être composé de 3 noms au maximum "
					+ "que vous pouvez séparer par un espace ou un tiret (-).<br>"
					+ "Votre prénom doit commencer et terminer par une lettre "
					+ "et ne doit pas contenir de chiffres ou de caractères spéciaux.");
		} else {
			this.prenom = prenom;
		}
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) throws BeanException {
		if ( !RegexValidator.phoneNumberFrenchValidator(tel) ) {
			throw new BeanException("Votre numéro de téléphone n’est pas au format français.<br>"
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
		if ( !RegexValidator.emailValidator(mail)) {
			throw new BeanException("Votre email n’est pas conforme.");
		} else {
			this.mail = mail;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAbonnement() {
		return abonnement;
	}

	public void setAbonnement(int abonnement) {
		this.abonnement = abonnement;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		return "ClientsTerraBean [id=" + id + ", "
				+ (dateEnregistrement != null ? "dateEnregistrement=" + dateEnregistrement + ", " : "")
				+ (dateMAJ != null ? "dateMAJ=" + dateMAJ + ", " : "") + "civilite=" + civilite + ", "
				+ (nom != null ? "nom=" + nom + ", " : "") + (prenom != null ? "prenom=" + prenom + ", " : "")
				+ (tel != null ? "tel=" + tel + ", " : "") + (mail != null ? "mail=" + mail + ", " : "")
				+ (password != null ? "password=" + password + ", " : "") + "abonnement=" + abonnement + ", statut="
				+ statut + ", archiver=" + archiver + ", " + (commentaire != null ? "commentaire=" + commentaire : "")
				+ "]";
	}
}
