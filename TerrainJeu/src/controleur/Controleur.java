package controleur;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import applicationV1.modele.Terrain;
import applicationV1.vue.TerrainVue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controleur implements Initializable {
	Terrain terrain;
	ImageView img;

	@FXML
    private TilePane terrainJeu;
	
	@FXML
    private Pane panneauJeu;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.terrain = new Terrain (20,20);
		TerrainVue terrainVue = new TerrainVue(terrainJeu, terrain, panneauJeu);
		try {
			terrainVue.creerTerrainJeu();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
		@FXML
    void keyPressed(KeyEvent e) {
    	if(e.getCode()==KeyCode.D) {
    		p.seDeplacerADroite(); 
    		System.out.println("droite");
    	}
    	else if(e.getCode()==KeyCode.Q) {
    		p.seDeplacerAGauche();
    		System.out.println("gauche");
    	}
    }
}
