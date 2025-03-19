package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder gaulois = new StringBuilder();
					gaulois.append("Bienvenue druide" + nomVisiteur + "\n");
					gaulois.append("\n");
					gaulois.append("Quelle est votre force ? \n");
					
					int forceGaulois = Clavier.entrerEntier(gaulois.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, forceGaulois);
					
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur){
		StringBuilder druide = new StringBuilder();
		druide.append("Bienvenue druide \n").append(nomVisiteur);
		druide.append("Quelle est votre force \n");
		int forceDruide = Clavier.entrerEntier(druide.toString());
		
		int effetPotionMax;
		int effetPotionMin;
		
		do{
			druide.append("Quelle est la force de potion la plus faible que vous produisez ? \n");
			effetPotionMin = Clavier.entrerEntier(druide.toString());
			druide.append("Quelle est la force de potion la plus forte que vous produisez ? \n");
			effetPotionMax = Clavier.entrerEntier(druide.toString());
			
			if (effetPotionMax < effetPotionMin){
				druide.append("Attention Druide; vous vous etes trompe entre le minimum et le maximum \n");
			}
		}while(effetPotionMax < effetPotionMin);
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);	
	}
}
