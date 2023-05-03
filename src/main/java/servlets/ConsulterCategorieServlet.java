package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bll.CategorieBLL;
import bo.Categorie;

/**
 * Servlet implementation class ConsulterRepasServlet
 */
@WebServlet("/consulter")
public class ConsulterCategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategorieBLL bll;
	
	@Override
		public void init() throws ServletException {
			bll = new CategorieBLL();
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie> listeCategories = bll.selectAll();
		request.setAttribute("listeCategories", listeCategories);
		request.getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
	}
}
