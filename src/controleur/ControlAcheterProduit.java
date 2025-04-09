package controleur;

import villagegaulois.Village;
import personnages.Gaulois;
import villagegaulois.Etal;

public class ControlAcheterProduit {

	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomVendeur) {
		boolean identite = controlVerifierIdentite.verifierIdentite(nomVendeur);
		return identite;
	}

	public Gaulois[] getVendeurProduit(String produit) {
		Gaulois[] vendeur = village.rechercherVendeursProduit(produit);
		return vendeur;
	}

	public int acheterProduit(Gaulois vendeur, int quantite) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(vendeur.getNom());
		if (etal != null) {
			int produit = etal.acheterProduit(quantite);
			return produit;
		} else {
			return 0;
		}
	}
}