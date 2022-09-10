package beans;

public class OffresBean {

	private int id;
	private String titreAbonnement;
	private String description;
	private int prix;
	private String imageURL;
	private boolean archiver;

	public OffresBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OffresBean(int id, String titreAbonnement, String description, int prix, String imageURL, boolean archiver)
			throws BeanException {
		super();
		this.id = id;
		this.setTitreAbonnement(titreAbonnement);
		this.setDescription(description);
		this.setPrix(prix);
		this.setImageURL(imageURL);
		this.setArchiver(archiver);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitreAbonnement() {
		return titreAbonnement;
	}

	public void setTitreAbonnement(String titreAbonnement) throws BeanException {
		if (titreAbonnement != null) {
			if (titreAbonnement.length() > 40) {
				throw new BeanException("Le titre de l’abonnement ne peut pas dépasser 40 caractères.");
			} else {
				this.titreAbonnement = titreAbonnement;
			}
		} /*else {
			titreAbonnement = "";
		}*/
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws BeanException {
		if (description != null) {
			if (description.length() > 255) {
				throw new BeanException("La description du produit ne peut pas dépasser 40 caractères.");
			} else {
				this.description = description;
			}
		} /*else {
			description = "";
		}*/
	}

	public int getPrix() throws BeanException {
		return prix;
	}

	public void setPrix(int prix) throws BeanException {
		if (prix <= 0) {
			throw new BeanException("La valeur d’une offre ne peut pas être inférieure ou égale à zéro.");
		} else {
			this.prix = prix;
		}
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public boolean getArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	@Override
	public String toString() {
		return "OffresBean [id=" + id + ", "
				+ (titreAbonnement != null ? "titreAbonnement=" + titreAbonnement + ", " : "")
				+ (description != null ? "description=" + description + ", " : "") + "prix=" + prix + ", "
				+ (imageURL != null ? "imageURL=" + imageURL + ", " : "") + "archiver=" + archiver + "]";
	}

}
