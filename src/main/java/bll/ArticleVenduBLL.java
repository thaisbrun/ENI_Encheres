package bll;

import bo.ArticleVendu;
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
}
