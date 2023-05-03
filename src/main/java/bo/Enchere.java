package bo;

import java.time.LocalDateTime;

public class Enchere {
	
	private LocalDateTime dateEnchere;
	private double montant_enchère;
	
	public Enchere(LocalDateTime dateEnchere, double montant_enchère) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchère = montant_enchère;
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
}
