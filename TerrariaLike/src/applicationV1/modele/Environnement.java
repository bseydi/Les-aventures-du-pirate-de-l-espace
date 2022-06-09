package applicationV1.modele;

import applicationV1.modele.fonctionnalités.Arbre;
import applicationV1.modele.fonctionnalités.Collisions;
import applicationV1.modele.nourriture.Fraise;
import applicationV1.modele.nourriture.PommeDeTerre;

public class Environnement {
	
	Terrain terrain;
	
	Personnage personnage;
	PnjCraft pnj;
	
	Arbre arbre1;
	Arbre arbre2;
	Arbre arbre3;
	
	Fraise fraise;
	PommeDeTerre pommeDeTerre;
	
	Collisions c1;
	
	
	
	public Environnement() {
		
		this.personnage = new Personnage(300,290,5);
		this.pnj = new PnjCraft(2,338);
		this.terrain = new Terrain ();
		this.c1 = new Collisions(this.personnage, this.terrain);
		this.arbre1 = new Arbre(320,260);
		this.arbre2 = new Arbre(5,290);
		this.arbre3 = new Arbre(130,290);
		this.fraise = new Fraise();
		this.pommeDeTerre = new PommeDeTerre();
	}
	
	public Terrain getTerrain() {
		return terrain;
	}



	public Personnage getPersonnage() {
		return personnage;
	}



	public PnjCraft getPnj() {
		return pnj;
	}



	public Arbre getArbre1() {
		return arbre1;
	}



	public Arbre getArbre2() {
		return arbre2;
	}



	public Arbre getArbre3() {
		return arbre3;
	}



	public Fraise getFraise() {
		return fraise;
	}



	public PommeDeTerre getPommeDeTerre() {
		return pommeDeTerre;
	}



	public Collisions getC1() {
		return c1;
	}
}
