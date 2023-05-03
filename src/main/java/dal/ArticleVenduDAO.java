package dal;

import java.util.List;

import bo.ArticleVendu;

public class ArticleVenduDAO {
	
	public void insert(ArticleVendu articleVendu) throws DALException;
	
	public void update(ArticleVendu articleVendu) throws DALException;
	
	public void delete(int noArticle) throws DALException;
	
	public ArticleVendu selectById(Integer noArticle) throws DALException;
	
	public List<ArticleVendu> selectAll() throws DALException;
	
}
