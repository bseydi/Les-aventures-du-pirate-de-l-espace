package applicationV1.modele.fonctionnalités;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Arbre {
	private IntegerProperty arbreProperty;
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	
	public Arbre(int x,int y) {
		this.arbreProperty=new SimpleIntegerProperty(1);
		this.xProperty=new SimpleIntegerProperty(x);
		this.yProperty=new SimpleIntegerProperty(y);
	}

	public IntegerProperty getArbreProperty() {
		return arbreProperty;
	}

	public void setArbreProperty(IntegerProperty arbreProperty) {
		this.arbreProperty = arbreProperty;
	}
	
	public void changerArbre() {
		if(arbreProperty.getValue()==1) {
			this.arbreProperty.setValue(2);
		}else if(arbreProperty.getValue()==2) {
			this.arbreProperty.setValue(1);
		}
	}

	public IntegerProperty getxProperty() {
		return xProperty;
	}

	public void setxProperty(IntegerProperty xProperty) {
		this.xProperty = xProperty;
	}

	public IntegerProperty getyProperty() {
		return yProperty;
	}

	public void setyProperty(IntegerProperty yProperty) {
		this.yProperty = yProperty;
	}
	
}
