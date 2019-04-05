package Source;

import java.io.Serializable;

/**
 * @author Brian Bardet
 * @author Lucas Ambellouis
 * Bateau
 */
public class Bateau implements Serializable{

	private String nom;
	private int taille, orientation;
	private Case pos;
	
	/**
	 * Construit un bateau selon son nom, sa taille, son orientation et sa case de départ
	 * @param n
	 * @param t
	 * @param o
	 * @param p
	 */
	public Bateau(String n, int t, int o, Case p) {
		nom = n;
		taille = t;
		orientation = o;
		pos = p;
	}
	
	/**
	 * Permet de savoir si un bateau est sur la case (c)
	 * @param c
	 * @return boolean
	 */
	public boolean contient(Case c) {
		boolean res = true;
		int cx = c.getPosX();
		int cy = c.getPosY();
		int i = 0;
		switch (orientation) {
		case 1:
			while (i < taille && res) {
				if (cx != pos.getPosX()) 
					res = false;
				else
					if (cy != pos.getPosY()-i)
						res = false;
				i++;
			}
			break;
		case 2:
			while (i < taille && res) {
				if (cx != pos.getPosX()+i) 
					res = false;
				else
					if (cy != pos.getPosY())
						res = false;
				i++;
			}
			break;
		case 3:
			while (i < taille && res) {
				if (cx != pos.getPosX()) 
					res = false;
				else
					if (cy != pos.getPosY()+i)
						res = false;
				i++;
			}
			break;
		case 4:
			while (i < taille && res) {
				if (cx != pos.getPosX()-i) 
					res = false;
				else
					if (cy != pos.getPosY())
						res = false;
				i++;
			}
			break;
		}
		return res;
	}

	/**
	 * Récupère le nom du bateau
	 * @return string
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Modifie le nom du bateau
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Récupère la taille du bateau
	 * @return taille
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * Modifie la taille du bateau
	 * @param taille
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}

	/**
	 * Récupére l'orientation du bateau
	 * @return orientation
	 */
	public int getOrientation() {
		return orientation;
	}

	/**
	 * Modifie l'orientation du bateau
	 * @param orientation
	 */
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	/**
	 * Récupère la case de base du bateau
	 * @return case
	 */
	public Case getPos() {
		return pos;
	}

	/**
	 * Modifie la case de base du bateau
	 * @param pos
	 */
	public void setPos(Case pos) {
		this.pos = pos;
	}

	/* 
	 * Permet d'ecrire un bateau avec un string
	 * @return string
	 */
	@Override
	public String toString() {
		return "Bateau [nom=" + nom + ", taille=" + taille + ", orientation=" + orientation + ", pos=" + pos + "]";
	}
}
