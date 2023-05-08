package dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bll.ArticleVenduBLL;
import bll.UtilisateurBLL;
import bo.ArticleVendu;
import bo.Enchere;
import bo.Utilisateur;
import dal.ConnectionProvider;
import dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO{
	private static final String SELECT_ALL = "SELECT * FROM ENCHERES INNER JOIN UTILISATEURS u ON encheres.no_utilisateur=u.no_utilisateur; ";
	//private static final String SELECT_BY_ID = "SELECT * FROM ENCHERES WHERE no_article = ?;";
	
	private ArticleVenduBLL articleVenduBLL;
	private UtilisateurBLL utilisateurBLL;

	@Override
	public List<Enchere> selectAll() {
		List<Enchere> listeEncheres = new ArrayList<Enchere>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			Enchere enchere=new Enchere();
			while(rs.next())
			{
				enchere = enchereBuilder(rs);
				listeEncheres.add(enchere);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listeEncheres;

}
	private Enchere enchereBuilder(ResultSet rs) throws SQLException {
		Enchere enchere;
		enchere=new Enchere();
		enchere.setNo_utilisateur(rs.getInt("no_utilisateur"));
		enchere.setNo_Article(rs.getInt("no_article"));
		enchere.setDateEnchere(rs.getDate("date_enchere"));	
		enchere.setMontant_enchere(rs.getDouble("montant_enchere"));
		return enchere;
	}
}
