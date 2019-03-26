package Affichage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import Source.*;
import javax.swing.JPanel;

import Listener.MouseGrilleListener;

public class AffichageGrille extends JPanel {
	
	private Grille grilleB;
	private int posX, posY, orient, hauteur, longueur, bateauPlace;
	private Joueur joueur;
	
	public AffichageGrille(Grille g, Joueur j) {
		grilleB = g;
		posX = 150;
		posY = 150;
		hauteur = 0;
		longueur = 0;
		orient = 4;
		joueur = j;
		bateauPlace = 0;
		addMouseMotionListener(new MouseGrilleListener());
	}
	
	
	
	public Grille getGrilleB() {
		return grilleB;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < grilleB.getTaille(); i++) { //y
			for (int j = 0; j < grilleB.getTaille(); j++) {   //x
				int index = i*grilleB.getTaille()+j;
				if (grilleB.getListCase().get(index).getEtat() == 0) {
					g.setColor(Color.black);
					g.drawRect((getWidth()/grilleB.getTaille())*(j),(getHeight()/grilleB.getTaille())*(i), (getWidth()/grilleB.getTaille())-1, (getHeight()/grilleB.getTaille())-1);
				}
				else {
					g.setColor(Color.red);
					g.fillRect((getWidth()/grilleB.getTaille())*(j),(getHeight()/grilleB.getTaille())*(i), (getWidth()/grilleB.getTaille())-1, (getHeight()/grilleB.getTaille())-1);
				}
			}
		}
		if (bateauPlace < joueur.getTabBateau().size()) {
			Bateau bateau = joueur.getTabBateau().get(bateauPlace);
			int taille = bateau.getTaille();
			g.setColor(Color.darkGray);
			switch (orient) {
			case 1:
				hauteur = ((getHeight()/grilleB.getTaille())-1)*taille;
				longueur = (getWidth()/grilleB.getTaille())-1;
				posY -= hauteur-(getHeight()/grilleB.getTaille())-1;
				break;
			case 2:
				hauteur = (getHeight()/grilleB.getTaille())-1;
				longueur = ((getWidth()/grilleB.getTaille())-1)*taille;
				break;
			case 3:
				hauteur = ((getHeight()/grilleB.getTaille())-1)*taille;
				longueur = (getWidth()/grilleB.getTaille())-1;
				break;
			case 4:
				hauteur = (getHeight()/grilleB.getTaille())-1;
				longueur = ((getWidth()/grilleB.getTaille())-1)*taille;
				posX -= longueur-((getWidth()/grilleB.getTaille())-1);
				break;
			}
			g.fillRect(posX, posY, longueur, hauteur);
		}
	}



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



	public int getOrient() {
		return orient;
	}



	public void setOrient(int orient) {
		this.orient = orient;
	}



	public int getHauteur() {
		return hauteur;
	}



	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}



	public int getLongueur() {
		return longueur;
	}



	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}



	public void setGrilleB(Grille grilleB) {
		this.grilleB = grilleB;
	}
	
	
}
