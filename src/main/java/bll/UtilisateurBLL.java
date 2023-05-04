package bll;

import java.util.List;

import bo.Utilisateur;
import dal.DAOFactory;
import dal.UtilisateurDAO;

public class UtilisateurBLL {
	private UtilisateurDAO dao;

	public List<Utilisateur> selectAll() {
		return dao.selectAll();
	}
	
	/*public Utilisateur selectById(int id) {
		return dao.selectById(id);
	}*/
	
	public Utilisateur ajouterUtilisateur(String pseudo,String nom,String prenom,String email,int telephone,String rue,int codePostal, String ville,String motDePasse)
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
				this.dao.insert(utilisateur);
				
			return utilisateur;
		}
	}

