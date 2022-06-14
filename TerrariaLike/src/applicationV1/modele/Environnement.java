package applicationV1.modele;

import applicationV1.modele.fonctionnalités.Collisions;
import applicationV1.modele.nourriture.Fraise;
import applicationV1.modele.nourriture.Nourriture;
import applicationV1.modele.nourriture.PommeDeTerre;
import applicationV1.vue.ArbreVue;

public class Environnement {
	
	private Terrain terrain;
	
	private Personnage personnage;
	private PnjCraft pnj;
	
	private Arbre arbre1;
	private Arbre arbre2;
	private Arbre arbre3;

	private Nourriture fraise;
	private Nourriture pommeDeTerre;
	
	private Collisions c1;
	
	
	
	public Environnement() {
		
		this.personnage = new Personnage(300,290,5);
		this.pnj = new PnjCraft(20,430);
		this.terrain = new Terrain ();
		this.c1 = new Collisions(this.personnage, this.terrain);
		this.fraise = new Fraise();
		this.pommeDeTerre = new PommeDeTerre();
		this.arbre1 = new Arbre(400, 418);
		this.arbre2 = new Arbre(950,322);
		this.arbre3 = new Arbre(700, 386);
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

	public Nourriture getFraise() {
		return fraise;
	}

	public Nourriture getPommeDeTerre() {
		return pommeDeTerre;
	}

	public Collisions getC1() {
		return c1;
	}
	
}
