package controleur;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import applicationV1.modele.Personnage;
import applicationV1.modele.Terrain;
import applicationV1.modele.Vie;
import applicationV1.vue.PersonnageVue;
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
	Vie tabCoeur;
	TerrainVue terrainVue;
	PersonnageVue personnageVue;
	VieVue vieVue;
	private Timeline gameLoop;
	private int temps;
	
	@FXML
    private TilePane terrainJeu;
	
	@FXML
    private Pane panneauJeu;
	
	@FXML
	private TilePane placeCoeur;
	
	
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initAnimation();
		gameLoop.play();
		
		this.terrain = new Terrain (20,20);
		terrainVue = new TerrainVue(terrainJeu, terrain);
		personnage = new Personnage(100,172,5);
		personnageVue = new PersonnageVue(panneauJeu);
		tabCoeur = new Vie(personnage);
		vieVue = new VieVue(placeCoeur,tabCoeur);
		try {
			terrainVue.creerTerrainJeu();
			personnageVue.perso(personnage);
			vieVue.afficheCoeur();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}	
	
	@FXML
    void toucheAppuyée(KeyEvent event) {
		if(event.getCode()==KeyCode.D) {
    		personnage.seDeplacerADroite(); 
    	} else if(event.getCode()==KeyCode.Q) {
    		personnage.seDeplacerAGauche();   		
    	} else if(event.getCode()==KeyCode.Z) {
    		 personnage.sauter();  		
    	}
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
	
	

