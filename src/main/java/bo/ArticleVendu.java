package bo;

import java.util.Date;

public class ArticleVendu {
	
	//Propriétés 
	private int no_article;
	private String nom_article;
	private String description;
	private Date date_debut_enchere;
	private Date date_fin_enchere;
	private int prix_initial;
	private int prix_vente;
	private String etat_vente;
	private String image;
	private Categorie categorie;
	private Utilisateur utilisateur;
	
	//Constructeur
	public ArticleVendu(int no_article, String nom_article, String description, Date date_debut_enchere,
			Date date_fin_enchere, int prix_initial, int prix_vente, String etat_vente,
			String image, Categorie categorie, Utilisateur utilisateur) {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_enchere = date_debut_enchere;
		this.date_fin_enchere = date_fin_enchere;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.etat_vente = etat_vente;
		this.image = image;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
	}

	public ArticleVendu() {}
	
	//Accesseurs
	public int getNoArticle() {
		return no_article;
	}

	public void setNoArticle(int no_article) {
		this.no_article = no_article;
	}

	public String getNomArticle() {
		return nom_article;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public void setNomArticle(String nom_article) {
		this.nom_article = nom_article;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_debut_enchere() {
		return date_debut_enchere;
	}

	public void setDate_debut_enchere(Date date_debut_enchere) {
		this.date_debut_enchere = date_debut_enchere;
	}

	public Date getDate_fin_enchere() {
		return date_fin_enchere;
	}

	public void setDate_fin_enchere(Date date_fin_enchere) {
		this.date_fin_enchere = date_fin_enchere;
	}

	public int getMiseAPrix() {
		return prix_initial;
	}

	public void setMiseAPrix(int prix_initial) {
		this.prix_initial = prix_initial;
	}

	public int getPrixVente() {
		return prix_vente;
	}

	public void setPrixVente(int prix_vente) {
		this.prix_vente = prix_vente;
	}

	public String getEtatVente() {
		return etat_vente;
	}

	public void setEtatVente(String etat_vente) {
		this.etat_vente = etat_vente;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
