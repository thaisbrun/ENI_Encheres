package bll;

import dal.ArticleVenduDAO;
import dal.DAOFactory;

public class ArticleVenduBLL {
	private ArticleVenduDAO articleVenduDAO;
	
	public ArticleVenduBLL() {
		articleVenduDAO = DAOFactory.getArticleVenduDAO();
	}
	
	
	
	
}
