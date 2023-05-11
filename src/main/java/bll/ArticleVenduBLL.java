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
	
	public ArticleVendu selectById(int no_article) {
		return dao.selectById(no_article);
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
	
	public void modifierArticleVendu(String nomArticle, String description, Date debut, Date fin, int prixInitial, int no_article) {
		ArticleVenduBLL articleBLL = new ArticleVenduBLL();
		ArticleVendu article = articleBLL.selectById(no_article);
		
		article.setNomArticle(nomArticle);
		article.setDescription(description);
		article.setDate_debut_enchere(debut);
		article.setDate_fin_enchere(fin);
		article.setMiseAPrix(prixInitial);
		
		this.dao.update(article);
	}
	
	//VERIFICATION
	public void validationEnchere(ArticleVendu article) throws BLLException{
		Date now = new Date();
		if(!article.getEtatVente().equals("VD")) {
			throw new BLLException("L'article à déja été vendu, vous ne pouvez donc ni enchérir, ni éditer l'article");
		}
		if(article.getDate_debut_enchere().before(now)) {
			throw new BLLException("L'enchere est déja en cours, vous ne pouvez donc plus la modifier");
		}
	}

}
