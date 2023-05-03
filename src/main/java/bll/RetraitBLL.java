package bll;

import dal.DAOFactory;

public class RetraitBLL {
	
	private static RetraitBLL instance;
	private RetraitDAO retraitDAO;
	
	private RetraitBLL() {
		retraitDAO = DAOFactory.getArticleDAO();
	}
	
	public static RetraitBLL getInstance() {
		if (RetraitBLL.instance == null) {
			RetraitBLL.instance = new RetraitBLL();
			return instance;
		}
	}
}
