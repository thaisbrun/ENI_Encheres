package dal;

import java.util.List;

import bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur utilisateur) throws DALException;
	
	public void update(Utilisateur utilisateur) throws DALException;
	
	public void delete(int noArticle) throws DALException;
	
	public Utilisateur selectById(Integer noArticle) throws DALException;
	
	public List<Utilisateur> selectAll() throws DALException;
}
