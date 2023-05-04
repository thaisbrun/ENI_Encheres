package dal;


import bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur utilisateur);
	
	/*public void update(Utilisateur utilisateur) throws DALException;
	
	public void delete(int noUtilisateur) throws DALException;*/
	
	public Utilisateur selectById(int noUtilisateur);
	
	public Utilisateur connexionByLogin(String pseudo, String motDePasse);
	
	//public List<Utilisateur> selectAll();
}
