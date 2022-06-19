package applicationV1.modele.nourriture;

import java.util.Random;

public class PommeDeTerre extends Nourriture{

	private int x,y;
	private int xMin,xMax,yMin,yMax;
	private Random randomX;
	private Random randomY;



	public PommeDeTerre() {
		super(4,5,0);
		this.xMin=0; // valeur minimal de x
		this.xMax=1600; // valeur maximal de x
		this.yMin=500; // valeur minimal de y
		this.yMax=700; // valeur maximal de y
		
		randomX = new Random();
		randomY = new Random();
		

		x=xMin+this.randomX.nextInt(xMax-xMin); // valeur aléatoire de x pour positionner l'image sur le plateau de jeu
		y=yMin+this.randomY.nextInt(yMax-yMin); // valeur aléatoire de y pour positionner l'image sur le plateau de jeu
		
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
}
