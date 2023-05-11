package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.UtilisateurBLL;
import bo.Utilisateur;

/**
 * Servlet servant à supprimer le profil. 
 * Page associée : supprimerProfil.jsp
 */
@WebServlet("/supprimerProfil")
public class supprimerProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supprimerProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer l'utilisateur
	    Utilisateur utilisateur = new Utilisateur();
	    request.setAttribute("utilisateur", utilisateur);
//Lien vers la JSP
		request.getRequestDispatcher("/WEB-INF/supprimerProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Pour supprimer un utilisateur, j'ai besoin de l'id
        int no_utilisateur = ((Utilisateur) request.getSession().getAttribute("user")).getNo_utilisateur();
 
        // On appelle la classe BLL
      
        UtilisateurBLL utilisateurBll = new UtilisateurBLL();
        
        //Appel de la requête SQL 
        
		utilisateurBll.SupprimerUtilisateur(no_utilisateur);
		
		//On récupère la session et on la détruit
		HttpSession session = request.getSession();
			session.invalidate();
		
			//Si tout se passe bien, je vais vers la page de consultation:
			RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");

			rd.forward(request, response);
         	
	}

}
