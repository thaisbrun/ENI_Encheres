package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.EnchereBLL;
import bo.Enchere;

/**
 * Servlet implementation class EnchereServlet
 */
@WebServlet("/voirEnchere")
public class AfficherEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AfficherEnchereServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnchereBLL enchereBLL = new EnchereBLL();
		int no_utilisateur = Integer.parseInt(request.getParameter("no_utilisateur"));
		int no_article = Integer.parseInt(request.getParameter("no_article"));
		
		Enchere enchere = enchereBLL.selectById(no_utilisateur, no_article);
		
		request.setAttribute("enchere", enchere);
		
		request.getRequestDispatcher("/WEB-INF/afficherEnchere.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
