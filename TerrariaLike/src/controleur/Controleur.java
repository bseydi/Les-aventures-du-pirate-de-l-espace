package controleur;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import applicationV1.modele.fonctionnalités.Collisions;
import applicationV1.modele.Creature1;
import applicationV1.modele.fonctionnalités.Range;
import applicationV1.modele.Personnage;
import applicationV1.modele.PnjCraft;
import applicationV1.modele.Terrain;
import applicationV1.vue.Creature1Vue;
import applicationV1.vue.InventaireVue;
import applicationV1.vue.PersonnageVue;
import applicationV1.vue.PnjCraftVue;
import applicationV1.vue.RessourcesDeBaseVue;
import applicationV1.vue.TerrainVue;
import applicationV1.vue.VieVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

public class Controleur implements Initializable {
	Terrain terrain;
	Personnage personnage;
	Creature1 creature1;

	TerrainVue terrainVue;
	PersonnageVue personnageVue;

	InventaireVue inventaireVue;
	PnjCraft pnj;
	PnjCraftVue pnjVue;
	
	Creature1Vue creature1Vue;

	Collisions c1;
	Collisions c2;

	VieVue vieVue;

	RessourcesDeBaseVue ressourcesDeBaseVue;

	private Timeline gameLoop;

	private int temps;
	private int temps2;
	private int posYInit;
	private boolean remettreDirection0 = false; // remet la direction à 0 au bout d'un certain temps.

	private int direction = 0;
	private boolean sauter = false;

	@FXML
	private ImageView fermerPopUp;
	
	@FXML
	private Pane popUpCraft;
	
	@FXML
	private TextField repMenu;
	
	@FXML
	private TilePane terrainJeu;

	@FXML
	private Pane panneauJeu;

	@FXML
	private Pane placeCoeur;

	@FXML
	private Label labelBois;

	@FXML
	private Label labelFer;

	@FXML
	private Label labelPierre;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		personnage = new Personnage(300,290,5);
		pnj = new PnjCraft(2,338);
		pnjVue = new PnjCraftVue(panneauJeu, pnj);
		this.terrain = new Terrain ();
		terrainVue = new TerrainVue(personnage, terrainJeu, terrain);
		personnageVue = new PersonnageVue(panneauJeu,personnage);
		vieVue = new VieVue(placeCoeur,personnage.getPointDeVie());
		c1 = new Collisions(personnage, terrain);
		
		ressourcesDeBaseVue = new RessourcesDeBaseVue(personnage,labelBois,labelFer,labelPierre);

		inventaireVue = new InventaireVue(panneauJeu, personnage);

		creature1 = new Creature1(400, 290, 5);
		creature1Vue = new Creature1Vue(panneauJeu, creature1 );
		c2 = new Collisions(creature1, terrain);
		initAnimation();
		gameLoop.play();
		try {
			terrainVue.creerTerrainJeu();
			vieVue.afficheCoeur();
			ressourcesDeBaseVue.afficheRessources();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		personnageVue.perso();
		pnjVue = new PnjCraftVue(panneauJeu, pnj);

		pnjVue.pnj();
		creature1Vue.creature1();
	}	

	private void initAnimation() {
		gameLoop = new Timeline();
		temps=0;
		temps2 = 0;

		posYInit=0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame (Duration.seconds(0.017),(ev ->{						
			/*if (remettreDirection0 = true) {
				temps2++;
				if (!sauter && !c1.blocDessous(personnage.getX(), personnage.getY())) {
					if (temps2%20==0) {
						direction = 0;
						temps2 = 0;
						remettreDirection0 = false;
					}
				}
			}*/	
			creature1.tomber2(c2, 0, 0);
			
			if (!sauter) {
				personnage.tomber(c1, direction, posYInit);
				direction = personnage.getDirection();
				posYInit = personnage.getPosYInit();
			}
			
			if (sauter) {				
				personnage.sauter(direction, temps);
				temps = personnage.getTemp();
			}

			if(temps%20==0) {
				temps = 0 ;
				sauter = false;
			}									
		})
				);
		gameLoop.getKeyFrames().add(kf);	
	}

	@FXML
	void toucheAppuyée(KeyEvent event) {		
		if(event.getCode()==KeyCode.D) {
			if (!c1.blocDessous(personnage.getX(), personnage.getY())) {
				if (c1.blocDroit(personnage.getX(), personnage.getY())) {
					direction = 1;				
					personnage.seDeplacerADroite();
					remettreDirection0 = true;
				}
			} 
		}
		else if(event.getCode()==KeyCode.Q) {
			if (!c1.blocDessous(personnage.getX(), personnage.getY())) {
				if (c1.blocGauche(personnage.getX(), personnage.getY())) {
					direction = 2;
					personnage.seDeplacerAGauche(); 
					remettreDirection0 = true;
				}
			} 
		}
		
		else if(event.getCode()==KeyCode.Z) {   		
			if (!c1.blocDessous(personnage.getX(), personnage.getY())) {
				sauter = true;
				posYInit = personnage.getY();
			}	
		}else if(event.getCode()==KeyCode.S) {   		
			direction = 0;			
		}else if(event.getCode()==KeyCode.W) {   		
			inventaireVue.changerItems(1);

		}else if(event.getCode()==KeyCode.X) {   		
			inventaireVue.changerItems(2);	

		}else if(event.getCode()==KeyCode.C) { 
			inventaireVue.changerItems(3);	
		}else if(event.getCode()==KeyCode.SPACE && Range.rangeToPnj(personnage,pnj)) {
			popUpCraft.setVisible(!popUpCraft.isVisible());
			
			
		}
		else if(event.getCode()==KeyCode.B) {
			popUpCraft.setVisible(true);
		}else if(event.getCode()==KeyCode.M) {
			personnage.getInventaire().ajouterOutils("Pelle");
		}
	}		
	@FXML
	void fermerPopUp () {
		popUpCraft.setVisible(false);
		panneauJeu.requestFocus();
	}
	@FXML
	void confirmer () {
		 pnj.dialogue(personnage,Integer.parseInt(repMenu.getText()));
		 fermerPopUp();
		 
	}		
}
