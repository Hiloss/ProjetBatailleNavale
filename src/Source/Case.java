package Source;
public class Case {
	
	private int posX, posY;
	private int etat;

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
