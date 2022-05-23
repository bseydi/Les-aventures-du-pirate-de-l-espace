package applicationV1.vue;


import java.io.FileNotFoundException;

import applicationV1.modele.Vie;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class VieVue {
	
	private Pane placeCoeur;
	private Vie vie;
	
	public VieVue(Pane placeCoeur, Vie vie) {
		this.placeCoeur = placeCoeur;
		this.vie = vie;

	} 
	
	public void afficheCoeur() throws FileNotFoundException {
		
		ImageView img = new ImageView(new Image("./image/coeur100.jpg"));
		
		switch(vie.getPv()) {
		case 100:
			img = new ImageView(new Image("./image/coeur100.jpg"));
			break;
		case 90:
			img = new ImageView(new Image("./image/coeur90.jpg"));
			break;
		case 75:
			img = new ImageView(new Image("./image/coeur75.jpg"));
			break;
		case 60:
			img = new ImageView(new Image("./image/coeur60.jpg"));
			break;
		case 45:
			img = new ImageView(new Image("./image/coeur45.jpg"));
			break;
		case 30:
			img = new ImageView(new Image("./image/coeur30.jpg"));
			break;
		case 15:
			img = new ImageView(new Image("./image/coeur15.jpg"));
			break;
		case 0:
			img = new ImageView(new Image("./image/coeur0.jpg"));
			break;
		default:
			break;
		}
		placeCoeur.getChildren().add(img);
	
	}
	
	
	
}
