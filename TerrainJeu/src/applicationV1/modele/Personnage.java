package applicationV1.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personnage {
	private IntegerProperty xProperty,yProperty;
	private int vitesse;
	private IntegerProperty pointDeVie;
	
	public Personnage (int x,int y,int v){
		this.xProperty=new SimpleIntegerProperty(x);
		this.yProperty =new SimpleIntegerProperty(y);
		this.vitesse=v;
		this.pointDeVie=new SimpleIntegerProperty(100);
	}
	


	public void seDeplacerAGauche() {
		this.xProperty.set(this.getX()-this.vitesse);
	}
	
	public void seDeplacerADroite() {
		this.xProperty.set(this.getX()+this.vitesse);
	}
	
	public void sauter() {
		this.yProperty.set(this.getY()-40);
	}
	
	public boolean estVivant() {
		return this.pointDeVie.get()>0;
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
	
	public final IntegerProperty pointdeVie() {
		return pointDeVie;
	}

	public void setPointDeVie(int n) {
		pointDeVie.setValue(n);
	}
	
	public final int getPointDeVie() {
		return this.pointDeVie.getValue();
	}
	
	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
}