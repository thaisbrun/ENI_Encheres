package dal;


import bo.Utilisateur;
import java.util.List;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur utilisateur);
	
	public void update(Utilisateur utilisateur);
	
	/*public void update(Utilisateur utilisateur) throws DALException; */
	
	public void delete(Utilisateur utilisateur);

	public Utilisateur selectById(int no_utilisateur);
	
	public Utilisateur selectByLoginOnly(String pseudo);
	
	public Utilisateur selectByEmailOnly(String email);
	
	public Utilisateur connexionByLogin(String pseudo, String motDePasse);
	
	public List<Utilisateur> selectAll();
}
