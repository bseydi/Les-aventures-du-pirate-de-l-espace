package applicationV1.modele.fonctionnalités;

import applicationV1.modele.Personnage;
import applicationV1.vue.PommeDeTerreVue;
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
		
		// permet de savoir si l'image de la pomme de terre se trouve au même endroit que la souris
		public static boolean rangeToPommeDeTerre(PommeDeTerreVue pommeDeTerreVue,Personnage perso) {
			/*for(int i=0;i<pommeDeTerreVue.getListImgPommeDeTerre().size();i=i+2) {
				if((pommeDeTerreVue.getListImgPommeDeTerre().get(i)-perso.getX())<=70 && (pommeDeTerreVue.getListImgPommeDeTerre().get(i+1)-perso.getY())<=70) {
					return true;
				}
			}*/
			/*int s=0;
			for(int i=0;i<pommeDeTerreVue.getListCoordonneeImgPommeDeTerre().size();i=i+2) {
				
				if((Math.abs(pommeDeTerreVue.getListCoordonneeImgPommeDeTerre().get(i)-perso.getX()))<=70 && (Math.abs(pommeDeTerreVue.getListCoordonneeImgPommeDeTerre().get(i+1)-perso.getY()))<=70) {
					System.out.println("coordonnee1_"+pommeDeTerreVue.getListCoordonneeImgPommeDeTerre().get(i));
					System.out.println("coordonnee2_"+pommeDeTerreVue.getListCoordonneeImgPommeDeTerre().get(i+1));
					s=i;
					return true;
				}
			}*/
			return false;
		}
		
		
		
}
