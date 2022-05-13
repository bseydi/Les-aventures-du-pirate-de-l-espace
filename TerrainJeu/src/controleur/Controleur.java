package controleur;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import applicationV1.modele.Terrain;
import applicationV1.vue.TerrainVue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class Controleur implements Initializable {
	Terrain terrain;
	ImageView img;

	@FXML
    private TilePane terrainJeu;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.terrain = new Terrain (20,20);
		TerrainVue terrainVue = new TerrainVue(terrainJeu, terrain);
		try {
			terrainVue.creerTerrainJeu();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}	
}
