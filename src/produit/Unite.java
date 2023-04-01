package produit;

public enum Unite {
	GRAMME("gramme"), KILOGRAMME("kilogramme"), LITRE("litre"), CENTILITRE("centilitre"), MILLILITRE("millilitre"), PIECE("piece");
	
	private String nom;
	
	private Unite(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return nom;
	}
}
