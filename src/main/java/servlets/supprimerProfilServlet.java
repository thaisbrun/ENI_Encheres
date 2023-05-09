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
 * Servlet implementation class supprimerProfil
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
		// TODO Auto-generated method stub
	    Utilisateur utilisateur = new Utilisateur();
	    request.setAttribute("utilisateur", utilisateur);

		request.getRequestDispatcher("/WEB-INF/supprimerProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// read form fields
        int no_utilisateur = ((Utilisateur) request.getSession().getAttribute("user")).getNo_utilisateur();
 
        // do some processing here...
      
        UtilisateurBLL utilisateurBll = new UtilisateurBLL();
		utilisateurBll.SupprimerUtilisateur(no_utilisateur);
					
		HttpSession session = request.getSession();
			session.invalidate();
		
			//Si tout se passe bien, je vais vers la page de consultation:
			RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");

			rd.forward(request, response);
         	
	}

}
