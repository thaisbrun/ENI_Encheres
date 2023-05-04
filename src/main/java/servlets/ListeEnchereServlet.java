package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import bll.ArticleVenduBLL;
import bll.EnchereBLL;
import bo.ArticleVendu;
import bo.Enchere;

/**
 * Servlet implementation class ListeEnchereServlet
 */
@WebServlet("/acceuil")
public class ListeEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereBLL enchereBLL;
	//private ArticleVenduBLL articleVenduBLL;
	
	@Override
	public void init() throws ServletException {
		enchereBLL = new EnchereBLL();
		//articleVenduBLL = new ArticleVenduBLL();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Analyse de l'url pour voir si il y a un parametre
		//Si oui : Récupères les encheres en fonction du parametre / Si non: Récupère tout les enchères
		//Récupération de toutes les encheres dans une liste
		//Pour chacune des encheres récupérer l'utilisateur
		List<Enchere> encheres = enchereBLL.selectAll();
		List<ArticleVendu> articles = new ArrayList<ArticleVendu>();
		
		for(Enchere enchere : encheres) {
			articles.add(enchere.getArticleVendu());
		}
		
		request.setAttribute("encheres", encheres);
		request.setAttribute("articles", articles);
		//request.setAttribute("articlesVendu", articleVenduBLL.selectAll());
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

}
