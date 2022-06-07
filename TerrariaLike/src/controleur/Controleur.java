package controleur;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import applicationV1.modele.fonctionnalités.Collisions;
import applicationV1.modele.Personnage;
import applicationV1.modele.PnjCraft;
import applicationV1.modele.Terrain;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

public class Controleur implements Initializable {
	Terrain terrain;
	Personnage personnage;

	TerrainVue terrainVue;
	PersonnageVue personnageVue;

	InventaireVue inventaireVue;
	PnjCraft pnj;
	PnjCraftVue pnjVue;

	Collisions c1;

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
		vieVue = new VieVue(placeCoeur,personnage.pointdeVieProperty());
		c1 = new Collisions(personnage, terrain);
		ressourcesDeBaseVue = new RessourcesDeBaseVue(personnage,labelBois,labelFer,labelPierre);
		personnage.pointdeVieProperty().addListener((o, oldVal, newVal) -> { vieVue.afficheCoeur();});
		inventaireVue = new InventaireVue(panneauJeu, personnage);

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
			if (!sauter) {
				if (c1.blocDessous(personnage.getX(), personnage.getY())) {			
					if(direction == 1) {
						personnage.setY(personnage.getY()+2);
						personnage.setX(personnage.getX()+2);
						if (personnage.getY() == posYInit-2) {
							direction = 0;
						}
					} else if (direction == 2) {
						personnage.setY(personnage.getY()+2);
						personnage.setX(personnage.getX()-2);
						if (personnage.getY() == posYInit-2) {
							direction = 0;
						}
					}else {
						personnage.setY(personnage.getY()+2);
					}				
				}
			}			
			if (sauter) {				
				if(direction == 1) {
					personnage.setY(personnage.getY()-2);
					personnage.setX(personnage.getX()+1);
				} else if (direction == 2) {
					personnage.setY(personnage.getY()-2);
					personnage.setX(personnage.getX()-1);
				}else {
					personnage.setY(personnage.getY()-2);
				}
				temps++;
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
		}else if(event.getCode()==KeyCode.V) {
			popUpCraft.setVisible(false);
		}
		else if(event.getCode()==KeyCode.B) {
			popUpCraft.setVisible(true);
		}else if(event.getCode()==KeyCode.A) {
			personnage.perdVie();
			System.out.println(personnage.getPointDeVie());
    		} else if(event.getCode()==KeyCode.E) {
			personnage.gagneVie();
			System.out.println(personnage.getPointDeVie());
    	}
	}		
	
	@FXML
	void confirmer () {
		 pnj.dialogue(personnage,Integer.parseInt(repMenu.getText()));
	}		
}
