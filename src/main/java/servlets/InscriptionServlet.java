package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.BLLException;
import bll.UtilisateurBLL;

/**
 * Servlet servant à créer un utilisateur (inscription à la plateforme). 
 * Page associée : inscription.jsp
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurBLL bll;

    /**
     * Default constructor. 
     */
    public InscriptionServlet() {
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
		//Lien vers la JSP
		request.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // Je récupère grâce au formulaire les informations demandées
		
        String pseudo = request.getParameter("pseudo");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");    
        String telephone = request.getParameter("telephone");
        String rue = request.getParameter("rue");   
        String codePostal = request.getParameter("codePostal");   
        String ville = request.getParameter("ville");
        String motDePasse = request.getParameter("motDePasse");
      
        UtilisateurBLL utilisateurBll = new UtilisateurBLL();
        
        try {
        	//Appel de la requête SQL : ajout de l'utilisateur en fonction des informations transmises
			utilisateurBll.ajouterUtilisateur(pseudo,nom,prenom,email,telephone,rue,codePostal,ville,motDePasse);
			
			//Lien vers la JSP
			RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
			rd.forward(request, response);
			
		} catch (BLLException e) {
			//Envoie vers message d'erreur si les infos sont erronées
			request.setAttribute("erreur", e.getMessage());
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
			rd.forward(request, response);
			
		}
         
	}

}