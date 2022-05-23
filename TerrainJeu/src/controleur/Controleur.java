package controleur;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import applicationV1.modele.principal.Personnage;
import applicationV1.modele.principal.Terrain;
import applicationV1.modele.ressourcesDeBase.Bois;
import applicationV1.modele.ressourcesDeBase.Fer;
import applicationV1.vue.PersonnageVue;
import applicationV1.vue.RessourceVue;
import applicationV1.vue.TerrainVue;
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
	
	TerrainVue terrainVue;
	PersonnageVue personnageVue;
	
	private Timeline gameLoop;

	private int temps;
	
	int direction = 0;
	
	@FXML
    private TilePane terrainJeu;
	
	@FXML
    private Pane panneauJeu;
			
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initAnimation();
		gameLoop.play();
		
		this.terrain = new Terrain ();
		terrainVue = new TerrainVue(terrainJeu, terrain);
		personnage = new Personnage(300,290,5);
		personnageVue = new PersonnageVue(panneauJeu,personnage);
		
		try {
			terrainVue.creerTerrainJeu();
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
					
			
						
			temps++;
			})
			);
		gameLoop.getKeyFrames().add(kf);	
	}
	
	@FXML
    void toucheAppuyée(KeyEvent event) {		
		if(event.getCode()==KeyCode.D) {	
    		direction = 1;
			personnage.seDeplacerADroite();
    	} 
		else if(event.getCode()==KeyCode.Q) {
    		direction = 2;
			personnage.seDeplacerAGauche(); 
    	} 
		else if(event.getCode()==KeyCode.Z) {   		
			if (direction == 1) {
				personnage.setY(personnage.getY() - 100);	
				personnage.setX(personnage.getX() + 100);
			} else if (direction == 2) {
				personnage.setY(personnage.getY() - 100);	
				personnage.setX(personnage.getX() - 100);
			} else {
				personnage.setY(personnage.getY() - 100);	
			}
				
		}
	}
	
	
		
		
			
}

	
	

