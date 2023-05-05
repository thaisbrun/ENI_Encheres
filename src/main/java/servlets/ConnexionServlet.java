package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.UtilisateurBLL;
import bo.Utilisateur;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurBLL bll;

    /**
     * Default constructor. 
     */
    public ConnexionServlet() {
        // TODO Auto-generated constructor stub
    }

	public void init() throws ServletException {
		bll = new UtilisateurBLL();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        String pseudo = request.getParameter("pseudo");
        String motDePasse = request.getParameter("motDePasse");

        	
        	UtilisateurBLL utilisateurBll = new UtilisateurBLL();
    		Utilisateur u = utilisateurBll.connexionByLogin(pseudo,motDePasse);
    		
    		if(u ==(null))
    		{
    			RequestDispatcher rd = request.getRequestDispatcher("/erreur");
    			rd.forward(request, response);   
    			
    		}  
    		else{
    			//SI pas nul : on charge en session et on redirige vers l'accueil
    		request.getSession().setAttribute("user",u);
    		System.out.println(u.toString());
			
			RequestDispatcher rd = request.getRequestDispatcher("./");
			rd.forward(request, response);     
    		}
    		
	}
}

