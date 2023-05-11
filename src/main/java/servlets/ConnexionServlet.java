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
import javax.servlet.http.HttpSession;

import bll.UtilisateurBLL;
import bo.Utilisateur;

/**
 * Servlet servant à gérer la connexion d'un utilisateur. 
 * Page associée : connexion.jsp
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

		response.getWriter().append("Served at: ").append(request.getContextPath());
		//Chemin vers la JSP
		request.getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Pour se connecter, je récupère les paramètres fournis par l'utilisateur
		
        String pseudo = request.getParameter("pseudo");
        String motDePasse = request.getParameter("motDePasse");
        	
        	UtilisateurBLL utilisateurBll = new UtilisateurBLL();
        	
        	//Utilisation d'une requête SQL : on va voir si les informations fournies sont correctes et valides dans la BDD
        	
    		Utilisateur u = utilisateurBll.connexionByLogin(pseudo,motDePasse);
    		
    		//Si les informations sont erronées : la page d'erreur s'affiche
    		
    		if(u ==(null))
    		{
    			RequestDispatcher rd = request.getRequestDispatcher("/erreur");
    			rd.forward(request, response);   
    			
    		}  
    		else{
    			//Si les infos sont justes : on charge en session et on redirige vers l'accueil
    		HttpSession session = request.getSession();
    		session.setAttribute("user",u);
    		System.out.println(u.getPrenom());
			
			RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
			rd.forward(request, response);     
    		}
    		
	}
}

