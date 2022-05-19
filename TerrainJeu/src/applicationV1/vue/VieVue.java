package applicationV1.vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import applicationV1.modele.Vie;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class VieVue {
	
	private TilePane placeCoeur;
	private Vie tabCoeur;
	
	public VieVue(TilePane placeCoeur, Vie tabCoeur) {
		super();
		this.placeCoeur = placeCoeur;
		this.tabCoeur = tabCoeur;

	} 
	
	public void afficheCoeur() throws FileNotFoundException {
		
		int[] carte = tabCoeur.getTabCoeur();
		for(int ligne = 0; ligne < carte.length ;ligne++) {
				switch(carte[ligne]) {
				case 10:
					coeur();
					break;
				case 0:
					coeurVide();
					break;
					
				}
			}
	}
	
	
	public void coeur () throws FileNotFoundException {
		FileInputStream input = new FileInputStream("/home/etudiants/info/wvincent/prive/S2/DOO/TerrainJeu/src/image/coeur.png");
		ImageView img = new ImageView(new Image (input));
        placeCoeur.getChildren().add(img);
		
	}
	
	public void miCoeur () throws FileNotFoundException {
		FileInputStream input = new FileInputStream("/home/etudiants/info/wvincent/prive/S2/DOO/TerrainJeu/src/image/coeur.png");
		ImageView img = new ImageView(new Image (input));
        placeCoeur.getChildren().add(img);
		
	}
	
	public void coeurVide () throws FileNotFoundException {
		FileInputStream input = new FileInputStream("/home/etudiants/info/wvincent/prive/S2/DOO/TerrainJeu/src/image/coeurVide.png");
		ImageView img = new ImageView(new Image (input));
        placeCoeur.getChildren().add(img);
		
	}
}
