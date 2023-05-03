package servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurBLL utilbll;

    /**
     * Default constructor. 
     */
    public InscriptionServlet() {
        // TODO Auto-generated constructor stub
    }

	public void init() throws ServletException {
		utilbll = new UtilisateurBLL();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);

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
         
        // get response writer
        PrintWriter writer = response.getWriter();
        
        
         
        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is: " + prenom + "<br/>";      
        htmlRespone += "Your name is: " + nom + "</h2>";    
        htmlRespone += "</html>";
         
        // return response
        writer.println(htmlRespone);
	}

}
