package dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bo.Utilisateur;
import dal.ConnectionProvider;
import dal.UtilisateurDAO;

/*
 * Implémentation des méthodes proposées par RepasDAO
 */
public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	//private static final String SELECT_ALL = "SELECT pseudo, mot_de_passe FROM utilisateurs;";
	private static final String SELECT_BY_LOGINONLY = "SELECT * FROM utilisateurs WHERE pseudo = ?;";
	private static final String INSERT = "INSERT INTO utilisateurs(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,100,0);";
	private static final String UPDATE = "UPDATE utilisateurs SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?;";
	private static final String SELECT_BY_LOGIN = "SELECT * FROM utilisateurs WHERE pseudo = ? AND mot_de_passe = ?;";
	private static final String DELETE = "DELETE FROM utilisateurs WHERE id = ?;";
	//@Override
	/*public List<Utilisateur> selectAll() {
		List<Utilisateur> listeUtilisateurs = new ArrayList<>();
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(SELECT_ALL);
			Utilisateur utilisateur = new Utilisateur();
			
				String prenom = utilisateur.getPrenom();
				String pseudo = utilisateur.getPseudo();
				String motDePasse = utilisateur.getMotDePasse();
				
				listeUtilisateurs.add(utilisateur);
				
// 4e etape : execution de la requete et interpretation des resultats
				
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
	public Utilisateur selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}*/
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
				utilisateur.setNoUtilisateur(rs.getInt(1));
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
			
			ps.executeUpdate();
			cnx.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Utilisateur utilisateur) {
		// 1e etape : ouvrir la connexion a la bdd
				try (Connection cnx = ConnectionProvider.getConnection();) {
					// 2e etape : preparer la requete SQL qu'on souhaite executer
					PreparedStatement ps = cnx.prepareStatement(DELETE);
					// 4e etape : execution de la requete et interpretation des resultats

					ps.setInt(1, utilisateur.getNoUtilisateur());
					
					ps.executeUpdate();
					cnx.commit();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	public Utilisateur connexionByLogin(String pseudo, String motDePasse) {
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
				utilisateur.setPseudo(pseudo);
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail("email");
				utilisateur.setRue(rs.getString("rue"));				
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setTelephone(rs.getString("telephone"));
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
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(pseudo);
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
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

	/*@Override
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
	}*/
}
