package Affichage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import Source.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Listener.KeyGrilleListener;
import Listener.MouseGrilleListener;

public class AffichageGrille extends JPanel implements Serializable{
	
	private Grille grilleB;
	private int posX, posY, orient, hauteur, longueur, bateauPlace;
	private Joueur joueur;
	private Bateau bateau;

	
	public AffichageGrille(Grille g, Joueur j) {
		grilleB = g;
		posX = 0;
		posY = 0;
		hauteur = 0;
		longueur = 0;
		orient = 1;
		joueur = j;
		bateauPlace = 0;
		bateau = null;
		wakeListener();
	}
	
	public void wakeListener() {
		addMouseMotionListener(new MouseGrilleListener());
		addMouseListener(new MouseGrilleListener());
		addKeyListener(new KeyGrilleListener());
		setFocusable(true);
		requestFocusInWindow();
	}
	
	public Grille getGrilleB() {
		return grilleB;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < grilleB.getTaille(); i++) { //y
			for (int j = 0; j < grilleB.getTaille(); j++) {   //x
				int index = i*grilleB.getTaille()+j;
				switch (grilleB.getListCase().get(index).getEtat()) {
				case 0:
					g.setColor(Color.black);
					g.drawRect((getWidth()/grilleB.getTaille())*(j),(getHeight()/grilleB.getTaille())*(i), (getWidth()/grilleB.getTaille())-1, (getHeight()/grilleB.getTaille())-1);
					break;
				case 1:
					g.setColor(Color.red);
					g.fillRect((getWidth()/grilleB.getTaille())*(j),(getHeight()/grilleB.getTaille())*(i), (getWidth()/grilleB.getTaille())-1, (getHeight()/grilleB.getTaille())-1);
					break;
				case 2:
					g.setColor(Color.black);
					g.fillRect((getWidth()/grilleB.getTaille())*(j),(getHeight()/grilleB.getTaille())*(i), (getWidth()/grilleB.getTaille())-1, (getHeight()/grilleB.getTaille())-1);
					break;
				}
			}
		}
		if (bateauPlace < joueur.getTabBateau().size()) {
			bateau = joueur.getTabBateau().get(bateauPlace);
			int taille = bateau.getTaille();
			g.setColor(Color.darkGray);
			orient = bateau.getOrientation();
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

	public int getBateauPlace() {
		return bateauPlace;
	}

	public void setBateauPlace(int bateauPlace) {
		this.bateauPlace = bateauPlace;
	}

	public Bateau getBateau() {
		return bateau;
	}

	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
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
