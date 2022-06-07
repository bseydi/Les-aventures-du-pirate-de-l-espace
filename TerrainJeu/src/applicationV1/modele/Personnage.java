package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personnage {
	private IntegerProperty xProperty,yProperty;
	private int vitesse;
	private IntegerProperty pointDeVieProperty;
	private Ressources ressource;
	private int nourritureEnMains = 0; //Sa valeur correspond à la nourriturre en mains 1=fraise 2=viandes 3=viande cuite 4=pdt 5=pdt cuites.
	private int BlocEnMains = 0; //Sa valeur correspond au bloc en mains.
	private int objetEnMains = 0; //Sa valeur correspond à l'objet en mains.
	
	public Personnage (int x,int y,int v){
		this.xProperty=new SimpleIntegerProperty(x);
		this.yProperty =new SimpleIntegerProperty(y);
		this.vitesse=v;
		this.pointDeVieProperty=new SimpleIntegerProperty(100);
		this.ressource = new Ressources ();
		
	}
	
	public Ressources getRessource() {
		return ressource;
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
	
	public final void setY(int n){
		yProperty.setValue(n);
	}
	
	public final int getY() {
		return this.yProperty.getValue();
	}
	
	public final IntegerProperty yProperty() {
		return yProperty;
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

	public int changerNourriture() {
		nourritureEnMains++;
		if(nourritureEnMains > 5) {
			nourritureEnMains=1;
		}		
		return nourritureEnMains;
	}

	public int getNourritureEnMains() {
		return nourritureEnMains;
	}	
	
	public int changerBloc() {
		BlocEnMains++;
		if(BlocEnMains > 5) {
			BlocEnMains=1;
		}		
		return BlocEnMains;
	}

	public int getBlocEnMains() {
		return BlocEnMains;
	}	
	
	public int changerObjet() {
		objetEnMains++;
		if(objetEnMains > 5) {
			objetEnMains=1;
		}		
		return objetEnMains;
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
