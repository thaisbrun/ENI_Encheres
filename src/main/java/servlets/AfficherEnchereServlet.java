package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.ArticleVenduBLL;
import bll.BLLException;
import bll.EnchereBLL;
import bll.UtilisateurBLL;
import bo.Enchere;
import bo.Utilisateur;

/**
 * Servlet implementation class EnchereServlet
 */
@WebServlet("/voirEnchere")
public class AfficherEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AfficherEnchereServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		EnchereBLL enchereBLL = new EnchereBLL();
		UtilisateurBLL utilisateurBLL = new UtilisateurBLL();
		
		Utilisateur utilisateurConnecete = (Utilisateur)session.getAttribute("user");
		Utilisateur vendeur = utilisateurBLL.selectById(Integer.parseInt(request.getParameter("no_utilisateur")));
		
		System.out.println(request.getParameter("no_utilisateur").toString());
		System.out.println(request.getParameter("no_utilisateur").toString());
		int no_utilisateur = Integer.parseInt(request.getParameter("no_utilisateur"));
		int no_article = Integer.parseInt(request.getParameter("no_article"));
		
		Enchere enchere = enchereBLL.selectById(no_utilisateur, no_article);
		System.out.println("Enchere: " + enchere.toString() + enchere.getArticle() + enchere.getUtilisateur().getPseudo());
		
		request.setAttribute("enchere", enchere);
		request.setAttribute("estVendeur", utilisateurBLL.estVendeur(vendeur, utilisateurConnecete));
		
		request.getRequestDispatcher("/WEB-INF/afficherEnchere.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurBLL utilisateurBLL = new UtilisateurBLL();
		ArticleVenduBLL articleBLL = new ArticleVenduBLL();
		
		EnchereBLL enchereBLL = new EnchereBLL();
		HttpSession session = request.getSession();
		
		Utilisateur utilisateurConnecete = (Utilisateur)session.getAttribute("user");
		
		try {
			Utilisateur vendeur = utilisateurBLL.selectById(Integer.parseInt(request.getParameter("no_utilisateur")));
			Enchere enchere = enchereBLL.selectById(Integer.parseInt(request.getParameter("no_utilisateur")), Integer.parseInt(request.getParameter("no_article")));
			utilisateurBLL.validationModifEnchere(vendeur, utilisateurConnecete);
			articleBLL.validationEnchere(enchere.getArticle());
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierEnchere.jsp");
			rd.forward(request, response);
			
		} catch (BLLException e) {
			Enchere enchere = enchereBLL.selectById(Integer.parseInt(request.getParameter("no_utilisateur")), Integer.parseInt(request.getParameter("no_article")));
			
			request.setAttribute("erreur", e.getMessage());
			request.setAttribute("enchere", enchere);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/afficherEnchere.jsp");
			rd.forward(request, response);
		}
	}

}
