package dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.ArticleVendu;
import bo.Enchere;
import bo.Utilisateur;
import dal.ArticleVenduDAO;
import dal.ConnectionProvider;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	private static final String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?;";

	@Override
	public ArticleVendu selectById(int noArticle) {

		ArticleVendu resultat = null;
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_ID);
			
			ps.setInt(1, noArticle);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Utilisateur utilisateur = new Utilisateur()
				
				resultat = new ArticleVendu();
				resultat.setNoArticle(rs.getInt("no_article"));
				resultat.setNomArticle(rs.getString("nom_article"));
				resultat.setDescription(rs.getString("description"));
				resultat.setDateDebutEncheres(rs.getDate("date_debut_enchere"));
				resultat.setDateFinEncheres(rs.getDate("date_fin_enchere"));
				resultat.setMiseAPrix(rs.getDouble("prix_initial"));
				resultat.setPrixVente(rs.getDouble("prix_vente"));
				resultat.setUtilisateur(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

}
