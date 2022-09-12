package beans;

import java.sql.Date;

import tools.RegexValidator;

public class MessagesTerraBean {

	private int id;
	private int id_ClientTerra;
	private int idPremierMessage;
	private Date dateEnvoi;
	private int civilite;
	private String nom;
	private String prenom;
	private String telProspect;
	private String mailProspect;
	private String objet;
	private String corps;
	private String mailEmetteur;
	private String mailRecepteur;
	private int statut;
	private boolean archiver;

	public MessagesTerraBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessagesTerraBean(int id, int id_ClientTerra, int idPremierMessage, Date dateEnvoi, int civilite, String nom,
			String prenom, String telProspect, String mailProspect, String objet, String corps, String mailEmetteur,
			String mailRecepteur, int statut, boolean archiver)
			throws BeanException {
		super();
		this.id = id;
		this.id_ClientTerra = id_ClientTerra;
		this.idPremierMessage = idPremierMessage;
		this.dateEnvoi = dateEnvoi;
		this.civilite = civilite;
		this.setNom( nom );
		this.setPrenom( prenom );
		this.setTelProspect( telProspect );
		this.setMailProspect( mailProspect );
		this.setObjet( objet );
		this.setCorps( corps );
		this.mailEmetteur = mailEmetteur;
		this.mailRecepteur = mailRecepteur;
		this.statut = statut;
		this.archiver = archiver;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_ClientTerra() {
		return id_ClientTerra;
	}

	public void setId_ClientTerra(int id_ClientTerra) {
		this.id_ClientTerra = id_ClientTerra;
	}

	public int getIdPremierMessage() {
		return idPremierMessage;
	}

	public void setIdPremierMessage(int idPremierMessage) {
		this.idPremierMessage = idPremierMessage;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
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
		if (!RegexValidator.nameValidator(nom) || nom.length() > 60) {
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
		if (!RegexValidator.nameValidator(prenom) || nom.length() > 60) {
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

	public String getTelProspect() {
		return telProspect;
	}

	public void setTelProspect(String telProspect) throws BeanException {
		if (!RegexValidator.phoneNumberFrenchValidator(telProspect)) {
			throw new BeanException("Votre <b>numéro de téléphone</b> n’est pas au format français.<br>"
					+ "Il doit comprendre 10 chiffres et commencer par 0 "
					+ "suivi d’un chiffre entre 1 et 9.");
		} else {
			this.telProspect = telProspect;
		}
	}

	public String getMailProspect() {
		return mailProspect;
	}

	public void setMailProspect(String mailProspect) throws BeanException {
		if (!RegexValidator.emailValidator(mailProspect)) {
			throw new BeanException("Votre <b>email</b> n’est pas au bon format.");
		} else {
			this.mailProspect = mailProspect;
		}
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) throws BeanException {
		if (objet.length() > 60 || objet.length() == 0) {
			throw new BeanException("L’<b>objet / sujet</b> du message :<br>"
					+ "- ne peut pas être vide.<br>"
					+ "- ne doit pas dépasser 60 caractères.");
		} else {
			this.objet = objet;
		}
	}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) throws BeanException {
		if (corps.length() == 0) {
			throw new BeanException("Le corps du <b>message</b>"
					+ " ne peut pas être vide.");
		} else {
			this.corps = corps;
		}
	}

	public String getMailEmetteur() {
		return mailEmetteur;
	}

	public void setMailEmetteur(String mailEmetteur) {
		this.mailEmetteur = mailEmetteur;
	}

	public String getMailRecepteur() {
		return mailRecepteur;
	}

	public void setMailRecepteur(String mailRecepteur) {
		this.mailRecepteur = mailRecepteur;
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

	@Override
	public String toString() {
		return "MessagesTerraBean [id=" + id + ", id_ClientTerra=" + id_ClientTerra + ", idPremierMessage="
				+ idPremierMessage + ", dateEnvoi=" + dateEnvoi + ", civilite=" + civilite + ", nom=" + nom
				+ ", prenom=" + prenom + ", telProspect=" + telProspect + ", mailProspect=" + mailProspect + ", objet="
				+ objet + ", corps=" + corps + ", mailEmetteur=" + mailEmetteur + ", mailRecepteur=" + mailRecepteur
				+ ", statut=" + statut + ", archiver=" + archiver + "]";
	}

}