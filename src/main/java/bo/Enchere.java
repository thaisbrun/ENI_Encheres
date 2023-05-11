package bo;

import java.sql.Date;

public class Enchere {
	
	//Propriétés
	private Utilisateur utilisateur;
	private ArticleVendu article;
	private Date date_enchere;
	private double montant_enchere;
	
	//Constructeur
	public Enchere(Utilisateur no_utilisateur, int articleVendu, Date date_enchere,
			double montant_enchere, ArticleVendu no_article) {
		super();
		this.utilisateur = no_utilisateur;
		this.article = no_article;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	public Enchere() {}

	//Accesseurs
	public Date getDateEnchere() {
		return date_enchere;
	}

	public void setDateEnchere(Date date_enchere) {
		this.date_enchere = date_enchere;
	}

	public double getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(double montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur no_utilisateur) {
		this.utilisateur = no_utilisateur;
	}
	
	public ArticleVendu getArticle() {
		return article;
	}

	public void setArticle(ArticleVendu no_article) {
		this.article = no_article;
	}	
}
