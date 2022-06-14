package applicationV1.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PnjCraft {

	
	private IntegerProperty xProperty,yProperty;
	
	

	public PnjCraft(int x, int y) {
		
		this.xProperty=new SimpleIntegerProperty(x);
		this.yProperty =new SimpleIntegerProperty(y);

	}


	public void dialogue(Personnage perso, int choix) {
		try {
			switch(choix) {
			case 1 :
				if ( perso.getRessource().getNbBois() >= 1 && perso.getRessource().getNbPierre() >= 2) {
					perso.getRessource().retirerBois(1);
					perso.getRessource().retirerPierre(2);
					perso.getInventaire().ajouterOutils("EpéeEnPierre");
					
				}
				break;
			case 2 :
				if ( perso.getRessource().getNbBois() >= 1 && perso.getRessource().getNbFer() >= 2 ) {
					perso.getRessource().retirerBois(1);
					perso.getRessource().retirerFer(2);
					perso.getInventaire().ajouterOutils("EpéeEnFer");
				}
				break;
			case 3 :
				if ( perso.getRessource().getNbBois() >= 2 && perso.getRessource().getNbPierre() >= 3 ) {
					perso.getRessource().retirerBois(2);
					perso.getRessource().retirerPierre(3);
					perso.getInventaire().ajouterOutils("HacheEnPierre");
				}
				break;
			case 4 :
				if ( perso.getRessource().getNbBois() >= 5 ) {
					perso.getRessource().retirerBois(5);
					perso.getInventaire().ajouterOutils("PiocheEnBois");
				}
				break;
			case 5 :
				if ( perso.getRessource().getNbBois() >= 2 && perso.getRessource().getNbPierre() >= 3 ) {
					perso.getRessource().retirerBois(2);
					perso.getRessource().retirerPierre(3);
					perso.getInventaire().ajouterOutils("PiocheEnPierre");
				}
				break;
			case 6 :
				if ( perso.getRessource().getNbPierre() >= 4 ) {
					perso.getRessource().retirerPierre(4);	
					perso.getInventaire().ajouterObjets("MurDepierre",1);
				}
				break;
			case 7 :
				if ( perso.getRessource().getNbBois() >= 4 ) {
					perso.getRessource().retirerBois(4);
					perso.getInventaire().ajouterObjets("Planche",1);
				}
				break;
			case 8 :
				if ( perso.getRessource().getNbBois() >= 2 && perso.getRessource().getNbPierre() >= 2 ) {
					perso.getRessource().retirerBois(2);
					perso.getRessource().retirerPierre(2);	
					perso.getInventaire().ajouterObjets("FeuDeCamp",1);								
				}
				default :	break;
				
			}
		} 
		catch ( Exception e1) 
		{ System.out.println(" Saisie invalide ! ");
			
		}		
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
	
	public final void setY(int n){
		yProperty.setValue(n);
	}
	
	public final int getY() {
		return this.yProperty.getValue();
	}
	
	public final IntegerProperty yProperty() {
		return yProperty;
	}
}
