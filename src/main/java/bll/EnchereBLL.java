package bll;

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
	
	public Enchere selectById(int id) {
		return dao.selectById(id);
	}
	}
}
