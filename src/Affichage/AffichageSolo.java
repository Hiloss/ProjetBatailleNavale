package Affichage;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Source.*;

public class AffichageSolo extends JPanel {
	
	private AffichageGrille dessGrille;
	private Joueur nJoueur;
	
	public AffichageSolo(Grille g, Joueur j) {
		nJoueur = j;
		dessGrille = new AffichageGrille(g, j);
		dessGrille.setPreferredSize(new Dimension(500,500));
		add(new JLabel("Pseudo : " + nJoueur.getNom()));
		add(dessGrille);
		add(new JLabel("Taille : " + dessGrille.getGrilleB().getTaille()));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
