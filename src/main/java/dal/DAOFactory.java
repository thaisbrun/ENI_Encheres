package dal;

import dal.impl.CategorieDAOJdbcImpl;
import dal.impl.UtilisateurDAOJdbcImpl;

/*
 * Role : donner un accès aux instances des DAO
 */
public abstract class DAOFactory {
	
	private static CategorieDAO categorieDAO;
	private static UtilisateurDAO utilisateurDAO;
	private static EnchereDAO enchereDAO;
	
	public static CategorieDAO getCategorieDAO() {
		if (categorieDAO == null) {
			categorieDAO = new CategorieDAOJdbcImpl();
		}
		return categorieDAO;
	}
	
	public static UtilisateurDAO getUtilisateurDAO() {
		if (utilisateurDAO == null) {
			utilisateurDAO = new UtilisateurDAOJdbcImpl();
		}
		return utilisateurDAO;
	}
	
	public static EnchereDAO getEnchereDAO() {
		if (enchereDAO == null) {
			enchereDAO = new EnchereDAOJdbcImpl();
		}
		return enchereDAO;
	}
}
