package bll;

import java.sql.SQLException;
import java.util.List;

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

	public Utilisateur selectById(int id) {
		return dao.selectById(id);
	}
	
	public Utilisateur ajouterUtilisateur(String pseudo,String nom,String prenom,String email,String telephone,String rue,String codePostal, String ville,String motDePasse) throws BLLException{
		
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
	
	public Utilisateur getPseudoOrEmailDuplicata(String type, Utilisateur user) {
		if(type.equals("pseudo")) {
			return user;
		}
		if(type.equals("email")) {
			return user;
		}
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
		if (utilisateur.getTelephone() == null || utilisateur.getTelephone().isBlank()) {
			throw new BLLException("Le téléphone ne peut pas être vide");
		}
		if (utilisateur.getRue() == null || utilisateur.getRue().isBlank()) {
			throw new BLLException("La rue ne peut pas être vide");
		}
		if (utilisateur.getCodePostal() == null || utilisateur.getCodePostal().isBlank()) {
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
		//Requete pour selectionner tout les utilisateurs dont le pseudo est égale à ...
		//Requete pour selectionner tout les utilisateurs dont l'email est eagale à ... 
		List<Utilisateur> results = dao.selectAll();
		
		for(Utilisateur user : results) {
			System.out.println("validationAjoutUtilisateur [BDD] - Pseudo: " + user.getPseudo() + " / Email: " + user.getEmail());
			System.out.println("validationAjoutUtilisateur [USER] - Pseudo: " + utilisateur.getPseudo() + " / Email: " + utilisateur.getEmail());
			
			if(user.getPseudo().equals(utilisateur.getPseudo())) {
				System.out.println("validationAjoutUtilisateur - PSEUDO");
				throw new BLLException("Le pseudo est déja pris");
			}
			if(user.getEmail().equals(utilisateur.getEmail())) {
				System.out.println("validationAjoutUtilisateur - EMAIL");
				throw new BLLException("L'email est déja liée à un autre utilisateur");
			}
			//Vérificatrion mdp1 & mdp2 sont égaux
		}
	}
	
	public Boolean isAlphanumerique(String str) {
		Boolean isAlpha = false;
		if (str.matches(".*[A-Za-z].*") && str.matches(".*[0-9].*") && str.matches("[A-Za-z0-9]*")) {
		    isAlpha = true;
		}
		return isAlpha;
	}
}



