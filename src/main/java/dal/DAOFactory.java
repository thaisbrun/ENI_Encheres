package dal;

/*
 * Role : donner un accès aux instances des DAO
 */
public abstract class DAOFactory {
	private static CategorieDAO categorieDAO;
	private static UtilisateurDAO utilisateurDAO;
	
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
}
