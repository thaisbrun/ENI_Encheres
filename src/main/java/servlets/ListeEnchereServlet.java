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
import bo.Utilisateur;
import bll.CategorieBLL;
import bo.Categorie;

/**
 * Servlet servant à afficher la liste des enchères. 
 * Page associée : index.jsp
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

			//Initialisation des classes
			Enchere enchere = new Enchere();
			Utilisateur user = new Utilisateur();
			
			//Création de la liste des enchères 
			List<Enchere> listeEncheres=null;
			//Appel à la requête SQL
			listeEncheres = enchereBLL.selectAll();
			request.setAttribute("listeEncheres", listeEncheres);
			
			//Initialisation de la classe 
			Categorie categorie = new Categorie();
			
			//Création de la liste des catégories
			List<Categorie> listeCategories = null;
			
			//Création de la liste des catégories
			listeCategories = categorieBLL.selectAll();
			request.setAttribute("listeCategories", listeCategories);

			//Lien vers la JSP
			request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
