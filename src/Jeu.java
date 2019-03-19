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
			boolean stop = false;
			System.out.println("~~ Placement du bateau: " + j1.getTabBateau().get(i).getNom() + " ~~");
			while(!stop){
				System.out.println("Position en X ?");
				int posX = sc.nextInt();
				System.out.println("Position en Y ?");
				int posY = sc.nextInt();
				Case c = new Case(posX,posY);
				
				System.out.println("Orientation du bateau ?");
				int orien = sc.nextInt();

				stop = j1.placerBateau(j1.getTabBateau().get(i), c, orien);
			}
		}
		
		System.out.println(j1);
	}
}
