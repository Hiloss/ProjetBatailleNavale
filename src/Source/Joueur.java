package Source;
import java.util.ArrayList;

public class Joueur {

	private String nom;
	private ArrayList<Bateau> tabBateau;
	private Grille grilleBateau;
	
	public Joueur(String n, int t) {
		nom = n;
		grilleBateau = new Grille(t);
		tabBateau = new ArrayList<Bateau>(5);
		tabBateau.add(new Bateau("Porte-Avion", 5, 0, null));
		tabBateau.add(new Bateau("Croiseur", 4, 0, null));
		tabBateau.add(new Bateau("Contre-Torpilleur", 3, 0, null));
		tabBateau.add(new Bateau("Sous-Marin", 3, 0, null));
		tabBateau.add(new Bateau("Torpilleur", 2, 0, null));
	}

	public ArrayList<Bateau> getTabBateau() {
		return tabBateau;
	}

	public void setTabBateau(ArrayList<Bateau> tabBateau) {
		this.tabBateau = tabBateau;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Grille getGrilleBateau() {
		return grilleBateau;
	}

	public void setGrilleBateau(Grille grilleBateau) {
		this.grilleBateau = grilleBateau;
	}
	

	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", tabBateau=" + tabBateau + ", grilleBateau=" + grilleBateau + "]";
	}
	
	public ArrayList<Bateau> trierTailleBateau(){
		ArrayList<Bateau> res = new ArrayList<Bateau>(tabBateau.size());
		while (! tabBateau.isEmpty()) {
			int max = tabBateau.get(0).getTaille();
			int index = 0;
			for (int i = 1; i < tabBateau.size(); i++) {
				int taille = tabBateau.get(i).getTaille();
				if (taille > max) {
					index = i;
					max = taille;
				}
			}
			res.add(tabBateau.get(index));
			tabBateau.remove(index);
		}
		tabBateau = res;
		return res;
	}
		
	public boolean placerBateau(Bateau b, Case c, int orient){
		boolean res = true;
		
		//Verif si la case éxiste
		if (grilleBateau.getListCase().indexOf(c) == -1) {
			res = false;
			System.out.println("lalalalalalal");
		}
		
		//Verif si les cases que va occuper le bateau sont disponible
		if (res){
			boolean verifC = false;
			int i = 1;
			switch (orient) {
			case 1:
				while (! verifC && i < b.getTaille()){
					Case cbis = new Case(c.getPosX(), c.getPosY()-i);
					if (grilleBateau.getListCase().indexOf(cbis) == -1) {
						verifC = false;
						res = false;
					}
					i++;
				}
				break;
			case 2:
				while (! verifC && i < b.getTaille()){
					Case cbis = new Case(c.getPosX()+i, c.getPosY());
					if (grilleBateau.getListCase().indexOf(cbis) == -1) {
						verifC = false;
						res = false;
					}
					i++;
				}
				break;
			case 3:
				while (! verifC && i < b.getTaille()){
					Case cbis = new Case(c.getPosX(), c.getPosY()+i);
					if (grilleBateau.getListCase().indexOf(cbis) == -1) {
						verifC = false;
						res = false;
					}
					i++;
				}
				break;
			case 4:
				while (! verifC && i < b.getTaille()){
					Case cbis = new Case(c.getPosX()-i, c.getPosY());
					if (grilleBateau.getListCase().indexOf(cbis) == -1) {
						verifC = false;
						res = false;
					}
					i++;
				}
				break;
			default:
				res = false;
				break;
			}
		}
		
		//Placement du bateau
		if (res) {
			int index = grilleBateau.listCase.indexOf(c);
			grilleBateau.listCase.get(index).setEtat(1);
			switch (orient) {
			case 1:
				for (int i = 1; i < b.getTaille(); i++) {
					grilleBateau.listCase.get(grilleBateau.listCase.indexOf(new Case(c.getPosX(), c.getPosY()-i))).setEtat(1);
				}
				break;
			case 2:
				for (int i = 1; i < b.getTaille(); i++) {
					grilleBateau.listCase.get(grilleBateau.listCase.indexOf(new Case(c.getPosX()+i, c.getPosY()))).setEtat(1);
				}
				break;
			case 3:
				for (int i = 1; i < b.getTaille(); i++) {
					grilleBateau.listCase.get(grilleBateau.listCase.indexOf(new Case(c.getPosX(), c.getPosY()+i))).setEtat(1);
				}
				break;
			case 4:
				for (int i = 1; i < b.getTaille(); i++) {
					grilleBateau.listCase.get(grilleBateau.listCase.indexOf(new Case(c.getPosX()-i, c.getPosY()))).setEtat(1);
				}
			}
			
			b.setOrientation(orient);
			c.setEtat(1);
			b.setPos(c);
		}
		
		return res;
	}
	
}
