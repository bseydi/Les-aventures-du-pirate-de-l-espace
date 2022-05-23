package applicationV1.modele.fonctionnalités;

import applicationV1.modele.Personnage;
import applicationV1.modele.Terrain;
public class Collisions {

	private int [] blockMap;
	private int id;
	
	public Collisions (Personnage p, Terrain terrain) {
		this.blockMap = terrain.getCarte();
	}
	
	public boolean blocDessous (int x, int y) {			// Calcule selon la position l'id du block en dessous du joueur selon le Terrain
		x = x / 32; 
		y = y / 32;
		x = x +  y *30;
		id = blockMap[x];
		return estTraversable(id);
	}
	public boolean blocGauche (int x, int y) {			// Calcule selon la position l'id du block à gauche du joueur selon le Terrain
		x = ( x - 32 )/ 32; 
		y = y / 32;
		Math.ceil(x);
		Math.ceil(y);
		x = ( x * 20  ) + ( y + 1 );
		id = blockMap[x];
		return estTraversable(id);
	}
	public boolean blocDroit (int x, int y) {			// Calcule selon la position l'id du block à droite du joueur selon le Terrain
		x = ( x + 32 ) / 32; 
		y = y / 32;
		Math.ceil(x);
		Math.ceil(y);
		x = ( x * 20  ) + ( y + 1 );
		id = blockMap[x];
		return estTraversable(id);
	}
	public boolean estTraversable (int id) { // Retourne false si autre que l'id du ciel
		return id == 1;
	}
}