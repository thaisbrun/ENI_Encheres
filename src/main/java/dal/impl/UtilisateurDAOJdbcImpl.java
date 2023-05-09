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
	//private static final String SELECT_BY_ID = "SELECT * FROM utilisateurs WHERE no_utilisateur = ?;";
	private static final String SELECT_ALL = "SELECT * FROM utilisateurs;";
	private static final String SELECT_BY_LOGINONLY = "SELECT * FROM utilisateurs WHERE pseudo = ?;";
	private static final String SELECT_BY_EMAILONLY= "SELECT * FROM utilisateurs WHERE email = ?;";
	private static final String INSERT = "INSERT INTO utilisateurs(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,100,0);";
<<<<<<< HEAD
	//private static final String UPDATE = "UPDATE utilisateurs SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?;";
=======
	private static final String UPDATE = "UPDATE utilisateurs SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ? WHERE no_utilisateur = ?;";
>>>>>>> branch 'master' of https://github.com/thaisbrun/ENI_Encheres.git
	private static final String SELECT_BY_LOGIN = "SELECT * FROM utilisateurs WHERE pseudo = ? AND mot_de_passe = ?;";
<<<<<<< HEAD
	private static final String DELETE = "DELETE FROM utilisateurs WHERE id = ?;";
	
	@Override
	 public List<Utilisateur> selectAll() {
=======
	private static final String SELECT_BY_ID = "SELECT * FROM utilisateurs WHERE no_utilisateur = ?;";
	private static final String DELETE = "DELETE FROM utilisateurs WHERE no_utilisateur = ?;";
	//@Override
	/*public List<Utilisateur> selectAll() {
>>>>>>> branch 'master' of https://github.com/thaisbrun/ENI_Encheres.git
		List<Utilisateur> listeUtilisateurs = new ArrayList<>();
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement ps = cnx.prepareStatement(SELECT_ALL);
			
			Utilisateur resultat;
			ResultSet rs = ps.executeQuery();
		while (rs.next()) {
				resultat = new Utilisateur();
				resultat.setNoUtilisateur(rs.getInt("no_utilisateur"));
				resultat.setPseudo(rs.getString("pseudo"));
				resultat.setNom(rs.getString("nom"));
				resultat.setPrenom(rs.getString("prenom"));
				resultat.setEmail(rs.getString("email"));
				resultat.setTelephone(rs.getString("telephone"));
				resultat.setRue(rs.getString("rue"));
				resultat.setCodePostal(rs.getString("code_postal"));
				resultat.setVille(rs.getString("ville"));
				resultat.setMotDePasse(rs.getString("mot_de_passe"));
				resultat.setCredit(rs.getInt("credit"));
				resultat.setAdministrateur(rs.getBoolean("administrateur"));
			
				listeUtilisateurs.add(resultat);
			}
			rs.close();
			ps.close();
			cnx.commit();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listeUtilisateurs;
<<<<<<< HEAD
=======
	}*/
	
	@Override
	public Utilisateur selectById(int no_utilisateur) {
		// TODO Auto-generated method stub
		Utilisateur utilisateur = null;
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_ID);
			
			// 3e etape : attribuer les parametres nécessaires à ma requête
			ps.setInt(1, no_utilisateur);
			// 4e etape : execution de la requete et interpretation des resultats
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setNo_utilisateur(no_utilisateur);
			}
			rs.close();
			ps.close();
			cnx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
>>>>>>> branch 'master' of https://github.com/thaisbrun/ENI_Encheres.git
	}
	
	@Override
	public void insert(Utilisateur utilisateur) {
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			// 4e etape : execution de la requete et interpretation des resultats

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
<<<<<<< HEAD
=======
	public void update(Utilisateur utilisateur) {
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(UPDATE);
			// 4e etape : execution de la requete et interpretation des resultats
			
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
>>>>>>> branch 'master' of https://github.com/thaisbrun/ENI_Encheres.git
	public void delete(Utilisateur utilisateur) {
		// 1e etape : ouvrir la connexion a la bdd
				try (Connection cnx = ConnectionProvider.getConnection();) {
					// 2e etape : preparer la requete SQL qu'on souhaite executer
					PreparedStatement ps = cnx.prepareStatement(DELETE);
					// 4e etape : execution de la requete et interpretation des resultats

					ps.setInt(1, utilisateur.getNo_utilisateur());
					
					ps.executeUpdate();
					cnx.commit();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
<<<<<<< HEAD
	public Utilisateur selectByLogin(String pseudo, String motDePasse) {
=======
	
	public Utilisateur connexionByLogin(String pseudo, String motDePasse) {
>>>>>>> branch 'master' of https://github.com/thaisbrun/ENI_Encheres.git
		Utilisateur utilisateur = null;
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_LOGIN);
			
			// 3e etape : attribuer les parametres nécessaires à ma requête
			ps.setString(1, pseudo);
			ps.setString(2, motDePasse);
			// 4e etape : execution de la requete et interpretation des resultats
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
	
	public Utilisateur selectByEmailOnly(String email) {
		Utilisateur utilisateur = null;
		try (Connection cnx = ConnectionProvider.getConnection();) {
			
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_EMAILONLY);
			
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
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
	
	@Override
	public Utilisateur selectByLoginOnly(String pseudo) {
		Utilisateur utilisateur = null;
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_LOGINONLY);
			
			// 3e etape : attribuer les parametres nécessaires à ma requête
			ps.setString(1, pseudo);
			// 4e etape : execution de la requete et interpretation des resultats
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

	@Override
	public void update(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur connexionByLogin(String pseudo, String motDePasse) {
		// TODO Auto-generated method stub
		return null;
	}
}
