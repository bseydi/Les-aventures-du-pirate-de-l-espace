package applicationV1.modele;

import java.util.Scanner;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.input.KeyEvent;

public class Personnage {
	private IntegerProperty xProperty,yProperty;
	private int vitesse;
	private int dx,dy ;// direction 
	private Environnement env;
	private int pointDeVie;
	
	Personnage (int x,int y,int v){
		this.xProperty=new SimpleIntegerProperty(x);
		this.yProperty =new SimpleIntegerProperty(y);
		this.vitesse=v;
		this.pointDeVie=100;
	}
	
	public void seDeplacerAGauche() {
		this.xProperty.set(this.getX()-this.vitesse);
	}
	
	public void seDeplacerADroite() {
		this.xProperty.set(this.getX()+this.vitesse);
	}
	
	public void seDeplacerEnHaut() {
		this.yProperty.set(this.getY()+this.vitesse);
	}
	
	public void seDeplacerEnBas() {
		this.yProperty.set(this.getY()-this.vitesse);
	}
	
	public boolean estVivant() {
		return this.pointDeVie>0;
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

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
}
