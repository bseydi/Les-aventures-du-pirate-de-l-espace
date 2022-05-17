package applicationV1.modele;


public class Terrain {
	private int longueur;
	private int largeur;
	private int[][] carte;


	public Terrain (int largeur, int longueur) {
		carte = new int [largeur][longueur];
		this.longueur = longueur;
		this.largeur = largeur;
		
		for(int ligne = 0; ligne < carte.length ;ligne++) {
			for (int colonne = 0; colonne < carte[ligne].length; colonne++) {
				    if (ligne <= carte.length/2) {
				    	carte[ligne][colonne] = 0;				    
				    }else if (ligne > carte.length/2) {
				    	carte[ligne][colonne] = 1;
				    }
				    if(ligne == carte.length/2 +1) {
				    	carte[ligne][colonne] = 2;
				    }
			}			
		}	
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