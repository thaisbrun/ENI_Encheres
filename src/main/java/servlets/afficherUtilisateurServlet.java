package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.UtilisateurBLL;
import bo.Utilisateur;

/**
 * Servlet implementation class afficherUtilisateurServlet
 */
@WebServlet("/afficherUtilisateur")
public class afficherUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public afficherUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

    	UtilisateurBLL utilisateurBll = new UtilisateurBLL();
        int no_utilisateur = Integer.parseInt(request.getParameter("no_utilisateur"));	
		Utilisateur utilisateur = utilisateurBll.selectById(no_utilisateur);
		request.setAttribute("utilisateur", utilisateur);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/afficherUtilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
