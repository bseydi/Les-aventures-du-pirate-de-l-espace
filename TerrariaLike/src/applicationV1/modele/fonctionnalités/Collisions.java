package applicationV1.modele.fonctionnalités;

import applicationV1.modele.Acteur;
import applicationV1.modele.Creature1;
import applicationV1.modele.Personnage;
import applicationV1.modele.Terrain;
public class Collisions {
	
	private int [] blockMap;
	private int id;

	public Collisions (Acteur p, Terrain terrain) {
		this.blockMap = terrain.getCarte();
	}

	public boolean blocDessous (int x, int y) {			// Calcule selon la position l'id du block en dessous du joueur selon le Terrain
		x = (x+32) / 32; 
		y = (y+64) / 32;
		x = x +  y *50;
		id = blockMap[x];							
		return estTraversable(id);
	}
	public boolean blocGauche (int x, int y) {			// Calcule selon la position l'id du block à gauche du joueur selon le Terrain
		x = (x + 16 ) / 32; 
		y = ( y + 64) / 32;
		x = x +  y *50;
		id = blockMap[x-50];
		return estTraversable(id);
	}
	public boolean blocDroit (int x, int y) {			// Calcule selon la position l'id du block à droite du joueur selon le Terrain
		x = ( x + 40 ) / 32; 
		y = ( y + 64 ) / 32;
		x = x +  ((y-1) *50);
		id = blockMap[x];
		return estTraversable(id);
	}
	public boolean blocDessus (int x, int y) {
		x = (x ) / 32;
		y = (y) / 32;
		x = (x-29) + y *50;
		id = blockMap[x];
		return estTraversable(id);
	}
	public boolean estTraversable (int id) { 

		return id == 0 || id >=11;
	}
}
