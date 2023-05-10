package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.Enchere;

/**
 * Servlet implementation class EnchereServlet
 */
@WebServlet("/voirEnchere")
public class EnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EnchereServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enchere enchere = new Enchere();
		enchere.
		
		request.setAttribute("enchere", enchere);
		
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
