package applicationV1.modele;

import applicationV1.modele.fonctionnalités.Collisions;
import applicationV1.modele.fonctionnalités.GestionErreur;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Acteur {
	private IntegerProperty xProperty,yProperty;
	private int vitesse; 
	private IntegerProperty pointDeVieProperty;
	private GestionErreur gn;
	private int direction = 0;
	private int posYInit = 0; 
	private boolean remettreDirection0 = false;
	private boolean sauter = false;
	private int temps = 0;
	
	public Acteur (int x,int y,int v, GestionErreur gn) {
		this.xProperty=new SimpleIntegerProperty(x);
		this.yProperty =new SimpleIntegerProperty(y);
		this.vitesse=v;
		this.pointDeVieProperty=new SimpleIntegerProperty(100);
		this.gn = gn;
	}
	
	public static void tomber (Acteur acteur, Collisions c, int direction , int posYInit) { // Gravité : fait tomber l'acteur dans une direction ou tout droit
		if (c.blocDessous(acteur.getX(), acteur.getY())) {			
			if(direction == 1) {
				acteur.setY(acteur.getY()+2);
				acteur.setX(acteur.getX()+2);
				if (acteur.getY() == posYInit-2) {
					direction = 0;
				}
			}
			else if (direction == 2) {
				acteur.setY(acteur.getY()+2);
				acteur.setX(acteur.getX()-2);
				if (acteur.getY() == posYInit-2) {
					direction = 0;
				}
			}
			else {
				acteur.setY(acteur.getY()+2);
			}				
		}	
	}
	
	public static void limiteDeMap (Acteur a) {
        if ( a.getX() > 1550) {
            a.setX(20);
            a.setY(415);
        }       
        if ( a.getX() < 0) {
            a.setX(1540);
            a.setY(350);
        }
    }
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getPosYInit() {
		return posYInit;
	}

	public void setPosYInit(int posYInit) {
		this.posYInit = posYInit;
	}

	public boolean isRemettreDirection0() {
		return remettreDirection0;
	}

	public void setRemettreDirection0(boolean remettreDirection0) {
		this.remettreDirection0 = remettreDirection0;
	}

	public boolean isSauter() {
		return sauter;
	}

	public void setSauter(boolean sauter) {
		this.sauter = sauter;
	}

	public void saut(Collisions c, int direction) { // permet à l'acteur de décoller dans une direction ou sur place
		//if (c.blocDroit(this.getX(), this.getY()) && c.blocGauche(this.getX(), this.getY())) {
			if(direction == 1) {
				this.setY(this.getY()-2);
				this.setX(this.getX()+1);
			} else if (direction == 2) {
				this.setY(this.getY()-2);
				this.setX(this.getX()-1);
			}else {
				this.setY(this.getY()-2);
			}
		//}
	}
	
	public int getTemp() {
		return this.temps;
	}
			
	public void setTemps(int temps) {
		this.temps = temps;
	}

	public void seDeplacerAGauche() {
		this.xProperty.set(this.getX()-this.vitesse);
	}
	
	public void seDeplacerADroite() {
		this.xProperty.set(this.getX()+this.vitesse);
	}
	
	public boolean estVivant() {
		return this.pointDeVieProperty.get()>0;
	}

	public final IntegerProperty xProperty() {
		return xProperty;
	}

	public final void setX(int n){
		xProperty.setValue(n);
	}

	public final int getX() {
		return this.xProperty.getValue();
	}
	
	public final IntegerProperty yProperty() {
		return yProperty;
	}
	public final void setY(int n){
		yProperty.setValue(n);
	}
	
	public final int getY() {
		return this.yProperty.getValue();
	}	
	
	public final IntegerProperty pointdeVieProperty() {
		return this.pointDeVieProperty;
	}
	
	//Methode qui permet de tester la perte de vie et sont affichage sur la vue
		public void perdVie() {
			if(getPointDeVie() <= 0) {
				this.gn.testerEreur(3);
			}else {
				setPointDeVie(getPointDeVie() - 10);
			}
		}
		// methodo pour tester l'ajoute de vie et son affichage
		public void gagneVie() {
			if(getPointDeVie() >= 100) {
				this.gn.testerEreur(2);
			}else {
				setPointDeVie(getPointDeVie() + 10);
			}
		}

	public GestionErreur getGn() {
			return gn;
		}

	public void setPointDeVie(int n) {
		pointDeVieProperty.setValue(n);
	}
	
	public final int getPointDeVie() {
		return this.pointDeVieProperty.getValue();
	}
	
	
}
