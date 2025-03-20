package frontiere;

import controleur.ControlLibererEtal;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println(" Mais vous n'êtes pas inscrit sur notre Marché aujourd'hui \n");
		} else {
			String[] etal = controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = Boolean.valueOf(etal[0]);

			if (etalOccupe) {
				String quantiteVendu = etal[4];
				String quantiteInitiale = etal[3];
				String produit = etal[2];

				System.out.println("Vous avez vendu " + quantiteVendu + " sur " + quantiteInitiale + " " + produit
						+ " En revoir " + nomVendeur + " passez une bonne journée \n");
			}
		}
	}

}
