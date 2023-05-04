package bo;

import java.time.LocalDate;

public class Enchere {
	
	private Utilisateur utilisateur;
	private ArticleVendu articleVendu;
	private LocalDate dateEnchere;
	private double montant_enchère;
	
	public Enchere(Utilisateur utilisateur, ArticleVendu articleVendu, LocalDate dateEnchere,
			double montant_enchère) {
		super();
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
		this.dateEnchere = dateEnchere;
		this.montant_enchère = montant_enchère;
	}

	public Enchere() {}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public double getMontant_enchère() {
		return montant_enchère;
	}

	public void setMontant_enchère(double montant_enchère) {
		this.montant_enchère = montant_enchère;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}
	
	
	
}
