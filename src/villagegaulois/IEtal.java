package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;

public interface IEtal<P extends IProduit> {

	void installerVendeur(Gaulois vendeur, P[] produit, int prix);

	Gaulois getVendeur();

	double donnerPrix();

	int contientProduit(String produit, int quantiteSouhaitee);

	double acheterProduit(int quantiteSouhaitee);

	String etatEtal();

}