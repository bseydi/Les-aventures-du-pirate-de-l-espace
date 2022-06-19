package applicationV1.modele.fonctionnalités;

import applicationV1.modele.Personnage;

public class Range {

		public static boolean coordTile (Personnage perso, int num) {
			int x = 0;
			int y = 0;
								// Cette methode permet de retrouver les coordonnées x et y d'une tile à partir de son
			x = num % 50;		// numéro dans notre Terrain ( carte de int )
			y = num / 50;
			y = y * 32;
			x = x * 32;
			
			if (rangeTo(perso.getX(), perso.getY(), x,y))
				return true;
			
			return false;
		}
		
		public static boolean rangeTo (int xJoueur, int yJoueur, int x, int y) {    
	        if ( Math.abs(xJoueur - x) <= 70 && Math.abs(yJoueur - y) <= 70)        // Compare la position de deux éléments
	            return true;
	        
	        return false;
	    }
}
