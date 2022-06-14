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
	private Arbre a;
	
	
	private ArrayList<Arbre> listeArbres;
	
	private Collisions c1;
	private Collisions c2;
	private Creature1 creature1;
	
	public Environnement() {
		
		this.personnage = new Personnage(300,290,5);
		this.pnj = new PnjCraft(20,430);
		this.creature1 = new Creature1(600,290,1);
		this.terrain = new Terrain ();
		this.c1 = new Collisions(this.personnage, this.terrain);
		this.c2 = new Collisions(this.creature1, this.terrain);
		this.fraise = new Fraise();
		this.pommeDeTerre = new PommeDeTerre();

		this.arbre1 = new Arbre(400, 418);
		this.arbre2 = new Arbre(950,322);
		this.arbre3 = new Arbre(700, 386);

		this.listeArbres = new ArrayList<>();
		this.listeArbres.add(this.a = new Arbre(400, 418));
		this.listeArbres.add(this.a = new Arbre(950,322));
		this.listeArbres.add(this.a = new Arbre(700, 386));
	
	}
	
	public Terrain getTerrain() {
		return terrain;
	}

	public Personnage getPersonnage() {
		return personnage;
	}


	public Creature1 getCreature1() {
		return creature1;
	}
	
	public PnjCraft getPnj() {
		return pnj;
	}

	public Arbre getArbre1() {
		return this.listeArbres.get(0);
	}

	public Arbre getArbre2() {
		return this.listeArbres.get(1);
	}

	public Arbre getArbre3() {
		return this.listeArbres.get(2);
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

	public Collisions getC2() {
		return c2;
	}
}
