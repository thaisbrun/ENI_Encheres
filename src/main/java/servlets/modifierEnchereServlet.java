package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ArticleVenduBLL;

/**
 * Servlet implementation class modifierEnchereServlet
 */
@WebServlet("/modifierEnchere")
public class modifierEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifierEnchereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Enchere enchere = new Enchere();
	    //request.setAttribute("utilisateur", enchere);

		//request.getRequestDispatcher("/WEB-INF/modifierEnchere.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String date_debut_enchereStr = request.getParameter("dateDebutArticle");  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date_debut_enchere = null;
		try {
			date_debut_enchere = sdf.parse(date_debut_enchereStr);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
        String date_fin_enchereStr = request.getParameter("dateFinArticle");    
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date_fin_enchere = null;
		try {
			date_fin_enchere = sdf2.parse(date_fin_enchereStr);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ArticleVenduBLL articleBLL = new ArticleVenduBLL();
		
		String nom = request.getParameter("nomArticle");
		String descritpion = request.getParameter("descriptionArticle");
		int prix = Integer.parseInt(request.getParameter("prixArticle"));
		int no_article = Integer.parseInt(request.getParameter("no_article"));
		
		articleBLL.modifierArticleVendu(nom, descritpion, date_debut_enchere, date_debut_enchere,prix ,no_article);
		
		RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
		rd.forward(request, response);
	}

}
