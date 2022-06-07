package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ressources {

	private IntegerProperty nbBoisProperty;
	private IntegerProperty nbPierreProperty ;
	private IntegerProperty nbFerProperty;
	
	public Ressources() {
		this.nbBoisProperty =  new SimpleIntegerProperty(0);
		this.nbPierreProperty =  new SimpleIntegerProperty(0);
		this.nbFerProperty =  new SimpleIntegerProperty(0);
	}

	public final int getNbPierre() {
		return this.nbPierreProperty.getValue();
	}
	public final void setNbPierre(int quantite) {
		this.nbPierreProperty.setValue(quantite);
	}
	public final IntegerProperty nombrePierreProperty() {
		return this.nbPierreProperty;
	}
	public final void ajoutPierre(int quantite) {
		setNbPierre(getNbPierre() + quantite);
	}
	public final void retirerPierre(int quantite) {
		setNbPierre(getNbPierre() - quantite);
	}
	
	public final int getNbBois() {
		return this.nbBoisProperty.getValue();
	}
	public final void setNbBois (int quantite) {
		this.nbBoisProperty.setValue(quantite);
	}
	public final IntegerProperty nombreBoisProperty() {
		return this.nbBoisProperty;
	}
	public final void ajoutBois(int quantite) {
		setNbBois(getNbBois() + quantite);
	}
	public final void retirerBois(int quantite) {
		setNbBois(getNbBois() - quantite);
	}
	
	public final int getNbFer () {
		return this.nbFerProperty.getValue();
	}
	public final void setNbFer (int quantite) {
		this.nbFerProperty.setValue(quantite);
	}
	public final IntegerProperty nombreFerProperty() {
		return this.nbFerProperty;
	}
	public final void ajoutFer (int quantite ) {
		setNbFer(getNbFer() + quantite);
	}
	public final void retirerFer (int quantite) {
		setNbFer(getNbFer() - quantite);
	}
	
}
