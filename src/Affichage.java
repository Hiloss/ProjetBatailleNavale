import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Affichage extends JPanel {
	
	private Grille grilleB;
	
	public Affichage(Grille g) {
		setPreferredSize(new Dimension(500,500));
		grilleB = g;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < grilleB.getTaille(); i++) {
			for (int j = 0; j < grilleB.getTaille(); j++) {
				int index = i*grilleB.getTaille()+j;
				if (grilleB.getListCase().get(index).getEtat() == 0) {
					g.setColor(Color.black);
					g.drawRect(1+(getWidth()/grilleB.getTaille())*(i-1), 1+(getHeight()/grilleB.getTaille())*(j-1), (getWidth()/grilleB.getTaille())-1, (getHeight()/grilleB.getTaille())-1);
				}
				else {
					g.setColor(Color.red);
					g.fillRect(1+(getWidth()/grilleB.getTaille())*(i-1), 1+(getHeight()/grilleB.getTaille())*(j-1), (getWidth()/grilleB.getTaille())-1, (getHeight()/grilleB.getTaille())-1);
				}
			}
		}
	}
}
