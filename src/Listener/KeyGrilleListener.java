package Listener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Affichage.AffichageGrille;

public class KeyGrilleListener  implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		AffichageGrille dess = (AffichageGrille)e.getSource();
		System.out.println(code);
		switch (code) {
		case 37:
			dess.getBateau().setOrientation(4);
			break;
		case 38:
			dess.getBateau().setOrientation(1);
			break;
		case 39:
			dess.getBateau().setOrientation(2);
			break;
		case 40:
			dess.getBateau().setOrientation(3);
			break;
		}
		dess.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
