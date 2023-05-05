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
 * Servlet implementation class AfficherProfilServlet
 */
@WebServlet("/afficherProfil")
public class AfficherProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UtilisateurBLL bll;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherProfilServlet() {
        super();
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
		utilisateur = bll.selectById(id);
		request.getRequestDispatcher("/WEB-INF/afficherProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
