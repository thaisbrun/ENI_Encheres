package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.EnchereBLL;
import bo.Enchere;

/**
 * Servlet implementation class ListeEnchereServlet
 */
@WebServlet("")
public class ListeEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereBLL enchereBLL;
	
	@Override
	public void init() throws ServletException {
		enchereBLL = new EnchereBLL();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<Enchere> encheres = enchereBLL.selectAll();
		request.setAttribute("encheres", enchereBLL.selectAll());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
