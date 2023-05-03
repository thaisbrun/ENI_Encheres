package bll;
import java.util.List;

import bo.Utilisateur;
import dal.DAOFactory;
import dal.UtilisateurDAO;

public class UtilisateurBLL {
	private UtilisateurDAO dao;
	
	public UtilisateurBLL() {
		dao = DAOFactory.getUtilisateurDAO();
	}
	
	public List<Utilisateur> selectAll() {
		return dao.selectAll();
	}
	
	public Utilisateur selectById(int id) {
		return dao.selectById(id);
	}
	
	public void insert(Utilisateur utilisateur) {
		dao.insert(utilisateur);
	}
}
