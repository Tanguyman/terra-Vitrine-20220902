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
		// this(0, "", ...);
	}

	public ClientsTerraBean(int id, Date dateEnregistrement, Date dateMAJ, int civilite, String nom, String prenom,
			String tel, String mail, String password, int abonnement, int statut, boolean archiver, String commentaire) 
					throws BeanException {
		super();
		this.setId(id);
		this.setDateEnregistrement(dateEnregistrement);
		this.setDateMAJ(dateMAJ);
		this.setCivilite(civilite);
		this.setNom( nom );
		this.setPrenom(prenom);
		this.setTel(tel);
		this.setMail(mail);
		this.setPassword(password);
		this.setAbonnement(abonnement);
		this.setStatut(statut);
		this.setArchiver(archiver);
		this.setCommentaire(commentaire);
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
		if ( !RegexValidator.nameValidator(nom)  || nom.length() > 60 ) {
			throw new BeanException("Votre <b>nom de famille</b> :<br>"
					+ "- ne peut pas être vide.<br>"
					+ "- ne peut pas dépasser 60 caractères.<br>"
					+ "- doit commencer et se terminer par une lettre.<br>"
					+ "- ne doit pas contenir de chiffres ou de caractères spéciaux.<br>"
					+ "- peut être composé de 3 noms au maximum "
					+ "que vous pouvez séparer par un espace ou un tiret (-).<br>");
		} else {
			this.nom = nom;
		}
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) throws BeanException {
		if ( !RegexValidator.nameValidator(prenom)  || nom.length() > 60 ) {
			throw new BeanException("Votre <b>prénom</b> :<br>"
					+ "- ne peut pas être vide.<br>"
					+ "- ne peut pas dépasser 60 caractères.<br>"
					+ "- doit commencer et se terminer par une lettre.<br>"
					+ "- ne doit pas contenir de chiffres ou de caractères spéciaux.<br>"
					+ "- peut être composé de 3 noms au maximum "
					+ "que vous pouvez séparer par un espace ou un tiret (-).<br>");
		} else {
			this.prenom = prenom;
		}
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) throws BeanException {
		if ( !RegexValidator.phoneNumberFrenchValidator(tel) ) {
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
		if ( !RegexValidator.emailValidator(mail)) {
			throw new BeanException("Votre <b>email</b> n’est pas au bon format.");
		} else {
			this.mail = mail;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws BeanException {
		if ( !RegexValidator.passwordValidator(password)) {
			throw new BeanException("Politique de sécurité concernant les <b>mots de passe</b> :<br>"
					+ "- au moins un chiffre.<br>"
					+ "- au moins une lettre minuscule.<br>"
					+ "- au moins une lettre majuscule.<br>"
					+ "- au moins un caractère spécial @ # $ % ^ & + = <br>"
					+ "- minimum 8 caractères. <br>"
					+ "- aucun espace.");
		} else {
			this.password = password;
		}
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
		return "ClientsTerraBean [id=" + id + ", dateEnregistrement=" + dateEnregistrement + ", dateMAJ=" + dateMAJ
				+ ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", mail=" + mail
				+ ", password=" + password + ", abonnement=" + abonnement + ", statut=" + statut + ", archiver="
				+ archiver + ", commentaire=" + commentaire + "]";
	}
}
