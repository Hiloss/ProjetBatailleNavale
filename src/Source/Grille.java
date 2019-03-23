package Source;
import java.util.ArrayList;

public class Grille {

	ArrayList<Case> listCase;
	int taille;
	
	public Grille(int t) {
		taille = t;
		listCase = new ArrayList<Case>(t*t);
		for (int i = 1; i <= t; i++) {
			for (int j = 1; j <= t; j++) {
				listCase.add(new Case(j,i));
			}
		}
	}

	@Override
	public String toString() {
		String res = "";
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				int pos = i*taille+j;
				int etat = listCase.get(pos).getEtat();
				if (etat == 1)
					res += "X ";
				else
					res += "O ";
			}
			res+="\n";
		}
		System.out.println(listCase);
		return res;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public ArrayList<Case> getListCase() {
		return listCase;
	}

	public void setListCase(ArrayList<Case> listCase) {
		this.listCase = listCase;
	}
	
	
}
