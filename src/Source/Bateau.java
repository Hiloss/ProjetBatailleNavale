package Source;
public class Bateau {

	private String nom;
	private int taille, orientation;
	private Case pos;
	
	public Bateau(String n, int t, int o, Case p) {
		nom = n;
		taille = t;
		orientation = o;
		pos = p;
	}
	
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public Case getPos() {
		return pos;
	}

	public void setPos(Case pos) {
		this.pos = pos;
	}

	@Override
	public String toString() {
		return "Bateau [nom=" + nom + ", taille=" + taille + ", orientation=" + orientation + ", pos=" + pos + "]";
	}
}
