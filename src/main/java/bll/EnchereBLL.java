package bll;

import dal.DAOFactory;

public class EnchereBLL {
	private static EnchereBLL instance;
	private EnchereDAO enchereDAO;
	
	private EnchereBLL() {
		enchereDAO = DAOFactory.getArticleDAO();
	}
	
	public static EnchereBLL getInstance() {
		if (EnchereBLL.instance == null) {
			EnchereBLL.instance = new EnchereBLL();
		return instance;
	}
}
