package controleur;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import applicationV1.modele.Personnage;
import applicationV1.modele.RessourcesDeBase;
import applicationV1.modele.fonctionnalités.Collisions;
import applicationV1.modele.Terrain;
import applicationV1.modele.Vie;
import applicationV1.vue.PersonnageVue;
import applicationV1.vue.RessourcesDeBaseVue;
import applicationV1.vue.TerrainVue;
import applicationV1.vue.VieVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

public class Controleur implements Initializable {
	Terrain terrain;
	Personnage personnage;
	Collisions c1;
	TerrainVue terrainVue;
	PersonnageVue personnageVue;
	Vie vie;
	VieVue vieVue;
	RessourcesDeBase listRessources;
	RessourcesDeBaseVue ressourcesDeBaseVue;
	
	private Timeline gameLoop;

	private int temps;
	
	int direction = 0;
	
	@FXML
    private TilePane terrainJeu;
	
	@FXML
    private Pane panneauJeu;
	
	@FXML
    private Pane placeCoeur;

	@FXML
    private TilePane placeRessources;
   
   @FXML
   private Label labelBois;

   @FXML
   private Label labelFer;

   @FXML
   private Label labelPierre;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.terrain = new Terrain ();
		terrainVue = new TerrainVue(terrainJeu, terrain);
		personnage = new Personnage(300,290,5);
		personnageVue = new PersonnageVue(panneauJeu,personnage);
		vie = new Vie(personnage.pointdeVieProperty());
		vieVue = new VieVue(placeCoeur, vie);
		c1 = new Collisions(personnage, terrain);
		listRessources = new RessourcesDeBase();
		ressourcesDeBaseVue = new RessourcesDeBaseVue(placeRessources,labelBois,labelFer,labelPierre,listRessources.getRessourcesBase());
		
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
		
	}	
	
	private void initAnimation() {
		gameLoop = new Timeline();
		temps=0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame (Duration.seconds(0.017 ),(ev ->{	
					
			if ( c1.blocDessous(personnage.getX(), personnage.getY())) {
					personnage.setY(personnage.getY()+1);
			}
						
			temps++;
			})
			);
		gameLoop.getKeyFrames().add(kf);	
	}
	
	@FXML
    void toucheAppuyée(KeyEvent event) {		
		if(event.getCode()==KeyCode.D) {
			if ( c1.blocDroit(personnage.getX(),personnage.getY())) {
				direction = 1;
				personnage.seDeplacerADroite();
			}
    	} 
		else if(event.getCode()==KeyCode.Q) {
			if ( c1.blocGauche(personnage.getX(),personnage.getY())) {
				direction = 2;
				personnage.seDeplacerAGauche(); 
			}
    	} 
		else if(event.getCode()==KeyCode.Z) {   		
			if (direction == 1) {
				personnage.setY(personnage.getY() - 50);	
				personnage.setX(personnage.getX() + 50);
			} else if (direction == 2) {
				personnage.setY(personnage.getY() - 50);	
				personnage.setX(personnage.getX() - 50);
			} else {
				personnage.setY(personnage.getY() - 50);	
			}
				
		}
	}			
}
