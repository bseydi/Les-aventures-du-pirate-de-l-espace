package controleur;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import applicationV1.modele.Personnage;
import applicationV1.modele.Ressources;
import applicationV1.modele.RessourcesDeBase;
import applicationV1.modele.Terrain;
import applicationV1.vue.PersonnageVue;
import applicationV1.vue.RessourcesDeBaseVue;
import applicationV1.vue.TerrainVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

public class Controleur implements Initializable {
	Terrain terrain;
	Personnage personnage;
	TerrainVue terrainVue;
	PersonnageVue personnageVue;
	RessourcesDeBase ressourcesBase;
	RessourcesDeBaseVue ressourcesDeBaseVue;
	Ressources r;
	private Timeline gameLoop;
	private int temps;
	
	@FXML
    private TilePane terrainJeu;
	
	@FXML
    private Pane panneauJeu;
	
   @FXML
    private TilePane placeRessources;
	
	@FXML
    void toucheAppuyée(KeyEvent event) {
		if(event.getCode()==KeyCode.D) {
    		personnage.seDeplacerADroite(); 
    	}
    	else if(event.getCode()==KeyCode.Q) {
    		personnage.seDeplacerAGauche();   		
    	}
    	else if(event.getCode()==KeyCode.Z) {
    		 personnage.sauter();  		
    	}
    }
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initAnimation();
		gameLoop.play();
		
		
		
		this.terrain = new Terrain ();
		terrainVue = new TerrainVue(terrainJeu, terrain);
		personnage = new Personnage(100,172,5);
		personnageVue = new PersonnageVue(panneauJeu);
		ressourcesBase = new RessourcesDeBase();
		ressourcesDeBaseVue = new RessourcesDeBaseVue(placeRessources,ressourcesBase.getRessourcesBase());
		try {
			terrainVue.creerTerrainJeu();
			ressourcesDeBaseVue.afficheRessources();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		personnageVue.perso(personnage);
		
	}		
	
	private void initAnimation() {
		gameLoop = new Timeline();
		temps=0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame (Duration.seconds(1),(ev ->{
			
				personnage.setY(172);			
				temps++;
			})
			);
			gameLoop.getKeyFrames().add(kf);
		}

}