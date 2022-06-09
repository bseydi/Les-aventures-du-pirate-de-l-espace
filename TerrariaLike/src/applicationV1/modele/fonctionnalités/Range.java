package applicationV1.modele.fonctionnalités;

import applicationV1.modele.Personnage;
import applicationV1.vue.PommeDeTerreVue;
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
		// permet de savoir si l'image de la pomme de terre se trouve au même endroit que la souris
		public static boolean rangeToPommeDeTerre(PommeDeTerreVue pommeDeTerreVue,Personnage perso) {
			for(int i=0;i<pommeDeTerreVue.getListImgPommeDeTerre().size();i=i+2) {
				if((pommeDeTerreVue.getListImgPommeDeTerre().get(i)-perso.getX())<=70 && (pommeDeTerreVue.getListImgPommeDeTerre().get(i+1)-perso.getY())<=70) {
					return true;
				}
			}
			return false;
		}
}