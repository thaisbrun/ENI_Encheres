package bll;

import java.util.ArrayList;
import java.util.List;

public class BLLException extends Exception {
	private static final long serialVersionUID = 1L;

	private List<Integer> codesErreurs;
	
	public BLLException() {
		codesErreurs = new ArrayList<>();
	}
	
	public void ajouterErreur(int code) {
		codesErreurs.add(code);
	}
	
	public List<Integer> getErreurs() {
		return codesErreurs;
	}
}
