package dal;

import dal.impl.CategorieDAOJdbcImpl;

/*
 * Role : donner un accès aux instances des DAO
 */
public abstract class DAOFactory {
	private static CategorieDAO categorieDAO;
	
	public static CategorieDAO getCategorieDAO() {
		if (categorieDAO == null) {
			categorieDAO = new CategorieDAOJdbcImpl();
		}
		return categorieDAO;
	}
}
