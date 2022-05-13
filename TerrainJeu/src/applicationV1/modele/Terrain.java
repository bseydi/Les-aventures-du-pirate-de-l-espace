package applicationV1.modele;


public class Terrain {
	private int longueur;
	private int largeur;
	private int[][] carte;


	public Terrain (int largeur, int longueur) {
		carte = new int [largeur][longueur];
		
		
		
		for(int ligne = 0; ligne < carte.length ;ligne++) {
			for (int colonne = 0; colonne < carte[ligne].length; colonne++) {
				    if (ligne <= carte.length/2) {
				    	carte[ligne][colonne] = 0;				    
				    }else {
				    	carte[ligne][colonne] = 1;
				    }
			}
			
		}
		
		/*carte[5][0] = 1;
		carte[5][4] = 1;
		carte[5][5] = 1;
		carte[5][6] = 1;
		carte[5][7] = 1;
		carte[4][5] = 1;
		carte[4][6] = 1;
		carte[4][7] = 1;*/
		
		
	}
	
	public void afficherTableau() {     
		
        for(int ligne = 0; ligne < this.carte.length ;ligne++) {
            for (int colonne = 0; colonne < this.carte[ligne].length; colonne++) {
                System.out.print(this.carte[ligne][colonne]);
                System.out.print("|");
            }
            System.out.println();
        }
		
	}

	public int getLongueur() {
		return longueur;
	}


	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}


	public int getLargeur() {
		return largeur;
	}


	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}


	public int[][] getCarte() {
		return carte;
	}


	public void setCarte(int[][] terrain) {
		this.carte = terrain;
	}
	
}
