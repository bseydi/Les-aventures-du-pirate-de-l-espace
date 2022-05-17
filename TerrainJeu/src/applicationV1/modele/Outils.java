package applicationV1.modele;

public abstract class Outils extends Craftable {
	
	int durabilité;	
	int dégat;
	
	public Outils(int dura, int dégat) {
		this.durabilité = dura;
		this.dégat = dégat;
	}
}
