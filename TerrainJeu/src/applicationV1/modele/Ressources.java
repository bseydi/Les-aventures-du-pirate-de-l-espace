package applicationV1.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ressources {

	private int pv;
	private int donnerPV;
	private IntegerProperty nbBoisProperty;
	private IntegerProperty nbPierreProperty;
	private IntegerProperty nbFerProperty;
	
	public Ressources(int pv,int donnerPV) {
		this.pv = pv;
		this.donnerPV = donnerPV;
		this.nbBoisProperty =  new SimpleIntegerProperty(1);
		this.nbPierreProperty =  new SimpleIntegerProperty(2);
		this.nbFerProperty =  new SimpleIntegerProperty(3);
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public int getDonnerPV() {
		return donnerPV;
	}

	public void setDonnerPV(int donnerPV) {
		this.donnerPV = donnerPV;
	}

	public IntegerProperty getNbBoisProperty() {
		return this.nbBoisProperty;
	}
	public IntegerProperty getNbPierreProperty() {
		return this.nbPierreProperty;
	}
	public IntegerProperty getNbFerProperty() {
		return this.nbFerProperty;
	}
	public void setBoisProperty(int quantite) {
		this.nbBoisProperty.setValue(quantite);
	}
	public void setPierreProperty(int quantite) {
		this.nbPierreProperty.setValue(quantite);
	}
	public void setFerProperty(int quantite) {
		this.nbFerProperty.setValue(quantite);
	}
	
}
