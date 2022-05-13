package applicationV1;


public class Environnement {
	private int longueur, hauteur;
	
	
	public Environnement(int l,int h) {
		this.longueur=l;
		this.hauteur=h;
	}
	
	public boolean dansTerrain(int x, int y){
		return (0 <= x && x<this.longueur && 0<=y && y< this.hauteur);
	}
}

