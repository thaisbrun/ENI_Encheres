package dal.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.ArticleVendu;
import bo.Categorie;
import bo.Enchere;
import bo.Utilisateur;
import dal.ArticleVenduDAO;
import dal.CategorieDAO;
import dal.ConnectionProvider;
import dal.UtilisateurDAO;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	private static final String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?;";
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS(nom_article,description,date_debut_enchere,date_fin_enchere,prix_initial,prix_vente,no_utilisateur,no_categorie,etat_vente,image) VALUES(?,?,?,?,?,null,?,?,'CR',?)";
	
	UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();
	CategorieDAO categorieDAO = new CategorieDAOJdbcImpl();

	@Override
	public void insert(ArticleVendu articleVendu) {
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			// 4e etape : execution de la requete et interpretation des resultats
			ps.setString(1, articleVendu.getNomArticle());
			ps.setString(2, articleVendu.getDescription());
			ps.setDate(3, new java.sql.Date(articleVendu.getDate_debut_enchere().getTime()));
			ps.setDate(4, new java.sql.Date(articleVendu.getDate_fin_enchere().getTime()));
			ps.setInt(5, (int) articleVendu.getMiseAPrix());
			ps.setObject(6, articleVendu.getUtilisateur().getNo_utilisateur());
			ps.setObject(7, articleVendu.getCategorie().getNumero());
			ps.setString(8, articleVendu.getImage());
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next())
			{
				articleVendu.setNoArticle(rs.getInt(1));
			}
			rs.close();
			ps.close();
			cnx.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArticleVendu selectById(int noArticle) {

		ArticleVendu resultat = null;
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_ID);
			
			ps.setInt(1, noArticle);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Utilisateur utilisateur = utilisateurDAO.selectById(rs.getInt("no_utilisateur"));
				Categorie categorie = categorieDAO.selectById(rs.getInt("no_categorie"));
				
				resultat = new ArticleVendu();
				resultat.setNoArticle(rs.getInt("no_article"));
				resultat.setNomArticle(rs.getString("nom_article"));
				resultat.setDescription(rs.getString("description"));
				resultat.setDate_debut_enchere(rs.getDate("date_debut_enchere"));
				resultat.setDate_fin_enchere(rs.getDate("date_fin_enchere"));
				resultat.setMiseAPrix(rs.getInt("prix_initial"));
				resultat.setPrixVente(rs.getInt("prix_vente"));
				resultat.setUtilisateur(utilisateur);
				resultat.setCategorie(categorie);
				resultat.setEtatVente(rs.getString("etat_vente"));
				resultat.setImage(rs.getString("image"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

}
