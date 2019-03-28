package Source;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Affichage.AffichageSolo;
import Affichage.Menu;

public class Jeu {

	public static void main(String[] args) throws InterruptedException {
				
		//Affichage du menu
		JFrame fenetre = new JFrame("Bataille Navale");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		Menu menu = new Menu();
		fenetre.setContentPane(menu);
		fenetre.pack();
		
		//Choix du Mode
		boolean choixFait = false;
		while (! choixFait) {
			int choix = menu.getChoix();
			switch (choix) {
			case 1:
				choixFait = true;
				choixSolo(fenetre);
				break;
			default:
				Thread.sleep(10);
				break;
			}
		}
	}
	
	public static void choixSolo(JFrame jf) {	
		
		Scanner sc = new Scanner(System.in);
		
		//On pr�vient le joueur qu'il doit taper dans la console
		JOptionPane.showMessageDialog(null, "Regarder votre console", "Information", JOptionPane.INFORMATION_MESSAGE);
		
		//Param�tre du joueur + Taille de la grille de jeux
		System.out.println("Bienvenue dans la bataile Navale");
		System.out.println("Veuillez entrer votre Pseudo");
		String pseudo = sc.nextLine();
		System.out.println("Taille de la grille ?");
		int taille = sc.nextInt();
		
		//On pr�vient que le param�trage est fini
		JOptionPane.showMessageDialog(null, "Fen�tre de jeux pr�te", "Information", JOptionPane.INFORMATION_MESSAGE);
		
		//Cr�ation du Joueur
		Joueur j1 = new Joueur(pseudo, taille);
		
		//Cr�ation de la fenetre de jeux
		JFrame fenetre = jf;
		AffichageSolo dessinSolo = new AffichageSolo(j1.getGrilleBateau(), j1);
		fenetre.setContentPane(dessinSolo);
		fenetre.repaint();
		fenetre.setSize(600,600);
	}
}

