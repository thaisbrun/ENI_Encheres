package bo;

import java.time.LocalDateTime;

public class Enchere {
	
	private LocalDateTime dateEnchere;
	private double montant_enchère;
	private Utilisateur utilisateur;
	private ArticleVendu articleVendu;
	
	public Enchere(LocalDateTime dateEnchere, double montant_enchère, Utilisateur utilisateur,
			ArticleVendu articleVendu) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchère = montant_enchère;
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
	}
	
	public Enchere() {}

	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDateTime dateEnchere) {
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
