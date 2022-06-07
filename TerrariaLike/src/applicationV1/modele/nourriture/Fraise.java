package applicationV1.modele.nourriture;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Fraise {

	private int donnerPV;
	private IntegerProperty quantiteProperty;

	public Fraise() {
		this.donnerPV = 8;
		this.quantiteProperty =  new SimpleIntegerProperty(0);
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
	
	public void setQuantiteProperty(int quantite) {
		this.quantiteProperty.setValue(quantite);
	}
}