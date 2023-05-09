package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.UtilisateurBLL;
import bo.Utilisateur;

/**
 * Servlet implementation class modifierProfil
 */
@WebServlet("/modifierProfil")
public class modifierProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifierProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* HttpSession session = request.getSession();
		System.out.print (request.getSession().getId());
		Utilisateur u = (Utilisateur) session.getAttribute("user"); */
	    Utilisateur utilisateur = new Utilisateur();
	    request.setAttribute("utilisateur", utilisateur);

		request.getRequestDispatcher("/WEB-INF/modifierProfil.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// read form fields
		
        String pseudo = request.getParameter("pseudo");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");    
        String telephone = request.getParameter("telephone");
        String rue = request.getParameter("rue");   
        String codePostal = request.getParameter("codePostal");   
        String ville = request.getParameter("ville");
        String motDePasse = request.getParameter("motDePasse");
 
        // do some processing here...
      
        UtilisateurBLL utilisateurBll = new UtilisateurBLL();
		utilisateurBll.ModifierUtilisateur(pseudo,nom,prenom,email,telephone,rue,codePostal,ville,motDePasse);
			//Si tout se passe bien, je vais vers la page de consultation:
			RequestDispatcher rd = request.getRequestDispatcher("./afficherProfil");
			rd.forward(request, response);
         	}

}
