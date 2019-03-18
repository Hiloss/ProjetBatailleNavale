public class Case {

	int posX, posY;
	int etat;
	
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
