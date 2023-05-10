package dal;

import java.util.List;

import bo.Enchere;


public interface EnchereDAO{
	
	public List<Enchere> selectAll();
	
	public List<Enchere> selectByCategorie(int no_categorie);
}
