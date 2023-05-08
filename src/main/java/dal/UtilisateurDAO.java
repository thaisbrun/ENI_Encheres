package dal;


import bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur utilisateur);
	
	public void update(Utilisateur utilisateur);
	
	/*public void update(Utilisateur utilisateur) throws DALException; */
	
	public void delete(Utilisateur utilisateur);
	
	public Utilisateur selectByLoginOnly(String pseudo);
	
	public Utilisateur connexionByLogin(String pseudo, String motDePasse);
	
	//public List<Utilisateur> selectAll();
}
