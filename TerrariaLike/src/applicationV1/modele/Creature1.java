package applicationV1.modele;

import applicationV1.modele.fonctionnalités.Collisions;
import applicationV1.modele.fonctionnalités.GestionErreur;
import applicationV1.modele.fonctionnalités.Range;

public class Creature1 extends Acteur {
	
	public Creature1 (int x, int y, int v, GestionErreur gn) {
		super(x, y, v, gn);
	}
	
	public void suivre(Acteur acteur, Collisions c) {
		if (this.getX() > acteur.getX()+10) {
			if (c.blocGauche(this.getX(), this.getY())) {
				this.setDirection(2);
				this.seDeplacerAGauche();
			}
			else if (!c.blocGauche(this.getX(), this.getY())) {
				super.getGn().testerEreur(7);
				this.setSauter(true);
			}
		}
		else if (this.getX() < acteur.getX()-10) {
			if (c.blocDroit(this.getX(), this.getY())) {
				this.setDirection(1);
				this.seDeplacerADroite();
			}
			else {
				super.getGn().testerEreur(7);
				this.setSauter(true);				
			}
		}		
	}	
	
	public void attaquer(Acteur acteur) {
		if (Range.rangeTo(this.getX(), this.getY(), acteur.getX(), acteur.getY())) {
			acteur.setPointDeVie(acteur.getPointDeVie()-10);
		}
	}

}
