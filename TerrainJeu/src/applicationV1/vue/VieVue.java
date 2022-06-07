package vue;


import javafx.beans.property.IntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class VieVue {
	
	private Pane placeCoeur;
	private IntegerProperty vie;
	private Image[] tabImg;
	
	public VieVue(Pane placeCoeur,IntegerProperty vie ) {
		this.placeCoeur = placeCoeur;
		this.vie =  vie;
		tabImg = new Image[8];
		
		
		
		tabImg[0] = new Image("./image/imageCoeurs/coeur100.png");
		tabImg[1] = new Image("./image/imageCoeurs/coeur90.png");
		tabImg[2] = new Image("./image/imageCoeurs/coeur75.png");
		tabImg[3] = new Image("./image/imageCoeurs/coeur60.png");
		tabImg[4] = new Image("./image/imageCoeurs/coeur45.png");
		tabImg[5] = new Image("./image/imageCoeurs/coeur30.png");
		tabImg[6] = new Image("./image/imageCoeurs/coeur15.png");
		tabImg[7] = new Image("./image/imageCoeurs/coeur0.png");
		
	} 
	
	public void afficheCoeur()  {
		ImageView img = null ;
		
		if(vie.get() == 0) {
			img = new ImageView(tabImg[7]);
		}
		else if(vie.get() > 0 && vie.get() <= 15) {
			img = new ImageView(tabImg[6]);
		}
		else if (vie.get() > 15 && vie.get() <= 30) {
			img = new ImageView(tabImg[5]);
		}
		else if(vie.get() > 30 && vie.get() <= 45) {
			img = new ImageView(tabImg[4]);
		}
		else if( vie.get() > 45 && vie.get() <= 60) {
			img = new ImageView(tabImg[3]);
		}
		else if (vie.get() > 60 && vie.get() <= 75) {
			img = new ImageView(tabImg[2]);
		}
		else if(vie.get() > 75 && vie.get() <= 90) {
			img = new ImageView(tabImg[1]);

		}
		else if(vie.get() > 90 && vie.get() <=100) {
			img = new ImageView(tabImg[0]);
		}
		placeCoeur.getChildren().add(img);
		
	}
	
}	
