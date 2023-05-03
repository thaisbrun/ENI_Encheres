package bll;

import dal.DAOFactory;

public class UtilisateurBLL {
	
	private static UtilisateurBLL instance;
	private UtilisateurDAO utlisateurDAO;
	
	private UtilisateurBLL() {
		utilisateurDAO = DAOFactory.getArticleDAO();
	}
	
	public static UtilisateurBLL getInstance() {
		if (UtilisateurBLL.instance == null) {
			UtilisateurBLL.instance = new UtilisateurBLL();
			return instance;
		}
	}
}
