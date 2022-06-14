package controleur;

import applicationV1.modele.Environnement;
import applicationV1.modele.fonctionnalités.Range;
import applicationV1.vue.InventaireVue;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class ControleurClavier implements EventHandler <KeyEvent> {

	private Environnement env;
	private InventaireVue inventaireVue;
	private Pane popUpCraft;
		
	public ControleurClavier (Environnement env, InventaireVue inVue, Pane popUpCraft) {
		this.env = env;
		this.inventaireVue = inVue;
		this.popUpCraft = popUpCraft;
	}	
		
	@Override
	public void handle(KeyEvent event) {
		if(event.getCode()==KeyCode.D) {
			if (!this.env.getC1().blocDessous(this.env.getPersonnage().getX(), this.env.getPersonnage().getY())) {
				if (this.env.getC1().blocDroit(this.env.getPersonnage().getX(), this.env.getPersonnage().getY())) {
					this.env.getPersonnage().setDirection(1);				
					this.env.getPersonnage().seDeplacerADroite();
					this.env.getPersonnage().setRemettreDirection0(true);
				}
			} 
		}
		else if(event.getCode()==KeyCode.Q) {
			if (!this.env.getC1().blocDessous(this.env.getPersonnage().getX(), this.env.getPersonnage().getY())) {
				if (this.env.getC1().blocGauche(this.env.getPersonnage().getX(), this.env.getPersonnage().getY())) {
					this.env.getPersonnage().setDirection(2);
					this.env.getPersonnage().seDeplacerAGauche(); 
					this.env.getPersonnage().setRemettreDirection0(true);
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
		else if(event.getCode()==KeyCode.SPACE && Range.rangeToPnj(this.env.getPersonnage(),this.env.getPnj())) {
			popUpCraft.setVisible(!popUpCraft.isVisible());
		}
		else if(event.getCode()==KeyCode.B) {
			popUpCraft.setVisible(true);
		}	
		else if(event.getCode()==KeyCode.L) {
		/*System.out.println(this.env.getFraise().getQuantiteProperty());
		if(arbrevue1.changerArbre() && this.env.getArbre1().getArbreProperty().intValue()==1) {
			this.env.getArbre1().changerArbre();
    		arbrevue1.afficherArbre();
   			this.env.getFraise().setQuantiteProperty(this.env.getFraise().getQuantiteProperty().intValue()+1);
   		}else if(arbrevue2.changerArbre() && this.env.getArbre2().getArbreProperty().intValue()==1) {
			this.env.getArbre2().changerArbre();
			arbrevue2.afficherArbre();
   			this.env.getFraise().setQuantiteProperty(this.env.getFraise().getQuantiteProperty().intValue()+1); 			
		}else if(arbrevue3.changerArbre() && this.env.getArbre3().getArbreProperty().intValue()==1) {
			this.env.getArbre3().changerArbre();
			arbrevue3.afficherArbre();
			this.env.getFraise().setQuantiteProperty(this.env.getFraise().getQuantiteProperty().intValue()+1);
   		}
		System.out.println(this.env.getFraise().getQuantiteProperty());*/
			this.env.getCreature1().attaquer(this.env.getPersonnage());;
		}
		else if (event.getCode()==KeyCode.A) {
			this.env.getPersonnage().perdNourriture();
		}
		else if (event.getCode()==KeyCode.E) {
			this.env.getPersonnage().manger();
		}
	}	
}
