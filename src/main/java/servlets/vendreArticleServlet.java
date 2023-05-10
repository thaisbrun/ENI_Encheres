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
import bll.UtilisateurBLL;
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
 // read form fields
		
        String nom_article = request.getParameter("nom_article");
        String description = request.getParameter("description");
        String date_debut_enchereStr = request.getParameter("date_debut_enchere");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date_debut_enchere = null;
		try {
			date_debut_enchere = sdf.parse(date_debut_enchereStr);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        String date_fin_enchereStr = request.getParameter("date_fin_enchere");    
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date_fin_enchere = null;
		try {
			date_fin_enchere = sdf2.parse(date_fin_enchereStr);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        int prix_initial = Integer.parseInt(request.getParameter("prix_initial"));
        //Utilisateur utilisateur = (Utilisateur) request.getParameter("")
        // do some processing here...
        Utilisateur utilisateur = ((Utilisateur) request.getSession().getAttribute("user"));
        Categorie categorie = ((Categorie) request.getAttribute("categorie"));
        ArticleVenduBLL articleVenduBll = new ArticleVenduBLL();
        try {
        	articleVenduBll.ajouterArticleVendu(nom_article,description,date_debut_enchere,date_fin_enchere,prix_initial, utilisateur, categorie);

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/afficherProfil.jsp");
			rd.forward(request, response);
			
		} catch (BLLException e) {
			System.out.println(e.getMessage());
			request.setAttribute("erreur", e.getMessage());
			
			RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
			rd.forward(request, response);
			
		}
	}

}
