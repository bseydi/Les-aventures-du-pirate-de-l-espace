package controleur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.lang.model.element.Element;
import applicationV1.modele.Terrain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class Controleur implements Initializable {
	Terrain terrain;
	ImageView img;

	@FXML
    private TilePane terrainJeu;
	
	public void creerTerrainJeu(int[][]carte) throws FileNotFoundException {       		
		
		terrainJeu.setOrientation(Orientation.HORIZONTAL);
		terrainJeu.setPrefColumns(10);
		
		
		for(int ligne = 0; ligne < carte.length ;ligne++) {
			for (int colonne = 0; colonne < carte[ligne].length; colonne++) {
				if (carte[ligne][colonne] == 0) {
					ciel();
				}else {
					terre();
				}					
			}
        }
    }
	
	public void ciel() throws FileNotFoundException {
    	FileInputStream input = new FileInputStream("/home/etudiants/info/bseydi/eclipse-workspace/TerrainJeu/src/image/ciel.jpg");
		img = new ImageView(new Image (input));
        terrainJeu.getChildren().add(img);
	}
	
	public void terre() throws FileNotFoundException {
        FileInputStream input2 = new FileInputStream("/home/etudiants/info/bseydi/eclipse-workspace/TerrainJeu/src/image/terre.jpg");
		img = new ImageView(new Image (input2));
        terrainJeu.getChildren().add(img);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.terrain = new Terrain (20,20);
		
		try {
		creerTerrainJeu(terrain.getCarte());
		}catch(Exception e) {
			
		}
		// TODO Auto-generated method stub		
	}	
}
