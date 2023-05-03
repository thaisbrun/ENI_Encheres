package bo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Categorie {
	private int numero;	
	private String libelle;
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public Categorie() {
	}

	public Categorie(int numero, String libelle) {
		super();
		this.numero = numero;
		this.libelle = libelle;
	}
}
