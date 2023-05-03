package dal;

import java.util.List;

import bo.Utilisateur;

/*
 * Définition des méthodes utilisées auprès de la BDD
 */
public interface UtilisateurDAO {
	List<Utilisateur> selectAll();
	Utilisateur selectById(int id);
	void insert(Utilisateur utilisateur);
}
