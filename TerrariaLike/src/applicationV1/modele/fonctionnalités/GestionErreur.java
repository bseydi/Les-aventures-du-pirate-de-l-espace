package applicationV1.modele.fonctionnalités;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class GestionErreur {
	
	private String[] tabErreur;
	private Label textErreur;
	private Pane popUp;
	
	
	public GestionErreur( Label l, Pane t) {
		this.textErreur = l;
		this.popUp = t;
		this.tabErreur = new  String[10];
		this.tabErreur[0] = "Nombre incorrect";
		this.tabErreur[1] = "Impossible de augmenter";
		this.tabErreur[2] = "Impossible de diminuer";
		this.tabErreur[3] = "Vous n'avez pas l'outil";
		this.tabErreur[4] = "Vous n'avez pas la nourriture";
		this.tabErreur[5] = "Vous n'avez pas l'objet";
		this.tabErreur[6] = "Impossible d'avancer";
	}

	
	public void testerEreur(int nbErr) {
		String errRenv = "Erreur";

		switch(nbErr) {
		case 1 : 
			errRenv = tabErreur[0];
			break;
			
		case 2 :
			errRenv = tabErreur[1];
			break;
			
		case 3 : 
			errRenv = tabErreur[2];
			break;
			
		case 4 : 
			errRenv = tabErreur[3];
			break;
			
		case 5 : 
			errRenv = tabErreur[4];
			break;
			
		case 6 : 
			errRenv = tabErreur[5];
			break;
			
		case 7 : 
			errRenv = tabErreur[6];
			break;	
			
		default: break;
		}
				
		this.textErreur.setText(errRenv);
		this.popUp.setVisible(true);
		
	}
}
