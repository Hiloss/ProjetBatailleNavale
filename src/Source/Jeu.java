package Source;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Affichage.AffichageGrille;
import Affichage.AffichageSolo;
import Affichage.Menu;

public class Jeu {

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
				
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
			case 3:
				choixFait = true;
//				choixCharge(fenetre);
				break;
			default:
				Thread.sleep(10);
				break;
			}
		}
	}
	
	public static void choixSolo(JFrame jf) {	
		
		Scanner sc = new Scanner(System.in);
		
		//On prévient le joueur qu'il doit taper dans la console
		JOptionPane.showMessageDialog(null, "Regarder votre console", "Information", JOptionPane.INFORMATION_MESSAGE);
		
		//Paramètre du joueur + Taille de la grille de jeux
		System.out.println("Bienvenue dans la bataile Navale");
		System.out.println("Veuillez entrer votre Pseudo");
		String pseudo = sc.nextLine();
		System.out.println("Taille de la grille ?");
		int taille = sc.nextInt();
		
		//On prévient que le paramétrage est fini
		JOptionPane.showMessageDialog(null, "Fenètre de jeux prète\nClick gauche pour placer les bateaux\nFlèches pour changer l'orientation", "Information", JOptionPane.INFORMATION_MESSAGE);
		
		//Création du Joueur
		Joueur j1 = new Joueur(pseudo, taille);
		
		//Création de la fenetre de jeux
		JFrame fenetre = jf;
		AffichageSolo dessinSolo = new AffichageSolo(j1.getGrilleBateau(), j1);
		fenetre.setContentPane(dessinSolo);
		fenetre.repaint();
		fenetre.setSize(600,600);
	}
	
//	public static void choixCharge(JFrame jf) throws ClassNotFoundException {
//		ObjectInputStream ois;
//		AffichageSolo jeux = null;
//		try {
//			ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Brian\\git\\ProjetBatailleNavale\\Sauvegarde.txt"));
//			jeux = (AffichageSolo)(ois.readObject());
//			ois.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JFrame fenetre = jf;
//		fenetre.setContentPane(jeux);
//		fenetre.repaint();
//		fenetre.setSize(600,600);
//	}
}

