package applicationV1.vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import applicationV1.modele.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class TerrainVue {
	
	private TilePane terrainJeu;
	private Terrain terrain;
	
	public TerrainVue(TilePane terrainJeu, Terrain terrain) {
		super();
		this.terrainJeu = terrainJeu;
		this.terrain = terrain;
	}

	public void creerTerrainJeu() throws FileNotFoundException  {       		    
		int[][] carte = terrain.getCarte();
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
		ImageView img = new ImageView(new Image (input));
        terrainJeu.getChildren().add(img);
	}
	
	public void terre() throws FileNotFoundException {
        FileInputStream input2 = new FileInputStream("/home/etudiants/info/bseydi/eclipse-workspace/TerrainJeu/src/image/terre.jpg");
        ImageView img = new ImageView(new Image (input2));
        terrainJeu.getChildren().add(img);
	}

}
