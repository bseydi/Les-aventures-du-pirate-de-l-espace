package applicationV1.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ressources {

	private int pv;
	private int donnerPV;
	private IntegerProperty quantiteProperty;
	
	public Ressources(int pv,int donnerPV) {
		this.pv = pv;
		this.donnerPV = donnerPV;
		this.quantiteProperty =  new SimpleIntegerProperty(0);
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
	
	public final IntegerProperty quantiteProperty() {
		return quantiteProperty;
	}
	
	public IntegerProperty getQuantiteProperty() {
		return quantiteProperty;
	}

	public void setQuantiteProperty(IntegerProperty quantiteProperty) {
		this.quantiteProperty = quantiteProperty;
	}

}
