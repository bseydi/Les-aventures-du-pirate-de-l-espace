package applicationV1.modele;

import applicationV1.modele.fonctionnalités.GestionErreur;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personnage extends Acteur{
	private int blocEnMains = 1; //Sa valeur correspond à l'objet en mains.
	private int objetEnMains = 6; //Sa valeur correspond à l'outil en mains.   
	private IntegerProperty pointDeNourritureProperty;
	private Ressources ressource;
	private Inventaire inventaire;
	private int i;
	private int degatSubi = 0;
	private int idNourriture = 4;
	private int posX;

	
	
	public Personnage(int x, int y, int v, GestionErreur gn){
		super(x,y,v, gn);
		this.ressource = new Ressources ();
		this.inventaire = new Inventaire();
		this.pointDeNourritureProperty=new SimpleIntegerProperty(100);
		this.i = this.inventaire.getListeNourriture().size() - 1;
		
	}	
	
	public Ressources getRessource() {
		return ressource;
	}
	
	public Inventaire getInventaire() {
		return inventaire;
	}

	public int changerItemsEnMain(int typeItem) {		
		int itemEnMain = 0;
		if (typeItem == 1) {
			if(this.i >=5) {
				i = 0;
			}
			this.idNourriture = this.inventaire.getListeNourriture().get(i).getId();
			itemEnMain = this.idNourriture;
			this.i++;

		}
		else if (typeItem == 2) {
			if(blocEnMains > 3) {
				blocEnMains=1;
			}		
			itemEnMain = blocEnMains;
			blocEnMains++;
		}
		else {
			objetEnMains++;
			if(objetEnMains > 6) {
				objetEnMains=1;
			}		
			itemEnMain = objetEnMains;
		}		
		return itemEnMain;
	}
	
	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public void gagneVie() {
		if(getPointDeNourriture() > 0) {
			if(getPointDeVie() + 5 > 100 ) {
				if(getPointDeVie() == 100) {
					super.getGn().testerEreur(2);
				}
				else {
				setPointDeVie(100);
				}
			}
			else {
				setPointDeVie(getPointDeVie() + 5);
			}
			
		}
		else {
			perdVie();
		}
	}
	
	public void perdVie() {
		if(getPointDeNourriture() == 0) {
			if(degatSubi > 0) {
				if(getPointDeVie() - degatSubi == 0) {
					setPointDeVie(0);
				}
				else {
					setPointDeVie(getPointDeVie() - (degatSubi + 5));
				}
			}
			else {
				setPointDeVie(getPointDeVie() - 10);
			}
		}
		else {
			if(degatSubi > 0) {
				if(getPointDeVie() - degatSubi == 0) {
					setPointDeVie(0);
				}
				else {
					setPointDeVie(getPointDeVie() - (degatSubi));
				}
			}
			else {
				setPointDeVie(getPointDeVie() - 10);
			}
		}
	}
	
	public final IntegerProperty pointdeNourritureProperty() {
		return this.pointDeNourritureProperty;
	}

	public void setPointDeNourriture(int n) {
		pointDeNourritureProperty.setValue(n);
	}
	
	public final int getPointDeNourriture() {
		return this.pointDeNourritureProperty.getValue();
	}
	
	public void perdNourriture(int pvPerdu) {
		if(getPointDeNourriture() - pvPerdu < 0) {
			setPointDeNourriture(0);
		}
		else {
			setPointDeNourriture(getPointDeNourriture() - pvPerdu);
		}
	}
	
	// methode pour manger en fonction de la nourriture en main
	public void manger() {
		i = 0;
		while(this.inventaire.getListeNourriture().get(i).getId() != idNourriture) {
			i++;
		}
			if(this.inventaire.getListeNourriture().get(i).getQuantiteProperty() > 0) {
				if((getPointDeNourriture() + this.inventaire.getListeNourriture().get(i).getDonnerPV()) >= 100) {
					setPointDeNourriture(100);
				}
				else {
					setPointDeNourriture(getPointDeNourriture() + this.inventaire.getListeNourriture().get(i).getDonnerPV());
					this.inventaire.retirerNourriture(this.inventaire.getListeNourriture().get(i).getId());

				}
			}
			else {
				super.getGn().testerEreur(5);
			}
		}

	public int getIdNOurriture() {
		return this.idNourriture;
	}		
	
	public int getBlocEnMains() {
		return blocEnMains;
	}	

	public int getObjetEnMains() {
		return objetEnMains;
	}	
}
