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
	
}
