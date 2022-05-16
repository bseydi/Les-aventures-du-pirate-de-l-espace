package controleur;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import applicationV1.modele.Personnage;
import applicationV1.modele.Terrain;
import applicationV1.vue.PersonnageVue;
import applicationV1.vue.TerrainVue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controleur implements Initializable {
	Terrain terrain;
	Personnage personnage;
	
	TerrainVue terrainVue;
	PersonnageVue personnageVue;
	
	@FXML
    private TilePane terrainJeu;
	
	@FXML
    private Pane panneauJeu;
	
	@FXML
    void toucheAppuyée(KeyEvent event) {
		if(event.getCode()==KeyCode.D) {
    		personnage.seDeplacerADroite(); 
    	}
    	else if(event.getCode()==KeyCode.Q) {
    		personnage.seDeplacerAGauche();   		
    	}
    }
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.terrain = new Terrain (20,20);
		terrainVue = new TerrainVue(terrainJeu, terrain);
		personnage = new Personnage(100,172,5);
		personnageVue = new PersonnageVue(panneauJeu);
		try {
			terrainVue.creerTerrainJeu();
			personnageVue.perso(personnage);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}		
}
