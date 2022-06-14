package applicationV1.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personnage {
	private IntegerProperty xProperty,yProperty;
	private int vitesse; 
	private IntegerProperty pointDeVieProperty;
	private int nourritureEnMains = 1; //Sa valeur correspond à la nourriturre en mains 1=fraise 2=viandes 3=viande cuite 4=pdt 5=pdt cuites.
	private int blocEnMains = 1; //Sa valeur correspond au bloc en mains.
	private int objetEnMains = 1; //Sa valeur correspond à l'objet en mains 1 = mains, 2 = épée, 3 = hache bois, 4 = pioche en bois, 5 = pioche en pierre.                          
	private Ressources ressource;
	private Inventaire inventaire;
	
	public Personnage (int x,int y,int v){
		super();
		this.xProperty=new SimpleIntegerProperty(x);
		this.yProperty =new SimpleIntegerProperty(y);
		this.vitesse=v;
		this.pointDeVieProperty=new SimpleIntegerProperty(100);
		this.ressource = new Ressources ();
		this.inventaire = new Inventaire();
	}
	
	public void seDeplacerAGauche() {
		this.xProperty.set(this.getX()-this.vitesse);
	}
	
	public void seDeplacerADroite() {
		this.xProperty.set(this.getX()+this.vitesse);
	}
	
	public boolean estVivant() {
		return this.pointDeVieProperty.get()>0;
	}

	public final IntegerProperty xProperty() {
		return xProperty;
	}

	public final void setX(int n){
		xProperty.setValue(n);
	}

	public final int getX() {
		return this.xProperty.getValue();
	}
	
	public final IntegerProperty yProperty() {
		return yProperty;
	}
	public final void setY(int n){
		yProperty.setValue(n);
	}
	
	public final int getY() {
		return this.yProperty.getValue();
	}	
	
	public final IntegerProperty pointdeVieProperty() {
		return this.pointDeVieProperty;
	}

	public void setPointDeVie(int n) {
		pointDeVieProperty.setValue(n);
	}
	
	public final int getPointDeVie() {
		return this.pointDeVieProperty.getValue();
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
	
	//Methode qui permet de tester la perte de vie et sont affichage sur la vue
	public void perdVie() {
		if(getPointDeVie() <= 0) {
			System.out.println("Impossible de retirer de la vie");
		}else {
			pointDeVieProperty.set(this.getPointDeVie() - 1);
		}
	}
	// methodo pour tester l'ajoute de vie et son affichage
	public void gagneVie() {
		if(getPointDeVie() >= 100) {
			System.out.println("Impossible d'ajouter de la vie");
		}else {
			pointDeVieProperty.set(this.getPointDeVie() + 1);
		}
	}
	/* Sera utiliser plus tard pour faire perdre des point de vie au personnage
	 * public void perdVie(int pvPerdu) {
	 * 		setPointDeVie(getPointDeVie() += pvPerdu);
	 *}
	 */
	

}