package applicationV1.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Fusée {
	
	private IntegerProperty xProperty,yProperty;
	private boolean envol = false; // Quand elle passée à true la fusée s'envole. 
	
	public Fusée (int x, int y) {
		this.xProperty=new SimpleIntegerProperty(x);
		this.yProperty =new SimpleIntegerProperty(y);		
	}
	
	public void décollage () {
		this.yProperty().set(getY()-2);
	}
	
	public boolean isEnvol() {
		return envol;
	}

	public void setEnvol(boolean envol) {
		this.envol = envol;
	}
	
	public final int getX() {
		return this.xProperty.getValue();
	}
	
	public final int getY() {
		return this.yProperty.getValue();
	}
	
	public IntegerProperty xProperty() {
		return xProperty;
	}

	public IntegerProperty yProperty() {
		return yProperty;
	}
}
