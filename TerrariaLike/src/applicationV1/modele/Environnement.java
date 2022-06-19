package applicationV1.modele;

import java.util.ArrayList;
import applicationV1.modele.fonctionnalités.Collisions;
import applicationV1.modele.fonctionnalités.GestionErreur;


public class Environnement {
	
	private Terrain terrain;
	
	private Personnage personnage;
	private PnjCraft pnj;

	private Arbre a;
	
	private ArrayList<Arbre> listeArbres;
	
	private Collisions c1;
	private Collisions c2;
	private Creature1 creature1;
	private Creature2 creature2;
	
	private FeuDeCamp feuDeCamp;
	
	private Fusée fusée;
	
	private GestionErreur gn;
	
	public Environnement(GestionErreur gn) {
		
		this.gn = gn;
		this.personnage = new Personnage(300,290,5, this.gn);
		this.pnj = new PnjCraft(20,430, this.gn);
		this.creature1 = new Creature1(600,290,1, this.gn);
		this.creature2 = new Creature2(300,440,1, this.gn);
		this.terrain = new Terrain ();
		this.c1 = new Collisions(this.personnage, this.terrain);
		this.c2 = new Collisions(this.creature1, this.terrain);

		this.listeArbres = new ArrayList<>();
		this.listeArbres.add(this.a = new Arbre(400, 418));
		this.listeArbres.add(this.a = new Arbre(950,322));
		this.listeArbres.add(this.a = new Arbre(700, 386));
		this.fusée = new Fusée(1500,280);
	
	}
	
	public void creerFeuDeCamp(int numéro) {
        int x,y;    
        x = numéro % 50;
        y = numéro / 50;
        y = y * 32;
        x = x * 32;
        
        this.feuDeCamp = new FeuDeCamp(x,y);
    }
	
	public FeuDeCamp getFeuDeCamp () {
        return this.feuDeCamp;
    }
	
	public Fusée getFusée() {
		return fusée;
	}
	
	public GestionErreur getGn() {
		return gn;
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
	
	public Creature2 getCreature2() {
		return creature2;
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
	
	public Collisions getC1() {
		return c1;
	}

	public Collisions getC2() {
		return c2;
	}
}
