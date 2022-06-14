package applicationV1.modele;

public class Personnage extends Acteur{
	private int nourritureEnMains = 6; //Sa valeur correspond à la nourriturre en mains .
	private int blocEnMains = 6; //Sa valeur correspond à l'objet en mains.
	private int objetEnMains = 6; //Sa valeur correspond à l'outil en mains.                          
	private Ressources ressource;
	private Inventaire inventaire;
	
	
	public Personnage(int x, int y, int v){
		super(x,y,v);
		this.ressource = new Ressources ();
		this.inventaire = new Inventaire();
	}	
	
	
	public Ressources getRessource() {
		return ressource;
	}
	
	public Inventaire getInventaire() {
		return inventaire;
	}

	public int changerItemsEnMain(int typeItem) {		
		int itemEnMain = 0;
		if (typeItem == 1) {
			nourritureEnMains++;
			if(nourritureEnMains > 5) {
				nourritureEnMains=1;
			}	
			itemEnMain = nourritureEnMains;
		}else if (typeItem == 2) {
			blocEnMains++;
			if(blocEnMains > 3) {
				blocEnMains=1;
			}		
			itemEnMain = blocEnMains;
		} else {
			objetEnMains++;
			if(objetEnMains > 6) {
				objetEnMains=1;
			}		
			itemEnMain = objetEnMains;
		}		
		return itemEnMain;
	}

	public int getNourritureEnMains() {
		return nourritureEnMains;
	}		
	
	public int getBlocEnMains() {
		return blocEnMains;
	}	

	public int getObjetEnMains() {
		return objetEnMains;
	}		
}
