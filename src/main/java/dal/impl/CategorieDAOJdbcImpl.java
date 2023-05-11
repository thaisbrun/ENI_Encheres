package dal.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import bo.Categorie;
import bo.Enchere;
import dal.CategorieDAO;
import dal.ConnectionProvider;

/*
 * Implémentation des méthodes proposées par CategorieDAO
 */
public class CategorieDAOJdbcImpl implements CategorieDAO {
	//Requêtes SQL
	private static final String SELECT_ALL = "SELECT * FROM categories;";

	@Override
	public List<Categorie> selectAll() {
		List<Categorie> listeCategories = new ArrayList<>();
		// Ouverture de la connexion de la BDD
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// Préparation de la requête 
			PreparedStatement ps = cnx.prepareStatement(SELECT_ALL);
			// Execution de la requete et interpretation des resultats
			ResultSet rs = ps.executeQuery();
			//On remplit la liste de catégories
			Categorie categorie = new Categorie();
				while(rs.next()) {
					categorie = categorieBuilder(rs);
					listeCategories.add(categorie);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeCategories;
	}
	@Override
	public Categorie selectById(int id) {
		return null;
	}
	@Override
	public void insert(Categorie categorie) {
	}
	private Categorie categorieBuilder(ResultSet rs) throws SQLException {
		Categorie categorie;
		categorie=new Categorie();
		categorie.setNumero(rs.getInt("no_categorie"));
		categorie.setLibelle(rs.getString("libelle"));
		return categorie;
	}
}