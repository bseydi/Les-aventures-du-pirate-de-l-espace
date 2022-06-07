package applicationV1.modele;

import javafx.beans.property.IntegerProperty;

public class Vie {
	
	private IntegerProperty pv; 
	
	public Vie(IntegerProperty pvProperty) {
		
		this.pv = pvProperty;
		 
	}
	public final IntegerProperty pvProperty() {
		return pv;
	}
	
	public final int getPv() {
		return this.pv.get();
	}

	
}
