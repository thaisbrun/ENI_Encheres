package dal;

import java.util.List;

import bo.Enchere;


public interface EnchereDAO{
	
	public void insert(Enchere articleVendu);
	
	public void update(Enchere articleVendu);
	
	public void delete(int noArticle);
	
	public Enchere selectById(Integer noArticle);
	
	public List<Enchere> selectAll();
}
