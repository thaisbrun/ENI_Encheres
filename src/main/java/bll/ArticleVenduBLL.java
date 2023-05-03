package bll;

import dal.ArticleVenduDAO;
import dal.DAOFactory;

public class ArticleVenduBLL {
	private static ArticleVenduBLL instance;
	private ArticleVenduDAO articleVenduDAO;
	
	private ArticleVenduBLL() {
		ArticleVenduDAO = DAOFactory.getArticleDAO();
	}
	
	public static ArticleVenduBLL getInstance() {
		if (ArticleVenduBLL.instance == null) {
			ArticleVenduBLL.instance = new ArticleVenduBLL();
			return instance;
		}
	}
}
