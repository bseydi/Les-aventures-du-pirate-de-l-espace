package modele.fonctionnalités;

import modele.Personnage;
import modele.Terrain;
public class Collisions {

	private int [] blockMap;
	private int id;
	
	public Collisions (Personnage p, Terrain terrain) {
		this.blockMap = terrain.getCarte();
	}
	
	public boolean blocDessous (int x, int y) {			// Calcule selon la position l'id du block en dessous du joueur selon le Terrain
		x = (x+32) / 32; 
		y = (y+64) / 32;
		x = x +  y *30;
		id = blockMap[x];
		return estTraversable(id);
	}
	public boolean blocGauche (int x, int y) {			// Calcule selon la position l'id du block à gauche du joueur selon le Terrain
		x = (x + 16 ) / 32; 
		y = ( y + 64) / 32;
		x = x +  y *30;
		id = blockMap[x-30];
		return estTraversable(id);
	}
	public boolean blocDroit (int x, int y) {			// Calcule selon la position l'id du block à droite du joueur selon le Terrain
		x = ( x + 40 ) / 32; 
		y = ( y + 64 ) / 32;
		x = x +  ((y-1) *30);
		id = blockMap[x];
		return estTraversable(id);
	}
	public boolean estTraversable (int id) { // Retourne false si autre que l'id du ciel
		return id == 1;
	}
}
