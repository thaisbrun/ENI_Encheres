package bll;

import dal.DAOFactory;
import dal.UtilisateurDAO;

public class UtilisateurBLL {
	private static UtilisateurBLL instance;
	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurBLL() {
		enchereDAO = DAOFactory.getArticleDAO();
	}
	
<<<<<<< Upstream, based on branch 'master' of https://github.com/thaisbrun/ENI_Encheres.git
	public static UtilisateurBLL getInstance() {
		if (UtilisateurBLL.instance == null) {
			UtilisateurBLL.instance = new UtilisateurBLL();
		return instance;
		}
=======
	/*public List<Utilisateur> selectAll() {
		return dao.selectAll();
	}
	
	public Utilisateur selectById(int id) {
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

>>>>>>> 18b75b6 Inscription OK
	}

