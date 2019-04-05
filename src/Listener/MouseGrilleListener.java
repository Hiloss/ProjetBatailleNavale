package Listener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import Affichage.AffichageGrille;
import Source.Case;
import Source.Joueur;

/**
 * @author Brian Bardet
 * @author Lucas Ambellouis
 * Lecture souris sur une grille
 */
public class MouseGrilleListener implements MouseListener, MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		AffichageGrille ag = (AffichageGrille)e.getSource();
		ag.setPosX(x-(ag.getWidth()/ag.getGrilleB().getTaille()/2)-1);
		ag.setPosY(y-(ag.getHeight()/ag.getGrilleB().getTaille()/2)-1);
		ag.repaint();
		ag.requestFocusInWindow();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		AffichageGrille ag = (AffichageGrille)e.getSource();
		if (SwingUtilities.isLeftMouseButton(e)) {
			int x = (e.getX()/(ag.getWidth()/ag.getGrilleB().getTaille()))+1;
			System.out.println(x);
			int y = (e.getY()/((ag.getHeight()/ag.getGrilleB().getTaille())))+1;
			System.out.println(y);
			Case c = ag.getGrilleB().getListCase().get(ag.getGrilleB().indexCase(x, y));
			System.out.println(c);
			Joueur j = ag.getJoueur();
			if (ag.getBateauPlace() < ag.getJoueur().getTabBateau().size())
			{
				if (j.placerBateau(ag.getBateau(), c, ag.getOrient())) {
					ag.setBateauPlace(ag.getBateauPlace()+1);
				}
				ag.repaint();
			}
			else {
				System.out.println("tire");
				j.tirer(j, c);
				System.out.println("a tiré");
			}
		}
		ag.requestFocusInWindow();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
