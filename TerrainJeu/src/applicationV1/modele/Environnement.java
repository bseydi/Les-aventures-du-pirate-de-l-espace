package applicationV1.modele;

public class Environnement {
	
	private Terrain terrain;
	private int[][] carte;
	
	public Environnement(Terrain t) {
		
		this.terrain = t;
		carte = t.getCarte();
	}

}
