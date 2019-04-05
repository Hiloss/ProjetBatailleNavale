package Source;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * @author Brian Bardet
 * @author Lucas Ambellouis
 * Classe représentant un joueur 
 */
public class Joueur implements Serializable {

	private String nom;
	private ArrayList<Bateau> tabBateau;
	private Grille grilleBateau;
	
	/**
	 * Construction d'un joueur
	 * @param n Nom du joueur
	 * @param t Taille de sa grille
	 */
	public Joueur(String n, int t) {
		nom = n;
		grilleBateau = new Grille(t);
		tabBateau = new ArrayList<Bateau>(5);
		tabBateau.add(new Bateau("Porte-Avion", 5, 1, null));
		tabBateau.add(new Bateau("Croiseur", 4, 1, null));
		tabBateau.add(new Bateau("Contre-Torpilleur", 3, 1, null));
		tabBateau.add(new Bateau("Sous-Marin", 3, 1, null));
		tabBateau.add(new Bateau("Torpilleur", 2, 1, null));
	}

	/**
	 *  Récupèrer la liste de bateau du joueur
	 * @return ArrayList<Bateau>
	 */
	public ArrayList<Bateau> getTabBateau() {
		return tabBateau;
	}

	/**
	 * Modifie la liste de bateau du joueur
	 * @param tabBateau
	 */
	public void setTabBateau(ArrayList<Bateau> tabBateau) {
		this.tabBateau = tabBateau;
	}

	/**
	 * Récupérer le nom du joueur
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Modifie le nom du joueur
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return grille sur laquelle les bateaux du joueur sont placés
	 */
	public Grille getGrilleBateau() {
		return grilleBateau;
	}

	/**
	 * Modifie la grille sur laquelle les bateaux du joueur sont placés
	 * @param grilleBateau
	 */
	public void setGrilleBateau(Grille grilleBateau) {
		this.grilleBateau = grilleBateau;
	}
	
	/* 
	 * Permet de récupérer un joueur en String
	 * return string
	 */
	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", tabBateau=" + tabBateau + ", grilleBateau=" + grilleBateau + "]";
	}
	
	/**
	 * Trier la liste de bateau du joueur
	 * @return ArrayList<Bateau>
	 */
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
		
	/**
	 * Permet de placer un bateau sur la grille du joueur
	 * @param b Bateau a placé
	 * @param c Case de départ
	 * @param orient Orientation du bateau 
	 * @return boolean
	 */
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
	
	/**
	 * Permet de tirer sur la grille de j2
	 * @param j2 Joueur sur qui tiré
	 * @param c Case sur laquelle tiré
	 * @return boolean
	 */
	public boolean tirer(Joueur j2, Case c) {
		boolean res = true;
		switch (c.getEtat()) {
		case 1:
			int index = j2.getGrilleBateau().getListCase().indexOf(c);
			Case c1 = j2.getGrilleBateau().getListCase().get(index);
			c1.setEtat(2);
			boolean trouve = false;
			int i = 0;
			while (! trouve && i < tabBateau.size()) {
				System.out.println("test");
				Bateau b = tabBateau.get(i);
				if (j2.getGrilleBateau().BateauDetruit(b)) {
					JOptionPane.showMessageDialog(null, "Touché ! Coulé !", "Information", JOptionPane.INFORMATION_MESSAGE);
					tabBateau.remove(i);
					trouve = true;
				}
				i++;
			}
			if (! trouve)
				JOptionPane.showMessageDialog(null, "Touché !", "Information", JOptionPane.INFORMATION_MESSAGE);
			if (tabBateau.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vous avez gagné !", "Information", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}	
			break;
		default:
			JOptionPane.showMessageDialog(null, "Tire Loupé, Réessayer", "Attention", JOptionPane.WARNING_MESSAGE);
			res = false;
			break;
		}
		return res;
	}
}
