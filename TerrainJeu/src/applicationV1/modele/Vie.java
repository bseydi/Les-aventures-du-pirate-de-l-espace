package applicationV1.modele;

public class Vie {
	
	private int longueur;
	private int largeur;
	private int[][] tabCoeur;
	private int pv;
	private Personnage p;
	
	
	public Vie(Personnage p) {
		 this.largeur = 5;
		 this.longueur = 2;
		 this.p = p;
		 this.pv = p.getPointDeVie();
		 tabCoeur = new int[largeur][longueur];
		 
		 for(int i = 0; i<largeur;i++) {
			 for(int j = 0; j<longueur; j++) {
				 tabCoeur[i][j] = 1;
			 }
		 }
	}


	public void modifTabCoeur() {
		 
		if(pv > 0 && pv <=10) {
			for(int i = 0; i<largeur;i++) {
				 for(int j = 0; j<longueur; j++) {
					 tabCoeur[i][j] = 0;
				 }
			 }
			tabCoeur[0][0] = 1;
			
		}
				
		
	}

	public int getLongueur() {
		return longueur;
	}


	public int getLargeur() {
		return largeur;
	}


	public int[][] getTabCoeur() {
		return tabCoeur;
	}
}
