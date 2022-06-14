package applicationV1.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Arbre {
	private int arbre,x,y;
	
	public Arbre(int x,int y) {
		this.arbre=1;
		this.x=x;
		this.y=y;
	}

	public int getArbre() {
		return arbre;
	}

	public void setArbre(int arbre) {
		this.arbre = arbre;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void changerArbre() {
		if(arbre==1) {
			this.arbre=2;
		}else if(arbre==2) {
			this.arbre=1;
		}
	}	
}