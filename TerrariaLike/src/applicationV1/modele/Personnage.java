package applicationV1.modele;
 
import applicationV1.modele.Ressources;
import applicationV1.modele.fonctionnalités.Collisions;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personnage extends Acteur{
	private int nourritureEnMains = 1; //Sa valeur correspond à la nourriturre en mains 1=fraise 2=viandes 3=viande cuite 4=pdt 5=pdt cuites.
	private int blocEnMains = 1; //Sa valeur correspond au bloc en mains.
	private int objetEnMains = 1; //Sa valeur correspond à l'objet en mains 1 = mains, 2 = épée, 3 = hache bois, 4 = pioche en bois, 5 = pioche en pierre.                          
	private Ressources ressource;
	private Inventaire inventaire;
	private int direction = 0;
	private int posYInit = 0; 
	private int temps = 0;
	
	public Personnage(int x, int y, int v){
		super(x,y,v);
		this.ressource = new Ressources ();
		this.inventaire = new Inventaire();
	}
		
	public void tomber (Collisions c, int direction , int posYInit) {
		if (c.blocDessous(this.getX(), this.getY())) {			
			if(direction == 1) {
				this.setY(this.getY()+2);
				this.setX(this.getX()+2);
				if (this.getY() == posYInit-2) {
					direction = 0;
				}
			} else if (direction == 2) {
				this.setY(this.getY()+2);
				this.setX(this.getX()-2);
				if (this.getY() == posYInit-2) {
					direction = 0;
				}
			}else {
				this.setY(this.getY()+2);
			}				
		}
		this.direction = direction;
		this.posYInit = posYInit;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public int getPosYInit() {
		return posYInit;
	}
	
	public void sauter (int direction, int temps) {
		if(direction == 1) {
			this.setY(this.getY()-2);
			this.setX(this.getX()+1);
		} else if (direction == 2) {
			this.setY(this.getY()-2);
			this.setX(this.getX()-1);
		}else {
			this.setY(this.getY()-2);
		}
		temps++;	
		this.temps = temps;
	}
	
	public int getTemp() {
		return this.temps;
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
			if(blocEnMains > 2) {
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
