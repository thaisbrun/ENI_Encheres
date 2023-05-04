package dal;

import java.util.List;

import bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur utilisateur);
	
	/*public void update(Utilisateur utilisateur) throws DALException;
	
	public void delete(int noUtilisateur) throws DALException;
	
	public Utilisateur selectById(Integer noUtilisateur) throws DALException;*/
	
	public List<Utilisateur> selectAll();
}
