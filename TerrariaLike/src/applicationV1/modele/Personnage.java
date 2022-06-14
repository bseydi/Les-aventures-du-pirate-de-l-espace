package applicationV1.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personnage {
	private IntegerProperty xProperty,yProperty;
	private int vitesse; 
	private IntegerProperty pointDeVieProperty;
	private IntegerProperty pointDeNourritureProperty;
	private int blocEnMains = 1; //Sa valeur correspond au bloc en mains.
	private int objetEnMains = 1; //Sa valeur correspond à l'objet en mains 1 = mains, 2 = épée, 3 = hache bois, 4 = pioche en bois, 5 = pioche en pierre.                          
	private Ressources ressource;
	private Inventaire inventaire;
	private int idNourriture = 1;
	private int i ;
	
	public Personnage (int x,int y,int v){
		super();
		this.xProperty=new SimpleIntegerProperty(x);
		this.yProperty =new SimpleIntegerProperty(y);
		this.vitesse=v;
		this.pointDeVieProperty=new SimpleIntegerProperty(100);
		this.pointDeNourritureProperty=new SimpleIntegerProperty(100);
		this.ressource = new Ressources ();
		this.inventaire = new Inventaire();
		this.i = 1;
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
	
	public final IntegerProperty pointdeNourritureProperty() {
		return this.pointDeNourritureProperty;
	}

	public void setPointDeNourriture(int n) {
		pointDeNourritureProperty.setValue(n);
	}
	
	public final int getPointDeNourriture() {
		return this.pointDeNourritureProperty.getValue();
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

		} else if (typeItem == 2) {
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
			setPointDeVie(getPointDeVie() - 10);
		}
	}
	// methodo pour tester l'ajoute de vie et son affichage
	public void gagneVie() {
		if(getPointDeVie() >= 100) {
			System.out.println("Impossible d'ajouter de la vie");
		}else {
			setPointDeVie(getPointDeVie() + 10);
		}
	}
	//Methode qui permet de tester la perte du nb nourriture et sont affichage sur la vue

	public void perdNourriture() {
		if(getPointDeNourriture() <= 0) {
			System.out.println("Impossible de retirer de la vie");
		}else {
			setPointDeNourriture(getPointDeNourriture() - 10);
		}
	}
	// methodo pour tester l'ajoute du nb de nourriture et son affichage
	public void manger() {
		if(getPointDeNourriture() >= 100) {
			System.out.println("Impossible d'ajouter de la vie");
		}else {
			setPointDeNourriture(getPointDeNourriture() + 10);
		}
	}
	
	/* Sera utiliser plus tard pour faire perdre des point de vie au personnage
	 * public void perdVie(int pvPerdu) {
	 * 		setPointDeVie(getPointDeVie() += pvPerdu);
	 *}
	 */
	

}