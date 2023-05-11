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

/*
 * Implémentation des méthodes proposées par ArticleVenduDAO
 */
public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	
	//Requêtes SQL
	private static final String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?;";
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS(nom_article,description,date_debut_enchere,date_fin_enchere,prix_initial,prix_vente,no_utilisateur,no_categorie,etat_vente,image) VALUES(?,?,?,?,?,null,?,?,'CR',?)";
	private static final String UPDATE ="UPDATE ARTICLES_VENDUS SET nom_article = ?, description=?, date_debut_enchere=?, date_fin_enchere=? , prix_initial=? WHERE no_article = ?;";
	
	UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();
	CategorieDAO categorieDAO = new CategorieDAOJdbcImpl();

	@Override
	public void insert(ArticleVendu articleVendu) {
		// Ouverture de la connexion à la BDD
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// Préparation de la requête
			PreparedStatement ps = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			// Execution de la requête et interpretation des résultats
			ps.setString(1, articleVendu.getNomArticle());
			ps.setString(2, articleVendu.getDescription());
			ps.setDate(3, new java.sql.Date(articleVendu.getDate_debut_enchere().getTime()));
			ps.setDate(4, new java.sql.Date(articleVendu.getDate_fin_enchere().getTime()));
			ps.setInt(5, (int) articleVendu.getMiseAPrix());
			ps.setObject(6, articleVendu.getUtilisateur().getNo_utilisateur());
			ps.setObject(7, articleVendu.getCategorie().getNumero());
			ps.setString(8, articleVendu.getImage());
			ps.executeUpdate();
			//On génère une clé primaire 
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
		// On ouvre la connexion à la BDD
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// Préparation de la requête
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_ID);
			// Execution de la requête et interpretation des résultats
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

	@Override
	public void update(ArticleVendu article) {
		// 1e etape : ouvrir la connexion a la bdd
				try (Connection cnx = ConnectionProvider.getConnection();) {
					// 2e etape : preparer la requete SQL qu'on souhaite executer
					PreparedStatement ps = cnx.prepareStatement(UPDATE);
					// 4e etape : execution de la requete et interpretation des resultats
					
					ps.setString(1, article.getNomArticle());
					ps.setString(2, article.getDescription());
					ps.setDate(3, new java.sql.Date(article.getDate_debut_enchere().getTime()));
					ps.setDate(4, new java.sql.Date(article.getDate_fin_enchere().getTime()));
					ps.setInt(5, article.getMiseAPrix());
					ps.setInt(6, article.getNoArticle());
					ps.executeUpdate();
					cnx.commit();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
	}

}
