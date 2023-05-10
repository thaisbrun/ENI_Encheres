package bll;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import bo.Enchere;
import dal.DAOFactory;
import dal.EnchereDAO;

public class EnchereBLL {
	private EnchereDAO dao;
	
	public EnchereBLL() {
		dao = DAOFactory.getEnchereDAO();
	}
	
	public List<Enchere> selectAll() {
		return dao.selectAll();
	}
	
	public Enchere selectById(int no_utilisateur, int no_article) {
		return dao.selectById(no_utilisateur, no_article);
	}

	public List<Enchere> selectByCategorie(int no_categorie) {
		return dao.selectByCategorie(no_categorie);
	}
	
	public String getDateEnchereFormatedString(LocalDate date) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("DD/MM/YY");
		return date.format(dateTimeFormatter);
	}
}
