package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ArticleVenduBLL;
import bll.CategorieBLL;
import bll.EnchereBLL;
import bll.UtilisateurBLL;
import bo.Categorie;
import bo.Enchere;
import bo.Utilisateur;

/**
 * Servlet implementation class rechercheCategorieServlet
 */
@WebServlet("/rechercheCategorie")
public class rechercheCategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereBLL enchereBLL;
	private CategorieBLL categorieBLL;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rechercheCategorieServlet() {
        super();
        // TODO Auto-generated constructor stub

		enchereBLL = new EnchereBLL();
		categorieBLL = new CategorieBLL();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Recherche des enchères
		Enchere enchere = new Enchere();
		Utilisateur user = new Utilisateur();

		
		Categorie categorie = new Categorie();
		List<Categorie> listeCategories = null;
		listeCategories = categorieBLL.selectAll();
		request.setAttribute("listeCategories", listeCategories);
		
        int categorie1 = Integer.parseInt(request.getParameter("categorie"));
		
		List<Enchere> listeEncheres=null;
		listeEncheres = enchereBLL.selectByCategorie(categorie1);
		request.setAttribute("listeEncheres", listeEncheres);
		

		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/rechercheCategorie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
