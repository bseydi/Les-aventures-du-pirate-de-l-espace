package applicationV1.modele;

public class Vie {
	
	private int longueur;
	private int largeur;
	private int[] tabCoeur;
	private int pv;
	private Personnage p;
	
	
	public Vie(Personnage p) {
		 this.largeur = 10;
		 this.p = p;
		 this.pv = p.getPointDeVie();
		 tabCoeur = new int[largeur];
		 
		 for(int i = 0; i<largeur;i++) {
				 if(pv == 100)
				 tabCoeur[i] = 10;
			 }
	}
	


	public void miseAjourTabCoeur() {
		
	
		/*if(pv==0) {
			for(int i = 0; i<largeur;i++) {
				 for(int j = 0; j<longueur; j++) {
					 tabCoeur[i][j] = 0;
				 }
			 }
		}
		else if(pv <=5) {
			for(int i = 0; i<largeur;i++) {
				 for(int j = 0; j<longueur; j++) {
					 tabCoeur[i][j] = 0;
				 }
			 }
			tabCoeur[0][0] = 2;
			
		}
		else if(pv <=10) {
			for(int i = 0; i<largeur;i++) {
				 for(int j = 0; j<longueur; j++) {
					 tabCoeur[i][j] = 0;
				 }
			 }
			tabCoeur[0][0] = 1;
			
		}
		else if(pv<=15) {
			for(int i = 0; i<largeur;i++) {
				 for(int j = 0; j<longueur; j++) {
					 tabCoeur[i][j] = 0;
				 }
			 }
			tabCoeur[0][0] = 1;
			tabCoeur[0][1] = 2;
			
		}
		else if(pv<=20) {
			for(int i = 0; i<largeur;i++) {
				 for(int j = 0; j<longueur; j++) {
					 tabCoeur[i][j] = 0;
				 }
			 }
			tabCoeur[0][0] = 1;
			tabCoeur[0][1] = 1;
			
		}
		*/
		
	}

	public int getLongueur() {
		return longueur;
	}


	public int getLargeur() {
		return largeur;
	}


	public int[] getTabCoeur() {
		return tabCoeur;
	}
}
