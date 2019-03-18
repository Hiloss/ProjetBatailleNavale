import java.util.ArrayList;

public class Grille {

	ArrayList<Case> listCase;
	int taille;
	
	public Grille(int t) {
		taille = t;
		listCase = new ArrayList<Case>(t*t);
		for (int i = 1; i <= t; i++) {
			for (int j = 1; j <= t; j++) {
				listCase.add(new Case(i,j));
			}
		}
	}

	@Override
	public String toString() {
		return "Grille [listCase=" + listCase + ", taille=" + taille + "]";
	}
}
