package bll;

<<<<<<< Upstream, based on branch 'master' of https://github.com/thaisbrun/ENI_Encheres.git
import dal.DAOFactory;
import dal.UtilisateurDAO;

public class UtilisateurBLL {
	
	private static UtilisateurBLL instance;
	private UtilisateurDAO utlisateurDAO;
	
	private UtilisateurBLL() {
		utlisateurDAO = DAOFactory.getArticleDAO();
	}
	
	public static UtilisateurBLL getInstance() {
		if (UtilisateurBLL.instance == null) {
			UtilisateurBLL.instance = new UtilisateurBLL();
			return instance;
		}
=======
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
>>>>>>> ffe2802 Commit debut aprem
	}
}
