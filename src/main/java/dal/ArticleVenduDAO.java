package dal;

import java.util.List;

import bo.ArticleVendu;

public interface ArticleVenduDAO {
	
	public void insert(ArticleVendu articleVendu);
	
	public void update(ArticleVendu articleVendu);
	
	public void delete(int noArticle);
	
	public ArticleVendu selectById(Integer noArticle);
	
	public List<ArticleVendu> selectAll();
}
