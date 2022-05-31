package applicationV1.vue;


import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class VieVue {
	
	private Pane placeCoeur;
	private int vie;
	
	public VieVue(Pane placeCoeur,int vie ) {
		this.placeCoeur = placeCoeur;
		this.vie = vie;

	} 
	
	public void afficheCoeur() throws FileNotFoundException {
		
		ImageView img = new ImageView(new Image("./image/imageCoeurs/coeur100.png"));
		
		switch(vie) {
		case 100:
			img = new ImageView(new Image("./image/imageCoeurs/coeur100.png"));
			break;
		case 90:
			img = new ImageView(new Image("./image/imageCoeurs/coeur90.png"));
			break;
		case 75:
			img = new ImageView(new Image("./image/imageCoeurs/coeur75.png"));
			break;
		case 60:
			img = new ImageView(new Image("./image/imageCoeurs/coeur60.png"));
			break;
		case 45:
			img = new ImageView(new Image("./image/imageCoeurs/coeur45.png"));
			break;
		case 30:
			img = new ImageView(new Image("./image/imageCoeurs/coeur30.png"));
			break;
		case 15:
			img = new ImageView(new Image("./image/imageCoeurs/coeur15.png"));
			break;
		case 0:
			img = new ImageView(new Image("./image/imageCoeurs/coeur0.png"));
			break;
		default:
			break;
		}
		placeCoeur.getChildren().add(img);
	
	}
	
	
	
}
