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

/*
 * Implémentation des méthodes proposées par EnchereDAO
 */
public class EnchereDAOJdbcImpl implements EnchereDAO{

	private static final String SELECT_ALL = "SELECT * FROM ENCHERES INNER JOIN UTILISATEURS u ON ENCHERES.no_utilisateur = u.no_utilisateur INNER JOIN ARTICLES_VENDUS a ON ENCHERES.no_article = a.no_article;";
	private static final String SELECT_BY_ID = "SELECT * FROM ENCHERES WHERE no_article = ? AND no_utilisateur = ?;";
	private static final String SELECT_BY_CATEGORIE = "SELECT * FROM ENCHERES INNER JOIN UTILISATEURS u ON encheres.no_utilisateur=u.no_utilisateur INNER JOIN ARTICLES_VENDUS a ON encheres.no_article = a.no_article WHERE no_categorie = ? AND nom_article LIKE ?;";

	UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();
	ArticleVenduDAO articleDAO = new ArticleVenduDAOJdbcImpl();

	@Override
	public List<Enchere> selectAll() {
		List<Enchere> listeEncheres = new ArrayList<Enchere>();
		//Ouverture de la connexion
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			//Préparation de la requête
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			//Exécution de la requête
			ResultSet rs = pstmt.executeQuery();
			Enchere enchere=new Enchere();
			//Ajout des objets dans la liste
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
	public List<Enchere> selectByCategorie(int no_categorie, String nom_article) {
		List<Enchere> listeEncheres = new ArrayList<Enchere>();
		//Ouverture de la connexion
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			//Préparation de la requête
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_CATEGORIE);
			pstmt.setInt(1, no_categorie);
			pstmt.setString(2, "%" + nom_article + "%");
			//Exécution de la requête
			ResultSet rs = pstmt.executeQuery();
			Enchere enchere=new Enchere();
			//Ajout des objets à la liste
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
		Utilisateur utilisateur = utilisateurDAO.selectById(rs.getInt("no_utilisateur"));
		ArticleVendu article = articleDAO.selectById(rs.getInt("no_article"));
		
		enchere=new Enchere();
		enchere.setUtilisateur(utilisateur);
		enchere.setArticle(article);
		enchere.setDateEnchere(rs.getDate("date_enchere"));	
		enchere.setMontant_enchere(rs.getDouble("montant_enchere"));
		System.out.println("Article:" + article + " - article.utilisateur: " + utilisateur);
		
		return enchere;
	}

	@Override
	public Enchere selectById(int no_utilisateur, int no_article) {
		Enchere enchere = new Enchere();
		//Ouverture de la connexion BDD
		try (Connection cnx = ConnectionProvider.getConnection();) {
			//Préparation de la requête
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_ID);
			
			ps.setInt(1, no_utilisateur);
			ps.setInt(2, no_article);
			
			//Exécution de la requête
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
