package frontiere;

import java.util.Scanner;
import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean vendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!vendeurConnu) {
			System.out.println("Je suis désolé " + nomVendeur + " mais il faut etre "
					+ " un habitant de notre village pour commercer ici \n");
		} else {
			System.out.println(" Bonjour " + nomVendeur + " je vais regarder si je peux vous trouver un étal \n ");
			
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println(" Désolée " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occupé \n");
				
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println(" C'est parfait, il me reste un etal pour vous ! \n");
		System.out.print(" Quel produit souhaitez-vous vendre ? \n");
		String produit = scan.nextLine();

		System.out.print("Combien souhaitez-vous en vendre ? \n");
		int nombre = scan.nextInt();
		scan.nextLine();

		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nombre);

		if (numEtal != -1) {
			System.out.println(" Le vendeur " + nomVendeur + " s'est installe à l'etal n° " + numEtal + "\n");
		} else {
			System.out.println(" Désolé il n'y a aucun étal disponible \n");
		}
	}
}
