package dal;

import java.util.List;

import bo.Enchere;

/*
 * Définition des méthodes utilisées auprès de la BDD
 */

public interface EnchereDAO{
	
	public List<Enchere> selectAll();

	public Enchere selectById(int no_utilisateur, int no_article);
	
	public List<Enchere> selectByCategorie(int no_categorie, String nom_article);
}
