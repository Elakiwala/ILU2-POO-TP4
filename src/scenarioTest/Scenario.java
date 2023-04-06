package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegaulois.IVillage;
import villagegauloisold.DepenseMarchand;

public class Scenario {

	public static void main(String[] args) {

		IVillage village = new IVillage(){
			int nbEtalsMax = 5;
			int nbEtals;
			IEtal[] marche = new Etal[nbEtalsMax];

			@Override
			public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
				if(nbEtals < nbEtalsMax) {
					etal.installerVendeur(vendeur,produit,prix);
					marche[nbEtals] = etal;
					nbEtals += 1;
					return true;
				}
				return false;
			}

			@Override
			public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee) {
				DepenseMarchand[] depenseMarchand = new DepenseMarchand[nbEtals];
				int comptDepensesMarchant = 0;
				int nbProduitEtal = 0;
				int nbProduitObtenue = 0;
				int rechercheEtal = 0;
				double prixPaye;
				while(nbProduitObtenue < 3 && rechercheEtal < nbEtals) {
					nbProduitEtal = marche[rechercheEtal].contientProduit("sanglier", quantiteSouhaitee - nbProduitObtenue);
					if (nbProduitEtal > 0) {
						prixPaye = marche[rechercheEtal].acheterProduit(nbProduitEtal);
						Gaulois marchand = marche[rechercheEtal].getVendeur();
						 depenseMarchand[comptDepensesMarchant] = new DepenseMarchand(marchand, nbProduitEtal, produit, prixPaye);
						 comptDepensesMarchant++;
					}
					nbProduitObtenue += nbProduitEtal;
					rechercheEtal += 1;
				}
				return depenseMarchand;
			}
			
			@Override
			public String afficherVillage() {
				StringBuilder village = new StringBuilder();
				for (int i = 0; i < nbEtals; i++) {
					village.append(marche[i].etatEtal() + "\n");
				}
				return village.toString();
			}
		};

		Gaulois ordralfabetix = new Gaulois("Ordralfabetix", 9);
		Gaulois obelix = new Gaulois("Obelix", 20);
		Gaulois asterix = new Gaulois("Asterix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village.afficherVillage());

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i]);
		}

		System.out.println(village.afficherVillage());

	}

}