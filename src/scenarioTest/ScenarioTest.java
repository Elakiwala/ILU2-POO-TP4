package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
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
		
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
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
		
		Etal<Sanglier> etalObelix = new Etal<>();
		Etal<Sanglier> etalAsterix = new Etal<>();
		Etal<Poisson> etalOrdralfabetix = new Etal<>();
		
		etalObelix.installerVendeur(obelix, sangliersObelix, 8);
		etalAsterix.installerVendeur(obelix, sangliersAsterix, 10);
		etalOrdralfabetix.installerVendeur(ordralfabetix, poissons, 7);
		
		Etal[] marche = new Etal[3];
		marche[0] = etalObelix;
		marche[0] = etalAsterix;
		marche[0] = etalOrdralfabetix;
		
		int i=0;

		int nbSanglier = 3;
		int nbSanglierAch = 0;
		
		while(nbSanglier - nbSanglierAch > 0 && i < 3) {
			System.out.println("ETAT MARCHE");
			for(int j=0;j<marche.length;j++) {
				marche[j].etatEtal();
			}
			
			if(marche[i].contientProduit("sanglier", nbSanglier)>0) {
				marche[i].acheterProduit(marche[i].contientProduit("sanglier", nbSanglier));
			}
			
			i++;
		}
	}
}
