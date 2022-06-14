package applicationV1.modele.nourriture;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class  Nourriture {
	
	private int pvDonner;
	private IntegerProperty quantiteProperty;
	private int id;

	
	public Nourriture(int id, int pvD, int i) {
		this.id = id;
		this.pvDonner = pvD;
		this.quantiteProperty = new SimpleIntegerProperty(i);
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getDonnerPV() {
		return this.pvDonner;
	}
	
	public void setDonnerPV(int pvDonner) {
		this.pvDonner = pvDonner;
	}
	
	public final IntegerProperty quantiteProperty() {
		return this.quantiteProperty;
	}
	
	public int getQuantiteProperty() {
		return this.quantiteProperty.get();
	}
	
	public void setQuantiteProperty(int quantite) {
		this.quantiteProperty.setValue(quantite);
	}

}
