package applicationV1.modele.fonctionnalités;

import applicationV1.modele.Personnage;
import applicationV1.modele.PnjCraft;
public class Range {

		public static boolean coordTile (Personnage perso, int num) {
			int x = 0;
			int y = 0;

			x = num % 50;
			y = num / 50;
			y = y * 32;
			x = x * 32;
			if ( Math.abs(perso.getX() - x) <= 70 && Math.abs(perso.getY() - y) <= 70)
				return true;
			
			return false;
		}
		
		public static boolean rangeToPnj (Personnage perso, PnjCraft pnj) {
			return Math.abs(perso.getX() - pnj.getX()) <= 70 && Math.abs(perso.getY() - pnj.getY()) <= 70;
		}
		
}
