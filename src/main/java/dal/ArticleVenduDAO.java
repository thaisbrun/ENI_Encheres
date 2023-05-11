package dal;

import bo.ArticleVendu;

public interface ArticleVenduDAO {
	
	public ArticleVendu selectById(int noArticle);
	public void insert(ArticleVendu articleVendu);
	public void update (ArticleVendu article);

}
