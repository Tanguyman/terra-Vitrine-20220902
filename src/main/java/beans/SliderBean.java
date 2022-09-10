package beans;

public class SliderBean {

	private int id;
	private String titre;
	private String description;
	private String imageURL;
	private String titreBouton;
	private String urlBouton;
	private boolean archiver;

	public SliderBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SliderBean(int id, String titre, String description, String imageURL, String titreBouton, String urlBouton,
			boolean archiver) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.imageURL = imageURL;
		this.titreBouton = titreBouton;
		this.urlBouton = urlBouton;
		this.archiver = archiver;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) throws BeanException {
		if ( titre.length() > 70 ) {
			throw new BeanException("Le titre ne peut pas dépasser 70 caractères.");
		} else {
			this.titre = titre;
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws BeanException {
		if ( description.length() > 255 ) {
			throw new BeanException("La description ne peut pas dépasser 255 caractères.");
		} else {			
			this.description = description;
		}
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getTitreBouton() {
		return titreBouton;
	}

	public void setTitreBouton(String titreBouton) throws BeanException {
		if ( titreBouton.length() > 30 ) {
			throw new BeanException("Le titre ne peut pas dépasser 30 caractères.");			
		} else {
			this.titreBouton = titreBouton;			
		}
	}

	public String getUrlBouton() {
		return urlBouton;
	}

	public void setUrlBouton(String urlBouton) {
		this.urlBouton = urlBouton;
	}

	public boolean getArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	@Override
	public String toString() {
		return "SliderBean [id=" + id + ", titre=" + titre + ", description=" + description + ", imageURL=" + imageURL
				+ ", titreBouton=" + titreBouton + ", urlBouton=" + urlBouton + ", archiver=" + archiver + "]";
	}

}