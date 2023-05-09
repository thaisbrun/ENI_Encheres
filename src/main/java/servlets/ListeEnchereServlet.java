package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.EnchereBLL;
import bo.Enchere;
import bll.CategorieBLL;
import bo.Categorie;

/**
 * Servlet implementation class ListeEnchereServlet
 */
@WebServlet("")
public class ListeEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereBLL enchereBLL;
	private CategorieBLL categorieBLL;
	
	@Override
	public void init() throws ServletException {
		enchereBLL = new EnchereBLL();
		categorieBLL = new CategorieBLL();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			//Recherche des enchères
			Enchere enchere = new Enchere();
			List<Enchere> listeEncheres=null;
			listeEncheres = enchereBLL.selectAll();
			request.setAttribute("listeEncheres", listeEncheres);
			
			Categorie categorie = new Categorie();
			List<Categorie> listeCategories = null;
			listeCategories = categorieBLL.selectAll();
			request.setAttribute("listeCategories", listeCategories);

			request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
