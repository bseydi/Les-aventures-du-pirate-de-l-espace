package applicationV1.vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import applicationV1.modele.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TerrainVue {
	
	private Pane panneauJeu;
	private TilePane terrainJeu;
	private Terrain terrain;
	
	public TerrainVue(TilePane terrainJeu, Terrain terrain, Pane panneauJeu) {
		super();
		this.terrainJeu = terrainJeu;
		this.terrain = terrain;
		this.panneauJeu = panneauJeu;
	}
	public void creerTerrainJeu() throws FileNotFoundException  {       		    
		int[][] carte = terrain.getCarte();
		for(int ligne = 0; ligne < carte.length ;ligne++) {
			for (int colonne = 0; colonne < carte[ligne].length; colonne++) {
				if (carte[ligne][colonne] == 0) {
					ciel();				
				}else if (carte[ligne][colonne] == 1){
					terre();
				} else {
					herbe();
				}					
			}
        }
		personnage();
    }	
	
	public void personnage() {
		Circle r;
		r = new Circle(5);
		r.setFill(Color.RED);
		r.setTranslateX(200);
   	 	r.setTranslateY(172);
   	 	panneauJeu.getChildren().add(r);
		
	}
	
	public void ciel() throws FileNotFoundException {
    	FileInputStream input = new FileInputStream("/home/etudiants/info/bseydi/eclipse-workspace/TerrainJeu/src/image/ciel.jpg");
		ImageView img = new ImageView(new Image (input));
        terrainJeu.getChildren().add(img);
	}
	
	public void terre() throws FileNotFoundException {
        FileInputStream input = new FileInputStream("/home/etudiants/info/bseydi/eclipse-workspace/TerrainJeu/src/image/terre.jpg");
        ImageView img = new ImageView(new Image (input));
        terrainJeu.getChildren().add(img);
	}
	
	public void herbe() throws FileNotFoundException {
        FileInputStream input = new FileInputStream("/home/etudiants/info/bseydi/eclipse-workspace/TerrainJeu/src/image/herbe.jpg");
        ImageView img = new ImageView(new Image (input));
        terrainJeu.getChildren().add(img);
	}

}
