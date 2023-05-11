package dal;

import java.util.List;

import bo.Categorie;

/*
 * Définition des méthodes utilisées auprès de la BDD
 */

public interface CategorieDAO {
	List<Categorie> selectAll();
	Categorie selectById(int id);
	void insert(Categorie categorie);
}
