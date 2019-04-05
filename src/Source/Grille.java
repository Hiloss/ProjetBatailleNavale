package Source;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Brian Bardet
 * @author Lucas Ambellouis
 * Grille 
 */
public class Grille implements Serializable {

	ArrayList<Case> listCase;
	int taille;
	
	/**
	 * Creer une grille de taille t sur t
	 * @param t
	 */
	public Grille(int t) {
		taille = t;
		listCase = new ArrayList<Case>(t*t);
		for (int i = 1; i <= t; i++) {
			for (int j = 1; j <= t; j++) {
				listCase.add(new Case(j,i));
			}
		}
	}

	/* 
	 * Ecrit la grille sous forme d'un String
	 * @return string
	 */
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

	/**
	 * Récupérer la taille de la grille
	 * @return taille
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * Modifie la taille de la grille
	 * @param taille
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}

	/**
	 * Récupérer la liste de case de la grille
	 * @return ArrayList<Case>
	 */
	public ArrayList<Case> getListCase() {
		return listCase;
	}

	/**
	 * Modifie la liste de case de la grille
	 * @param listCase
	 */
	public void setListCase(ArrayList<Case> listCase) {
		this.listCase = listCase;
	}
	
	/**
	 * Récupérer la place d'une case dans la liste selon sa pos en x et en y
	 * @param x
	 * @param y
	 * @return int
	 */
	public int indexCase(int x, int y) {
		return (y-1)*taille+(x-1);
	}
	
	/**
	 * Permet de savoir si un bateau (b) est détruit sur cette grille
	 * @param b
	 * @return boolean
	 */
	public boolean BateauDetruit(Bateau b) {
		boolean res = false;
		int xc = b.getPos().getPosX();
		int xy = b.getPos().getPosY();
		int orient = b.getOrientation();
		int taille = b.getTaille();
		int i = 0;
		int compteur = 0;
		while (i < taille) {
			switch (orient) {
			case 1:
				if (listCase.contains(new Case(xc, xy-i, 2)))
				compteur++;
				break;
			case 2:
				if (listCase.contains(new Case(xc+i, xy, 2)))
					compteur++;
				break;
			case 3:
				if (listCase.contains(new Case(xc, xy+i, 2)))
					compteur++;
				break;
			case 4:
				if (listCase.contains(new Case(xc-i, xy, 2)))
					compteur++;
				break;
			}
			i++;
		}
		if (compteur == taille) 
			res = true;
		return res;
	}
}
