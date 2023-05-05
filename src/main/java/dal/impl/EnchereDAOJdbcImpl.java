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
	private static final String SELECT_ALL = "SELECT * FROM ENCHERES";
	//private static final String SELECT_BY_ID = "SELECT µ FROM ENCHERES WHERE no_article = ?;";
	
	private ArticleVenduBLL articleVenduBLL;
	private UtilisateurBLL utilisateurBLL;

	@Override
	public List<Enchere> selectAll() {
		List<Enchere> resultats = new ArrayList<>();
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement ps = cnx.prepareStatement(SELECT_ALL);
		
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getInt("no_utilisateur"));
				Utilisateur utilisateur = utilisateurBLL.selectById(rs.getInt("no_utilisateur"));
				ArticleVendu article = articleVenduBLL.selectById(rs.getInt("no_article"));
				
				Enchere enchere = new Enchere();
				enchere.setUtilisateur(utilisateur);
				enchere.setArticleVendu(article);
				enchere.setDateEnchere(rs.getDate("date_enchere").toLocalDate());
				enchere.setMontant_enchère(rs.getInt("montant_enchere"));
				
				resultats.add(enchere);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultats;
	}

}
