package dal;

import java.util.List;

import bll.DALException;
import bll.EnchereBLL;
import bll.EnchereDAO;
import bo.Enchere;


public interface EnchereDAO {
	
	public void insert(Enchere articleVendu) throws DALException;
	
	public void update(Enchere articleVendu) throws DALException;
	
	public void delete(int noArticle) throws DALException;
	
	public Enchere selectById(Integer noArticle) throws DALException;
	
	public List<Enchere> selectAll() throws DALException;
}
