package Source;

import java.io.Serializable;

/**
 * @author Brian Bardet
 * @author Lucas Ambellouis
 * Case se situant dans une Grille
 */
public class Case implements Serializable{
	
	private int posX, posY;
	private int etat;

	/**
	 * Récupérer la position en x de la Case
	 * @return x
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Modifier la position en x de la Case
	 * @param x
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	* Récupérer la position en y de la Case
	* @return y
	*/
	public int getPosY() {
		return posY;
	}

	/**
	 * Modifie la position en y de la Case
	 * @param posY
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * Récupérer l'etat de la case
	 * @return etat
	 */
	public int getEtat() {
		return etat;
	}

	/* 
	 * Permet de savoir si une case = une autre
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Case other = (Case) obj;
		if (etat != other.etat)
			return false;
		if (posX != other.posX)
			return false;
		if (posY != other.posY)
			return false;
		return true;
	}

	/**
	 * Modifie l'etat de la case
	 * @param etat
	 */
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	/**
	 * Construit une case d'apres sa pos en x et en y
	 * @param x
	 * @param y
	 */
	public Case(int x, int y) {
		posX = x;
		posY = y;
		etat = 0;
	}
	
	/**
	 * Construit une case d'apres sa pos en x et en y et son etat
	 * @param x
	 * @param y
	 */
	public Case(int x, int y, int e) {
		posX = x;
		posY = y;
		etat = e;
	}

	/* 
	 * Permet d'ecrire une case sous forme d'un String
	 * @return string
	 */
	@Override
	public String toString() {
		return "Case [posX=" + posX + ", posY=" + posY + ", etat=" + etat + "]";
	}
	
	/**
	 * Permet de touché (tirer) une case
	 */
	public void estTouche() {
		etat = 2;
	}
	
	/**
	 * Permet de savoir si deux cases sont les mêmes sans se soucier de leur etat
	 * @param c
	 * @return boolean
	 */
	public boolean memeEndroit(Case c) {
		if (posX != c.posX)
			return false;
		if (posY != c.posY)
			return false;
		return true;
	}
}
