package Affichage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import Source.*;
import javax.swing.JPanel;

public class AffichageGrille extends JPanel {
	
	private Grille grilleB;
	
	public AffichageGrille(Grille g) {
		grilleB = g;
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
	}
}
