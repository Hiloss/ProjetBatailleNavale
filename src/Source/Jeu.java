package Source;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Affichage.AffichageSolo;
import Affichage.Menu;

public class Jeu {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bienvenue dans la bataile Navale");
		System.out.println("Veuillez entrer votre Pseudo");
		String pseudo = sc.nextLine();
		System.out.println("Taille de la grille ?");
		int taille = sc.nextInt();
		
		//Creation du joueur
		Joueur j1 = new Joueur(pseudo, taille);
		//j1.placerBateau(j1.getTabBateau().get(0), new Case(1,1), 3);
		
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
				AffichageSolo dessinSolo = new AffichageSolo(j1.getGrilleBateau(), j1);
				fenetre.setContentPane(dessinSolo);
				fenetre.repaint();
				fenetre.setSize(600,600);
//				j1.placerBateau();
				break;
			default:
				Thread.sleep(10);
				break;
			}
		}
	}
}
