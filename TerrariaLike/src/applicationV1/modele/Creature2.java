package applicationV1.modele;

import applicationV1.modele.fonctionnalités.Collisions;
import applicationV1.modele.fonctionnalités.GestionErreur;
import applicationV1.modele.fonctionnalités.Range;

public class Creature2 extends Acteur{
	
	private int aSuivre = 50; // Point que la créature suit, pour faire des allers retours dans une zone.
	private int limDroite = 50, limGauche = 410; // Les deux limites qui changent à droite et à gauche.
	
	public Creature2(int x, int y, int v, GestionErreur gn) { //position et vitesse
		super(x, y, v, gn);
	}

	public void bouger(Collisions c) {		
		if (this.getX() > aSuivre) 
			if (c.blocGauche(this.getX(), this.getY())) {
				this.seDeplacerAGauche();
			} else {
				aSuivre = this.getX();				
			}
		
		if (this.getX() == aSuivre) 
			aSuivre = limGauche;

		if (this.getX() < aSuivre) 
			if (c.blocDroit(this.getX(), this.getY())) {
				this.seDeplacerADroite();
			}else {
				aSuivre = this.getX();
			}
		
		if (this.getX() == aSuivre) 
			aSuivre = limDroite;
	}	
	
	public void attaquer(Acteur acteur) {
		if (Range.rangeTo(this.getX(), this.getY(), acteur.getX(), acteur.getY())) {
			acteur.setPointDeVie(acteur.getPointDeVie()-10);
		}
	}
}
