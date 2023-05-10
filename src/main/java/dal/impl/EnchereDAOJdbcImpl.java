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
import dal.ArticleVenduDAO;
import dal.ConnectionProvider;
import dal.EnchereDAO;
import dal.UtilisateurDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO{

	private static final String SELECT_ALL = "SELECT * FROM ENCHERES INNER JOIN UTILISATEURS u ON ENCHERES.no_utilisateur = u.no_utilisateur INNER JOIN ARTICLES_VENDUS a ON ENCHERES.no_article = a.no_article WHERE etat_vente= 'EC' OR etat_vente='CR';";
	private static final String SELECT_BY_ID = "SELECT * FROM ENCHERES WHERE no_article = ? AND no_utilisateur = ?;";
	private static final String SELECT_BY_CATEGORIE = "SELECT * FROM ENCHERES INNER JOIN UTILISATEURS u ON encheres.no_utilisateur=u.no_utilisateur INNER JOIN ARTICLES_VENDUS a ON encheres.no_article = a.no_article WHERE no_categorie = ?;";
	//private static final String SELECT_BY_ID = "SELECT * FROM ENCHERES WHERE no_article = ?;";
	
	UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();
	ArticleVenduDAO articleDAO = new ArticleVenduDAOJdbcImpl();

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
	
	@Override
	public List<Enchere> selectByCategorie(int no_categorie) {
		List<Enchere> listeEncheres = new ArrayList<Enchere>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_CATEGORIE);
			// 3e etape : attribuer les parametres nécessaires à ma requête
			pstmt.setInt(1, no_categorie);
			
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
		System.out.println(rs.getInt("no_utilisateur"));
		Utilisateur utilisateur = utilisateurDAO.selectById(rs.getInt("no_utilisateur"));
		ArticleVendu article = articleDAO.selectById(rs.getInt("no_article"));
		
		enchere=new Enchere();
		enchere.setUtilisateur(utilisateur);
		enchere.setArticle(article);
		enchere.setDateEnchere(rs.getDate("date_enchere"));	
		enchere.setMontant_enchere(rs.getDouble("montant_enchere"));
		System.out.println(article);
		
		return enchere;
	}

	@Override
	public Enchere selectById(int no_utilisateur, int no_article) {
		Enchere enchere = new Enchere();
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_ID);
			
			ps.setInt(1, no_utilisateur);
			ps.setInt(2, no_article);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				enchere = enchereBuilder(rs);
			}
			rs.close();
			ps.close();
			cnx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enchere;
	}
}
