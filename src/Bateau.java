public class Bateau {

	private String nom;
	private int taille, orientation;
	private Case pos;
	private boolean mort;
	
	public Bateau(String n, int t, int o, Case p) {
		nom = n;
		taille = t;
		orientation = o;
		pos = p;
		mort = false;
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

	public boolean isMort() {
		return mort;
	}

	public void setMort(boolean mort) {
		this.mort = mort;
	}

	@Override
	public String toString() {
		return "Bateau [nom=" + nom + ", taille=" + taille + ", orientation=" + orientation + ", pos=" + pos + ", mort="
				+ mort + "]";
	}
	
}
