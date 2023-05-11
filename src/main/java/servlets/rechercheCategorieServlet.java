package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.CategorieBLL;
import bll.EnchereBLL;
import bo.Categorie;
import bo.Enchere;
import bo.Utilisateur;

/**
 * Servlet servant à filtrer la liste des enchères. 
 * Page associée : index.jsp
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
		
		//Initialisation des classes 
		Enchere enchere = new Enchere();
		Utilisateur user = new Utilisateur();

		//Initialisation de la classe 
		Categorie categorie = new Categorie();
		//Création de la liste de catégories
		List<Categorie> listeCategories = null;
		//Appel de la requête SQL 
		listeCategories = categorieBLL.selectAll();
		request.setAttribute("listeCategories", listeCategories);
		
		//On récupère l'id de la catégorie
        int categorie1 = Integer.parseInt(request.getParameter("categorie"));
        //On récupère le nom de l'article
        String nom_article = request.getParameter("nom_article");
        
        //Création de la liste d'enchères 
		List<Enchere> listeEncheres=null;
		if (categorie1 == 0) {
			//Si la valeur de la catégorie est à 0, alors on sélectionne toutes les enchères sans filtre
			listeEncheres = enchereBLL.selectAll();
		}else {
			//Sinon on filtre la liste en fonction des infos saisies par l'utilisateur
		listeEncheres = enchereBLL.selectByCategorie(categorie1, nom_article);}
		request.setAttribute("listeEncheres", listeEncheres);
		

		response.getWriter().append("Served at: ").append(request.getContextPath());
		//Lien vers la JSP
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
