package applicationV1.modele;

import javafx.beans.property.IntegerProperty;

public class Vie {
	
	private int longueur;
	private int largeur;
	private int[] tabCoeur;
	private IntegerProperty pvProperty;
	
	
	public Vie(IntegerProperty pv) {
		 this.largeur = 10;
		 this.pvProperty = pv;
		 tabCoeur = new int[largeur];
		 

		 for(int i = 0; i<largeur;i++) {
				 tabCoeur[i] = 10;
			 }
	}
	

	public void miseAjourTabCoeur() {
		int t = 0;
		do {
			for(int i = 0; i< tabCoeur.length;i++) {
				tabCoeur[i] = 0;
				t += tabCoeur[i];
			}
		}while(t != pvProperty.get());
		
	
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
	
	public final IntegerProperty pvProperty() {
		return pvProperty;
	}
	
	public final int getPv() {
		return this.pvProperty.get();
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
