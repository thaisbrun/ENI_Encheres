package bll;

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
	}
}
