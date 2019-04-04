package Affichage;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Listener.sauvButton;
import Source.*;

public class AffichageSolo extends JPanel implements Serializable {
	
	private AffichageGrille dessGrille;
	private Joueur nJoueur;
	private JButton sauv;
	
	public AffichageSolo(Grille g, Joueur j) {
		nJoueur = j;
		dessGrille = new AffichageGrille(g, j);
		dessGrille.setPreferredSize(new Dimension(500,500));
		add(new JLabel("Pseudo : " + nJoueur.getNom()));
		add(dessGrille);
		add(new JLabel("Taille : " + dessGrille.getGrilleB().getTaille()));
		sauv = new JButton("Sauvegarder");
		sauv.addActionListener(new sauvButton(this));
		add(sauv);
	}
	
	public AffichageGrille getDessGrille() {
		return dessGrille;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
}
