package bll;

import java.util.Date;

import bo.ArticleVendu;
import bo.Categorie;
import bo.Utilisateur;
import dal.ArticleVenduDAO;
import dal.DAOFactory;

public class ArticleVenduBLL {
	private ArticleVenduDAO dao;
	
	public ArticleVenduBLL() {
		dao = DAOFactory.getArticleVenduDAO();
	}
	
	public ArticleVendu selectById(int id) {
		return dao.selectById(id);
	}
	
	public ArticleVendu ajouterArticleVendu(String nom_article,String description,Date date_debut_enchere,Date date_fin_enchere,Integer prix_initial, Utilisateur utilisateur, Categorie categorie) throws BLLException
	{
		
		ArticleVendu articleVendu = null;
			articleVendu = new ArticleVendu();
			articleVendu.setNomArticle(nom_article);
			articleVendu.setDescription(description);
			articleVendu.setDate_debut_enchere(date_debut_enchere);
			articleVendu.setDate_fin_enchere(date_fin_enchere);
			articleVendu.setMiseAPrix(prix_initial);
			articleVendu.setCategorie(categorie);
			articleVendu.setUtilisateur(utilisateur);
			this.dao.insert(articleVendu);
				
		return articleVendu;
	}

}
