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
import dal.CategorieDAO;
import dal.ConnectionProvider;

/*
 * Implémentation des méthodes proposées par RepasDAO
 */
public class CategorieDAOJdbcImpl implements CategorieDAO {
	private static final String SELECT_ALL = "SELECT no_categorie, libelle FROM categories;";
	//private static final String SELECT_BY_ID = "SELECT * FROM repas r LEFT JOIN aliments a ON r.id = a.id_repas WHERE r.id = ?;";
	//private static final String INSERT = "INSERT INTO repas(date_repas, heure_repas) VALUES (?,?);";
	//private static final String INSERT_ALIMENT = "INSERT INTO aliments(nom, id_repas) VALUES (?,?);";

	@Override
	public List<Categorie> selectAll() {
		List<Categorie> resultat = new ArrayList<>();
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(SELECT_ALL);
			// 4e etape : execution de la requete et interpretation des resultats
			ResultSet rs = ps.executeQuery();
			
			Categorie categorie = new Categorie();

				int numero = categorie.getNumero();
				String libelle = categorie.getLibelle();
		
			resultat.add(categorie);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	@Override
	public Categorie selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insert(Categorie categorie) {
		// TODO Auto-generated method stub
		
	}
}
/*
	@Override
	public Repas selectById(int id) {
		Repas resultat = null;
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_ID);
			
			// 3e etape : attribuer les parametres nécessaires à ma requête
			ps.setInt(1, id);
			
			// 4e etape : execution de la requete et interpretation des resultats
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultat = new Repas();
				resultat.setId(rs.getInt("id"));
				resultat.setDate(rs.getDate("date_repas").toLocalDate());
				resultat.setHeure(rs.getTime("heure_repas").toLocalTime());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public void insert(Repas repas) {
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps =
					cnx.prepareStatement(INSERT,
										PreparedStatement.RETURN_GENERATED_KEYS);
			
			// 3e etape : attribuer les parametres nécessaires à ma requête
			ps.setDate(1, Date.valueOf(repas.getDate()));
			ps.setTime(2, Time.valueOf(repas.getHeure()));
			
			// 4e etape : execution de la requete et interpretation des resultats
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				repas.setId(id);
			}
			
			for (Aliment current : repas.getAliments()) {
				PreparedStatement ps2 = cnx.prepareStatement(INSERT_ALIMENT);
				ps2.setString(1, current.getNom());
				ps2.setInt(2, repas.getId());
				ps2.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}*/