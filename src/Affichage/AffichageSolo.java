package Affichage;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Source.*;

public class AffichageSolo extends JPanel {
	
	private AffichageGrille dessGrille;
	private JTextField pseudo;
	
	public AffichageSolo(Grille g) {
		dessGrille = new AffichageGrille(g);
		dessGrille.setPreferredSize(new Dimension(500,500));
		add(dessGrille);
		add(new JLabel("Pseudo"));
		pseudo = new JTextField(10);
		add(pseudo);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
