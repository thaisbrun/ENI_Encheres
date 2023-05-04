package dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bll.ArticleVenduBLL;
import bll.EnchereBLL;
import bll.UtilisateurBLL;
import bo.ArticleVendu;
import bo.Enchere;
import dal.ConnectionProvider;
import dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO{
	private static final String SELECT_ALL = "SELECT * FROM ENCHERES";
	//private static final String SELECT_BY_ID = "SELECT µ FROM ENCHERES WHERE no_article = ?;";
	
	private ArticleVenduBLL articleVenduBLL;
	private UtilisateurBLL utilisateurBLL;
			
	@Override
	public void insert(Enchere articleVendu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Enchere articleVendu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int noArticle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Enchere selectById(Integer noArticle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> selectAll() {
		List<Enchere> resultat = new ArrayList<>();
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement ps = cnx.prepareStatement(SELECT_ALL);
		
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ArticleVendu article = articleVenduBLL.selectById(rs.getInt("no_article"));
				Utilisateur utilisateur = 
				
				Enchere enchere = new Enchere(); //Utilisateur / ArticleVendu / date / montant
				//enchere.setId(rs.getInt("id"));
				//enchere.setNom(rs.getString("nom"));
				resultat.add(enchere);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

}
