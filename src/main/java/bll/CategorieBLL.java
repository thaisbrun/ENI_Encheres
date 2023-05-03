package bll;

import java.util.List;

import bo.Categorie;
import dal.DAOFactory;
import dal.CategorieDAO;

public class CategorieBLL {
	private CategorieDAO dao;
	
	public CategorieBLL() {
		dao = DAOFactory.getCategorieDAO();
	}
	
	public List<Categorie> selectAll() {
		return dao.selectAll();
	}
	
	public Categorie selectById(int id) {
		return dao.selectById(id);
	}
	
	public void insert(Categorie categorie) {
		dao.insert(categorie);
	}
}
