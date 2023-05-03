package bll;

import dal.DAOFactory;
import dal.UtilisateurDAO;

public class UtilisateurBLL {
	private static UtilisateurBLL instance;
	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurBLL() {
		enchereDAO = DAOFactory.getArticleDAO();
	}
	
	public static UtilisateurBLL getInstance() {
		if (UtilisateurBLL.instance == null) {
			UtilisateurBLL.instance = new UtilisateurBLL();
		return instance;
		}
	}
}
