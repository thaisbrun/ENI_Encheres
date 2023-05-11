package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ArticleVenduBLL;
import bll.BLLException;
import bll.CategorieBLL;
import bo.Categorie;
import bo.Utilisateur;

/**
 * Servlet servant à ajouter un article sur le site. 
 * Page associée : vendreArticle.jsp
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
		// Je récupère le profil utilisateur 
	    Utilisateur utilisateur = new Utilisateur();
	    request.setAttribute("utilisateur", utilisateur);
	    
	    //Initialisation de la classe 
	    Categorie categorie = new Categorie();
	    
	    //Création de la liste des catégories
		List<Categorie> listeCategories = null;
		
		//Appel de la requête SQL
		listeCategories = categorieBLL.selectAll();
		request.setAttribute("listeCategories", listeCategories);
		
		//Lien vers la JSP
		
		request.getRequestDispatcher("/WEB-INF/vendreArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Récupération des attributs nécessaire à l'ajout
        String nom_article = request.getParameter("nom_article");
        String description = request.getParameter("description");
        
        //Gestion de la première date  
        String date_debut_enchereStr = request.getParameter("date_debut_enchere");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date_debut_enchere = null;
		try {
			date_debut_enchere = sdf.parse(date_debut_enchereStr);
		} catch (ParseException e2) {
			// Erreur si date incorrecte
			e2.printStackTrace();
		}
		
        //Gestion de la seconde date  
        String date_fin_enchereStr = request.getParameter("date_fin_enchere");    
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date_fin_enchere = null;
		try {
			date_fin_enchere = sdf2.parse(date_fin_enchereStr);
		} catch (ParseException e1) {
			// Erreur si date incorrecte
			e1.printStackTrace();
		}
		
        int prix_initial = Integer.parseInt(request.getParameter("prix_initial"));

        //On récupère l'utilisateur de la session
        Utilisateur utilisateur = ((Utilisateur) request.getSession().getAttribute("user"));
        
        //On récupère l'id de la catégorie selectionnée 
        int categorie = Integer.parseInt(request.getParameter("categorie"));
        
        //On initie la couche BLL 
        ArticleVenduBLL articleVenduBll = new ArticleVenduBLL();
        //On essaye de créer un article et de l'ajouter 
        try {
        	//Appel de la requête SQL
        	articleVenduBll.ajouterArticleVendu(nom_article,description,date_debut_enchere,date_fin_enchere,prix_initial, utilisateur, new Categorie(categorie, ""));

        	//Lien vers la JSP
			RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
			rd.forward(request, response);
			
		} catch (BLLException e) {
			System.out.println(e.getMessage());
			request.setAttribute("erreur", e.getMessage());
			
			//Lien vers la JSP
			RequestDispatcher rd = request.getRequestDispatcher("./vendreArticle.jsp");
			rd.forward(request, response);
			
		}
	}

}
