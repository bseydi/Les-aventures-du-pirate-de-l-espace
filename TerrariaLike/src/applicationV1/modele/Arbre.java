package applicationV1.modele;

public class Arbre {
	private int arbre,x,y;
	
	public Arbre(int x,int y) {
		this.arbre=1;
		this.x=x;
		this.y=y;
	}

	public int getArbre() {
		return this.arbre;
	}

	public void setArbre(int arbre) {
		this.arbre = arbre;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void changerArbre() {
		if(this.arbre==1) {
			this.arbre=2;
		}
		else if(this.arbre==2) {
			this.arbre=1;
		}
	}	
}