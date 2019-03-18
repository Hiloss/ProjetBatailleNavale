public class Case {
	
	int posX, posY;
	int etat;

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	public Case(int x, int y) {
		posX = x;
		posY = y;
		etat = 0;
	}

	@Override
	public String toString() {
		return "Case [posX=" + posX + ", posY=" + posY + ", etat=" + etat + "]";
	}
}
