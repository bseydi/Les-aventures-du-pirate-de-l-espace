package applicationV1.modele.fonctionnalités;

import applicationV1.modele.Personnage;
public class Range {

		public static boolean coordTile (Personnage perso, int num) {
			int x = 0;
			int y = 0;

			x = num % 30;
			y = num / 30;
			y = y * 32;
			x = x * 32;
			if ( Math.abs(perso.getX() - x) <= 70 && Math.abs(perso.getY() - y) <= 70)
				return true;
			
			return false;
		}
		
}
