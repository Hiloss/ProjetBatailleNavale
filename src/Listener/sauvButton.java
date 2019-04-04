package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

import Affichage.AffichageSolo;

public class sauvButton implements ActionListener, Serializable {

	private AffichageSolo a;
	
	public sauvButton(AffichageSolo as) {
		a = as;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream("sauv.txt"));
			out.writeObject(a);
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Merci d'avoir jouer !\nPartie sauvegardé","Information", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

}
