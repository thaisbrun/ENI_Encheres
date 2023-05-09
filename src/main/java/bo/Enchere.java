package bo;

import java.sql.Date;
import java.time.LocalDate;

public class Enchere {
	
	private int no_utilisateur;
	private int no_article;
	private Date date_enchere;
	private double montant_enchere;
	
	public Enchere(int no_utilisateur, int articleVendu, Date date_enchere,
			double montant_enchere, int no_article) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.no_article = no_article;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	public Enchere() {}

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

	public int getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	
	public int getNo_article() {
		return no_article;
	}

	public void setNo_Article(int no_article) {
		this.no_article = no_article;
	}	
}
