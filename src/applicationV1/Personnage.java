package applicationV1;

import java.util.Scanner;

import javafx.scene.input.KeyEvent;
public class Personnage {
	private int x;
	private int y;
	private int vitesse;
	private int dx,dy ;// direction 
	private Environnement env;
	private int pointDeVie;
	
	Personnage (int x,int y,int v){
		this.x=x;
		this.y=y;
		this.vitesse=v;
		this.pointDeVie=100;
	}
	
	public void seDeplacer () {
		KeyEvent e;
		
		int nouvPosX;
		int nouvPosY;
		// Tant que les nouvelle positions sont dans le terrain
		do {
			ouSeDeplacer();
			nouvPosX=this.x+this.vitesse*dx;
			nouvPosY=this.y+this.vitesse*dy;
			x=nouvPosX;
			y=nouvPosY;
			nouvPosX=this.x+this.vitesse*dx;
			nouvPosY=this.y+this.vitesse*dy;
		}while(!env.dansTerrain(nouvPosX, nouvPosY)&&estVivant());
	}
	
	public void ouSeDeplacer() {
		Scanner scanner = new Scanner(System.in);
		char c;
		c = scanner.next().charAt(0);
		if(c=='q' || c=='Q') { //aller a gauche
			this.dx=-1;
		}
		else if(c=='d' || c=='D') { // aller a droite
			this.dx=+1;
		}
	}
	
	public boolean estVivant() {
		return this.pointDeVie>0;
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

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
}

