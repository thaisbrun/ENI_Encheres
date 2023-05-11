package bll;

import bo.Enchere;
import bo.Utilisateur;
import dal.DAOFactory;
import dal.UtilisateurDAO;

public class UtilisateurBLL {
	private static UtilisateurBLL instance;
	private UtilisateurDAO dao;
	
	public UtilisateurBLL() {
		dao = DAOFactory.getUtilisateurDAO(); 
	}
	
	public static UtilisateurBLL getInstance() {
		if (UtilisateurBLL.instance == null) {
			UtilisateurBLL.instance = new UtilisateurBLL();
		}
		return instance;
	}
	
	public Utilisateur connexionByLogin(String pseudo, String motDePasse) {		
		return dao.connexionByLogin(pseudo, motDePasse);
	}

	public Utilisateur selectByLoginOnly(String pseudo) {
		return dao.selectByLoginOnly(pseudo);
	}

	public Utilisateur selectByEmailOnly(String email) {
		return dao.selectByLoginOnly(email);
	}
	
	public Utilisateur selectById(int no_utilisateur) {
		return dao.selectById(no_utilisateur);
	}
	
	public Utilisateur ajouterUtilisateur(String pseudo,String nom,String prenom,String email,String telephone,String rue,String codePostal, String ville,String motDePasse) throws BLLException
	{
		
		Utilisateur utilisateur = null;
			utilisateur = new Utilisateur();
			utilisateur.setPseudo(pseudo);
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setRue(rue);
			utilisateur.setCodePostal(codePostal);
			utilisateur.setEmail(email);
			utilisateur.setMotDePasse(motDePasse);
			utilisateur.setTelephone(telephone);
			utilisateur.setVille(ville);
			
			validationGeneral(utilisateur);
			
			this.dao.insert(utilisateur);
				
		return utilisateur;
	}

	public Utilisateur ModifierUtilisateur(String pseudo,String nom,String prenom,String email,String telephone,String rue,String codePostal, String ville,String motDePasse)
	{
		
		Utilisateur utilisateur = selectByLoginOnly(pseudo);
		
			utilisateur.setPseudo(pseudo);
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setRue(rue);
			utilisateur.setCodePostal(codePostal);
			utilisateur.setEmail(email);
			utilisateur.setMotDePasse(motDePasse);
			utilisateur.setTelephone(telephone);
			utilisateur.setVille(ville);
			this.dao.update(utilisateur);
			
		return utilisateur;
	}

	public Utilisateur SupprimerUtilisateur(int no_utilisateur)
	{
		
		Utilisateur utilisateur = selectById(no_utilisateur);
		utilisateur.setNo_utilisateur(no_utilisateur);
			this.dao.delete(utilisateur);
			
		return utilisateur;
	}
	
	public String formatAdresse(Utilisateur utilisateur) {
		String rue = utilisateur.getRue();
		String ville = utilisateur.getVille();	
		String codePostal = utilisateur.getCodePostal();
		
		return rue + ", " + ville + " " + codePostal;
	}
	
	//VERIFICATIONS
	public void validationGeneral(Utilisateur utilisateur) throws BLLException {
		
		if (utilisateur.getPseudo() == null || utilisateur.getPseudo().isBlank() || isAlphanumerique(utilisateur.getPseudo().toString())) {
			throw new BLLException("Le pseudo ne peut pas être vide et ne peut etre composé uniquement de lettres & chiffres");
		}
		if (utilisateur.getPrenom() == null || utilisateur.getPrenom().isBlank()) {
			throw new BLLException("Le prenom ne peut pas être vide");
		}
		if (utilisateur.getNom() == null || utilisateur.getNom().isBlank()) {
			throw new BLLException("Le nom ne peut pas être vide");
		}
		if (utilisateur.getEmail() == null || utilisateur.getEmail().isBlank()) {
			throw new BLLException("L'email ne peut pas être vide");
		}
		if (utilisateur.getTelephone() == null || utilisateur.getTelephone().isBlank() || !utilisateur.getTelephone().matches("[0-9]+")) {
			throw new BLLException("Le téléphone ne peut pas être vide et ne peut etre composé uniquement de nombres");
		}
		if (utilisateur.getRue() == null || utilisateur.getRue().isBlank()) {
			throw new BLLException("La rue ne peut pas être vide");
		}
		if (utilisateur.getCodePostal() == null || utilisateur.getCodePostal().isBlank()){
			throw new BLLException("Le code postal ne peut pas être vide");
		}
		if (utilisateur.getVille() == null || utilisateur.getVille().isBlank()) {
			throw new BLLException("La ville ne peut pas être vide");
		}
		if (utilisateur.getMotDePasse() == null || utilisateur.getMotDePasse().isBlank()) {
			throw new BLLException("Le mot de passe ne peut pas être vide");
		}
		
		validationAjouterUtilisateur(utilisateur);
	}
	
	public void validationAjouterUtilisateur(Utilisateur utilisateur) throws BLLException{
		
		Utilisateur resultLogin = selectByLoginOnly(utilisateur.getPseudo());
		
		if(resultLogin != null) {
		throw new BLLException("le pseudo est déja pris");
		}
		
		Utilisateur resultEmail = selectByEmailOnly(utilisateur.getEmail());
		System.out.println("2 " + resultEmail);
		if(resultEmail != null) {
			throw new BLLException("L'email est déja liée à un autre utilisateur");
		}
	}
	
	public void validationFaireEnchere(Utilisateur vendeur, Utilisateur utilisateurConnecete, Enchere enchere) throws BLLException{
		if(!estVendeur(vendeur, utilisateurConnecete)) {
			throw new BLLException("Vous ne pouvez pas enchérir sur un article que vous etes activement en train de vendre");
		}
		if(utilisateurConnecete.getCredit() > enchere.getMontant_enchere());{
			throw new BLLException("Vous n'avez pas les crédits suffisants pour enchérir sur cette article");
		}
	}
	
	public void validationModifEnchere(Utilisateur vendeur, Utilisateur utilisateurConnecete) throws BLLException{
		if(estVendeur(vendeur, utilisateurConnecete)) {
			throw new BLLException("Vous ne pouvez pas modifier une enchere dont vous n'etes pas le vendeur");
		}
	}
	
	public boolean estVendeur(Utilisateur vendeur, Utilisateur utilisateurConnecete) {
		boolean estVendeur = false;
		if(utilisateurConnecete == vendeur) {
			estVendeur = true;
		}
		return estVendeur;
	}
	
	public Boolean isAlphanumerique(String str) {
		Boolean isAlpha = false;
		if (str.matches(".*[A-Za-z].*") && str.matches(".*[0-9].*") && str.matches("[A-Za-z0-9]*")) {
		    isAlpha = true;
		}
		return isAlpha;
	}
	
	public void isMotDePasseValide(String mp, String mp2 ) throws BLLException{
		if(mp != mp2 || mp2.isEmpty()) {
			throw new BLLException("Vérifier que vous avez remplis le deuxieme mot de passe et qu'il correspond a votre mot de passe");
		}
	}
}



