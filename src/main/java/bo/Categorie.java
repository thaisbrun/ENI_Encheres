package bo;

public class Categorie {
	
	//Propriétés
	private int numero;	
	private String libelle;
	
	//Constructeur
	public Categorie() {
	}

	public Categorie(int numero, String libelle) {
		super();
		this.numero = numero;
		this.libelle = libelle;
	}
	
	//Accesseurs
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
}
