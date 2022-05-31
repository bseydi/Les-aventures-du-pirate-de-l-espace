package applicationV1.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personnage {
	private IntegerProperty xProperty,yProperty;
	private int vitesse;
	private IntegerProperty pointDeVieProperty;
	private Ressources ressource;
	
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
	

}
