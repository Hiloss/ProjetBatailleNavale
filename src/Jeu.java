import java.util.Scanner;

public class Jeu {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bienvenue dans la bataile Navale");
		System.out.println("Veuillez entrer votre Pseudo");
		String pseudo = sc.nextLine();
		System.out.println("Taille de la grille ?");
		int taille = sc.nextInt();
		
		//Creation du joueur
		Joueur j1 = new Joueur(pseudo, taille);
		
		//Placement des bateaux
		for (int i = 0; i < j1.getTabBateau().size(); i++) {
			j1.placerBateau(j1.getTabBateau().get(i));
		}
		
		System.out.println(j1);
	}
}
