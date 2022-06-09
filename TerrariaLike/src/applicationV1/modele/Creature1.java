package applicationV1.modele;

import applicationV1.modele.fonctionnalités.Collisions;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Creature1 extends Acteur {
	
	private IntegerProperty xProperty,yProperty;
	private int vitesse; 
	private int pointDeVie;
	
	public Creature1 (int x, int y, int v) {
		super(x, y, v);
		this.xProperty=new SimpleIntegerProperty(x);
		this.yProperty =new SimpleIntegerProperty(y);
		this.vitesse=v;
	}
	
	public void tomber2 (Collisions c, int direction , int posYInit) {
		if (c.blocDessous(this.getX(), this.getY())) {			
			if(direction == 1) {
				this.setY(this.getY()+2);
				this.setX(this.getX()+2);
				if (this.getY() == posYInit-2) {
					direction = 0;
				}
			} else if (direction == 2) {
				this.setY(this.getY()+2);
				this.setX(this.getX()-2);
				if (this.getY() == posYInit-2) {
					direction = 0;
				}
			}else {
				this.setY(this.getY()+2);
			}				
		}	
	}	
	
	public void suivreEtAttaquer() {
	
	}	
}
