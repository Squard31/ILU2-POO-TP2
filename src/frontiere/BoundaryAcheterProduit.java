package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		Boolean acheter = controlAcheterProduit.verifierIdentite(nomAcheteur);
		
		if (!acheter) {
			System.out.println(" Je suis désolé " + nomAcheteur + " mais il faut être un habitant "
					+ " de notre village pour commencer ici \n");
		}
		else {
			String produit = Clavier.entrerChaine(" Quel produit souhaitez vous acheter ?");
			Gaulois[] tabVendeur =  controlAcheterProduit.getVendeurProduit(produit);
			
			if (tabVendeur == null) {
				System.out.println(" Désolé, personne ne vend ce produit au marché");
			}
			else {
				StringBuilder message = new StringBuilder();
				
				message.append(" Chez quel commercant souhaitez vous acheter des " + produit + "? \n");
				
				for(int i = 0; i < tabVendeur.length; i++) {
					message.append((i+1) + ". " + tabVendeur[i].getNom() + "\n");
				}
				
				boolean vendeurChoisi = false;
				int indiceVendeur = -1;
				
				do {
					indiceVendeur = Clavier.entrerEntier(message.toString()) -1;
					vendeurChoisi = indiceVendeur < tabVendeur.length;
					
					if(!vendeurChoisi) {
						System.out.println("Veuillez entrer un nombre entre 1 et " + tabVendeur.length + ".");
					}
				}
				while(!vendeurChoisi);
				
				Gaulois vendeur = tabVendeur[indiceVendeur];	
				String nomVendeur = vendeur.getNom();
				
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur + ".");
				
				int quantite = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
				int quantiteAchetee = this.controlAcheterProduit.acheterProduit(vendeur, quantite);
				
				if(quantiteAchetee == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement il n'y en a plus !");
				}
				else if(quantiteAchetee < quantite) {
					System.out.println(
						nomAcheteur + " veut acheter " + quantite + " " + produit
						+ ", malheureusement " + nomVendeur + " n'en a pas plus de " + quantiteAchetee + ".\n"
						+ nomAcheteur + " achète tout le stock de " + nomVendeur + "."
					);
				}
				else {
					System.out.println(nomAcheteur + " achète " + quantite + " " + produit + " à " + nomVendeur + ".");
				}
			}
		}
	}
}
