package applicationV1.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personnage extends Acteur{
	private int blocEnMains = 6; //Sa valeur correspond à l'objet en mains.
	private int objetEnMains = 6; //Sa valeur correspond à l'outil en mains.   
	private IntegerProperty pointDeNourritureProperty;
	private Ressources ressource;
	private Inventaire inventaire;
	private int idNourriture = 1;
	private int i ;
	
	
	public Personnage(int x, int y, int v){
		super(x,y,v);
		this.ressource = new Ressources ();
		this.inventaire = new Inventaire();
		this.pointDeNourritureProperty=new SimpleIntegerProperty(100);
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
			if(this.i >=5) {
				i = 0;
			}
			System.out.println(i);
			this.idNourriture = this.inventaire.getListeNourriture().get(i).getId();
			itemEnMain = this.idNourriture;
			this.i++;

		}
		else if (typeItem == 2) {
			blocEnMains++;
			if(blocEnMains > 3) {
				blocEnMains=1;
			}		
			itemEnMain = blocEnMains;
		}
		else {
			objetEnMains++;
			if(objetEnMains > 6) {
				objetEnMains=1;
			}		
			itemEnMain = objetEnMains;
		}		
		return itemEnMain;
	}
	
	public final IntegerProperty pointdeNourritureProperty() {
		return this.pointDeNourritureProperty;
	}

	public void setPointDeNourriture(int n) {
		pointDeNourritureProperty.setValue(n);
	}
	
	public final int getPointDeNourriture() {
		return this.pointDeNourritureProperty.getValue();
	}
	
	public void perdNourriture() {
		if(getPointDeNourriture() <= 0) {
			System.out.println("Impossible de retirer de la vie");
		}else {
			setPointDeNourriture(getPointDeNourriture() - 10);
		}
	}
	// methode pour tester l'ajoute du nb de nourriture et son affichage
	public void manger() {
		if(getPointDeNourriture() >= 100) {
			System.out.println("Impossible d'ajouter de la vie");
		}else {
			setPointDeNourriture(getPointDeNourriture() + 10);
		}
	}

	public int getIdNOurriture() {
		return this.idNourriture;
	}		
	
	public int getBlocEnMains() {
		return blocEnMains;
	}	

	public int getObjetEnMains() {
		return objetEnMains;
	}	
}
