package produit;

public class Poisson extends Produit{
	private String date;
	
	public Poisson(String date) {
		super("poisson", Unite.PIECE);
		this.date = date;
	}

	@Override
	public String description() {
		return "poisson pêché " + date + ".";
	}
	
	@Override
	public double calculerPrix(int prix) {
		return prix;
	}
}