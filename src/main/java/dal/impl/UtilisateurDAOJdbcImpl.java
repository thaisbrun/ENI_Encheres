package dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Utilisateur;
import dal.ConnectionProvider;
import dal.UtilisateurDAO;

/*
 * Implémentation des méthodes proposées par UtilisateurDAO
 */
public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	//Requêtes SQL
	private static final String SELECT_ALL = "SELECT pseudo, email FROM utilisateurs;";
	private static final String SELECT_BY_EMAILONLY= "SELECT * FROM utilisateurs WHERE email = ?;";
	private static final String SELECT_BY_LOGINONLY = "SELECT * FROM utilisateurs WHERE pseudo = ?;";
	private static final String INSERT = "INSERT INTO utilisateurs(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,100,0);";
	private static final String UPDATE = "UPDATE utilisateurs SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ? WHERE no_utilisateur = ?;";
	private static final String UPDATE_CREDIT = "UPDATE utilisateurs SET credit = ? WHERE no_utilisateur = ?;";
	private static final String SELECT_BY_LOGIN = "SELECT * FROM utilisateurs WHERE pseudo = ? AND mot_de_passe = ?;";
	private static final String SELECT_BY_ID = "SELECT * FROM utilisateurs WHERE no_utilisateur = ?;";
	private static final String DELETE = "DELETE FROM utilisateurs WHERE no_utilisateur = ?;";
	
	//@Override
	public List<Utilisateur> selectAll() {
		List<Utilisateur> listeUtilisateurs = new ArrayList<>();
		//Connexion à la BDD
		try (Connection cnx = ConnectionProvider.getConnection();) {
			//Préparation de la requête
			PreparedStatement ps = cnx.prepareStatement(SELECT_ALL);
			Utilisateur utilisateur = new Utilisateur();
			
				String pseudo = utilisateur.getPseudo();
				String email = utilisateur.getEmail();
				
				//ajout de chaque objet à la liste
				listeUtilisateurs.add(utilisateur);
				
			//Exécution de la requête
			ResultSet rs = ps.executeQuery();
			rs.close();
			ps.close();
			cnx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeUtilisateurs;
	}
	
	@Override
	public Utilisateur selectById(int no_utilisateur) {
		Utilisateur utilisateur = null;
		//Connexion à la BDD
		try (Connection cnx = ConnectionProvider.getConnection();) {
			//Préparation de la requête
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_ID);
			
			ps.setInt(1, no_utilisateur);
			
			//Exécution des résultats
			ResultSet rs = ps.executeQuery();
			//
			while (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setNo_utilisateur(no_utilisateur);
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				
			}
			rs.close();
			ps.close();
			cnx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
	
	@Override
	public void insert(Utilisateur utilisateur) {
		// Connexion à la BDD
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// Préparation de la requête
			PreparedStatement ps = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			// Exécution de la requête

			ps.setString(1, utilisateur.getPseudo());
			ps.setString(2, utilisateur.getNom());
			ps.setString(3, utilisateur.getPrenom());
			ps.setString(4, utilisateur.getEmail());
			ps.setString(5, utilisateur.getTelephone());
			ps.setString(6, utilisateur.getRue());
			ps.setString(7, utilisateur.getCodePostal());
			ps.setString(8, utilisateur.getVille());
			ps.setString(9, utilisateur.getMotDePasse());
			
			ps.executeUpdate();
			//Générer la clé primaire
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next())
			{
				utilisateur.setNo_utilisateur(rs.getInt(1));
			}
			rs.close();
			ps.close();
			cnx.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Utilisateur utilisateur) {
		// Connexion à la BDD
		try (Connection cnx = ConnectionProvider.getConnection();) {
			//Préparation de la requete SQL 
			PreparedStatement ps = cnx.prepareStatement(UPDATE);
			// Execution de la requete et interpretation des resultats
			
			ps.setString(1, utilisateur.getPseudo());
			ps.setString(2, utilisateur.getNom());
			ps.setString(3, utilisateur.getPrenom());
			ps.setString(4, utilisateur.getEmail());
			ps.setString(5, utilisateur.getTelephone());
			ps.setString(6, utilisateur.getRue());
			ps.setString(7, utilisateur.getCodePostal());
			ps.setString(8, utilisateur.getVille());
			ps.setString(9, utilisateur.getMotDePasse());
			ps.setInt(10, utilisateur.getNo_utilisateur());
			ps.executeUpdate();
			cnx.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Utilisateur utilisateur) {
		// Connexion a la BDD
				try (Connection cnx = ConnectionProvider.getConnection();) {
					// Preparer la requete SQL qu'on souhaite executer
					PreparedStatement ps = cnx.prepareStatement(DELETE);
					// Execution de la requete et interpretation des resultats

					ps.setInt(1, utilisateur.getNo_utilisateur());
					
					ps.executeUpdate();
					cnx.commit();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	
	public Utilisateur connexionByLogin(String pseudo, String motDePasse) {
		Utilisateur utilisateur = null;
		// Connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// Preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_LOGIN);
			
			// Attribuer les parametres nécessaires à ma requête
			ps.setString(1, pseudo);
			ps.setString(2, motDePasse);
			// Execution de la requete et interpretation des resultats
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				utilisateur = new Utilisateur();	
				utilisateur.setNo_utilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(pseudo);
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setRue(rs.getString("rue"));				
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setMotDePasse(motDePasse);
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
			}
			rs.close();
			ps.close();
			cnx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
	
	@Override
	public Utilisateur selectByLoginOnly(String pseudo) {
		Utilisateur utilisateur = null;
		// Ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			//Préparation de la requête
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_LOGINONLY);
			
			ps.setString(1, pseudo);
			//Exécution de la requete 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setNo_utilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(pseudo);
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
			}
			rs.close();
			ps.close();
			cnx.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
	
	public Utilisateur selectByEmailOnly(String email) {
		Utilisateur utilisateur = null;
		//Ouverture connexion BDD
		try (Connection cnx = ConnectionProvider.getConnection();) {
			//Préparation de la requete 
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_EMAILONLY);
			
			ps.setString(1, email);
			//Exécution de la requete 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setNo_utilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(email);
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
			}
			rs.close();
			ps.close();
			cnx.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
}