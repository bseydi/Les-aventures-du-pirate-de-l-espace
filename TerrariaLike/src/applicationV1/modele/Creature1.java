package applicationV1.modele;

import applicationV1.modele.fonctionnalités.Collisions;

public class Creature1 extends Acteur {
	
	public Creature1 (int x, int y, int v) {
		super(x, y, v);
	}
	
	public void suivre(Acteur acteur, Collisions c) {
		if (this.getX() > acteur.getX()+10) {
			if (c.blocGauche(this.getX(), this.getY())) {
				this.seDeplacerAGauche();
			}else if (!c.blocGauche(this.getX(), this.getY())) {
				System.out.println("BloquéG");
				this.setSauter(true);
			}
		}else if (this.getX() < acteur.getX()-10) {
			if (c.blocDroit(this.getX(), this.getY())) {
				this.seDeplacerADroite();
			}else {
				System.out.println("BloquéD");
				this.setSauter(true);				
			}
		}		
	}	
	
	public void attaquer(Acteur acteur) {
		if (this.getX() > acteur.getX() && this.getX() < acteur.getX()+20 || this.getX() < acteur.getX() && this.getX() > acteur.getX()-20) {						
				acteur.setPointDeVie(acteur.getPointDeVie()-1);
		}			
	}
}
