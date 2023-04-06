package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import produit.Unite;
import villagegaulois.Etal;
import villagegaulois.IEtal;

public class ScenarioTest{
	public static void main(String[] args) {
		/*
		Etal<Sanglier> etalSanglier = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();
		marche[0] = etalSanglier;
		marche[1] = etalPoisson;
	
		IEtal[] etals = new IEtal[3];
		Etal<Sanglier> etalSanglier = new Etal<>();
		etals[0] = etalSanglier;
		*/
		
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix",9);
		Gaulois obelix = new Gaulois("Obélix",20);
		Gaulois asterix = new Gaulois("Asterix", 6);

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);
		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		Sanglier[] sangliersAsterix = {sanglier3, sanglier4};
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};
		
		IEtal[] marche = new Etal[3];
		Etal<Sanglier> etalSanglier1 = new Etal<>();
		Etal<Sanglier> etalSanglier2 = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();
		marche[0]= etalSanglier1;
		marche[1] = etalSanglier2;
		marche[2] = etalPoisson;
		
	
		etalSanglier1.installerVendeur(asterix, sangliersAsterix, 10);
		etalSanglier2.installerVendeur(obelix, sangliersObelix, 8);
		etalPoisson.installerVendeur(ordralfabetix, poissons, 7);
		
		System.out.println("ETAT MARCHE");
		System.out.println(marche[0].etatEtal());
		System.out.println(marche[1].etatEtal());
		System.out.println(marche[2].etatEtal());
		
		int nbSanglierVoulu = 3;
		int nbSanglierEtal = 0;
		int nbSanglierTotal = 0;
		int rechercheEtal = 0;
		double prixPaye;
		while(nbSanglierTotal < 3 && rechercheEtal < marche.length ) {
			nbSanglierEtal = marche[rechercheEtal].contientProduit("sanglier", nbSanglierVoulu - nbSanglierTotal);
			if (nbSanglierEtal > 0) {
				prixPaye = marche[rechercheEtal].acheterProduit(nbSanglierEtal);
				System.out.println("A l'etal " + rechercheEtal + " je paye " + prixPaye + " sous.");
			}
			nbSanglierTotal += nbSanglierEtal;
			rechercheEtal += 1;
		}
		System.out.println("je voulais " + nbSanglierVoulu + " sangliers, j'en ai achete " + nbSanglierTotal);
		System.out.println("\nETAT MARCHE");
		System.out.println(marche[0].etatEtal());
		System.out.println(marche[1].etatEtal());
		System.out.println(marche[2].etatEtal());
	}
}
