package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.EnchereBLL;
import bll.ListeBLL;

/**
 * Servlet implementation class ListeEnchereServelet
 */
@WebServlet("/encheres")
public class ListeEnchereServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereBLL bll;
       
	@Override
	public void init() throws ServletException {
		bll = new EnchereBLL();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}
}
