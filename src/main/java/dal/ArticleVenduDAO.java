package dal;

import bo.ArticleVendu;

/*
 * Définition des méthodes utilisées auprès de la BDD
 */

public interface ArticleVenduDAO {
	
	public ArticleVendu selectById(int noArticle);
	public void insert(ArticleVendu articleVendu);
	public void update (ArticleVendu article);

}
