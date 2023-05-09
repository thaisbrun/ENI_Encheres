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
import bo.Utilisateur;

/**
 * Servlet implementation class vendreArticle
 */
@WebServlet("/vendreArticle")
public class vendreArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategorieBLL categorieBLL;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public vendreArticleServlet() {
        super();
		categorieBLL = new CategorieBLL();

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    Utilisateur utilisateur = new Utilisateur();
	    request.setAttribute("utilisateur", utilisateur);
	    
	    Categorie categorie = new Categorie();
		List<Categorie> listeCategories = null;
		listeCategories = categorieBLL.selectAll();
		
		request.setAttribute("listeCategories", listeCategories);
		
		request.getRequestDispatcher("/WEB-INF/vendreArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
