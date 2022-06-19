package controleur;

import applicationV1.modele.Environnement;
import applicationV1.modele.fonctionnalités.Range;
import applicationV1.vue.InventaireVue;
import applicationV1.vue.PersonnageVue;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class ControleurClavier implements EventHandler <KeyEvent> {

	private Environnement env;
	private InventaireVue inventaireVue;
	private Pane popUpCraft;
	private Pane popUpFusée;
	private PersonnageVue persoVue;
	private Pane popUpFeuDeCamp;
		
	public ControleurClavier (Environnement env, InventaireVue inVue, Pane popUpCraft, Pane popUpFusée, Pane popUpFeuDeCamp, PersonnageVue persoVue) {
		this.env = env;
		this.inventaireVue = inVue;
		this.popUpCraft = popUpCraft;
		this.persoVue = persoVue;
		this.popUpFusée = popUpFusée;
	}
		
	@Override
	public void handle(KeyEvent event) {
		if(event.getCode()==KeyCode.D) {
			if (!this.env.getC1().blocDessous(this.env.getPersonnage().getX(), this.env.getPersonnage().getY())) {
				if (this.env.getC1().blocDroit(this.env.getPersonnage().getX(), this.env.getPersonnage().getY())) {
					this.env.getPersonnage().setDirection(1);				
					this.env.getPersonnage().seDeplacerADroite();
					this.persoVue.animationPerso();
					this.env.getPersonnage().setRemettreDirection0(true);
					this.env.getPersonnage().setPosX(this.env.getPersonnage().getX());
				}
			} 
		}
		else if(event.getCode()==KeyCode.Q) {
			if (!this.env.getC1().blocDessous(this.env.getPersonnage().getX(), this.env.getPersonnage().getY())) {
				if (this.env.getC1().blocGauche(this.env.getPersonnage().getX(), this.env.getPersonnage().getY())) {
					this.env.getPersonnage().setDirection(2);
					this.env.getPersonnage().seDeplacerAGauche(); 
					this.persoVue.animationPerso();
					//this.env.getPersonnage().setRemettreDirection0(true);
				}
			} 
		}
		
		else if(event.getCode()==KeyCode.Z) {   		
			if (!this.env.getC1().blocDessous(this.env.getPersonnage().getX(), this.env.getPersonnage().getY())) {
				this.env.getPersonnage().setSauter(true);
				this.env.getPersonnage().setPosYInit(this.env.getPersonnage().getY());
			}	
		}
		else if(event.getCode()==KeyCode.S) {   		
			this.env.getPersonnage().setDirection(0);			
		}
		else if(event.getCode()==KeyCode.W) {   		
			inventaireVue.changerItems(1);
		}
		else if(event.getCode()==KeyCode.X) {   		
			inventaireVue.changerItems(2);	
		}
		else if(event.getCode()==KeyCode.C) { 
			inventaireVue.changerItems(3);	
		}
		else if(event.getCode()==KeyCode.SPACE && Range.rangeTo(this.env.getPersonnage().getX(), this.env.getPersonnage().getY(),this.env.getPnj().getX(),this.env.getPnj().getY())) {
			if (Range.rangeTo(this.env.getPersonnage().getX(), this.env.getPersonnage().getY(),this.env.getPnj().getX(),this.env.getPnj().getY())) {
				popUpCraft.setVisible(!popUpCraft.isVisible());
				popUpFusée.setVisible(!popUpFusée.isVisible());
			} else if  (Range.rangeTo(this.env.getPersonnage().getX(), this.env.getPersonnage().getY(), this.env.getFeuDeCamp().getX(),this.env.getFeuDeCamp().getY() )) {
				popUpFeuDeCamp.setVisible(!popUpCraft.isVisible());

			}else if(event.getCode()==KeyCode.L) {
				this.env.getPersonnage().getInventaire().ajouterNourriture(1);
			}
		}
		else if (event.getCode()==KeyCode.E) {
			this.env.getPersonnage().manger();
		}
		
	}	
}
