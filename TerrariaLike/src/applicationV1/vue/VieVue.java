package applicationV1.vue;

import javafx.beans.property.IntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class VieVue {
	
	private Pane placeCoeur;
	private IntegerProperty vie;
	private Image[] tabImg;
	private ImageView img;
	
	public VieVue(Pane placeCoeur,IntegerProperty vie ) {
		this.placeCoeur = placeCoeur;
		this.vie =  vie;
		this.img = new ImageView();
		this.tabImg = new Image[8];
		
		this.tabImg[0] = new Image("./image/imageCoeurs/coeur100.png");
		this.tabImg[1] = new Image("./image/imageCoeurs/coeur90.png");
		this.tabImg[2] = new Image("./image/imageCoeurs/coeur75.png");
		this.tabImg[3] = new Image("./image/imageCoeurs/coeur60.png");
		this.tabImg[4] = new Image("./image/imageCoeurs/coeur45.png");
		this.tabImg[5] = new Image("./image/imageCoeurs/coeur30.png");
		this.tabImg[6] = new Image("./image/imageCoeurs/coeur15.png");
		this.tabImg[7] = new Image("./image/imageCoeurs/coeur0.png");
		
		this.placeCoeur.getChildren().add(this.img);

	} 
	
	//change l'imageView en fonction de la vie du personnage
	public void afficheCoeur()  {
		
		if(this.vie.get() == 0) {
			this.img.setImage(this.tabImg[7]);
		}
		else if(this.vie.get() > 0 && this.vie.get() <= 15) {
			this.img.setImage(this.tabImg[6]);
		}
		else if (this.vie.get() > 15 && this.vie.get() <= 30) {
			this.img.setImage(this.tabImg[5]);
		}
		else if(this.vie.get() > 30 && this.vie.get() <= 45) {
			this.img.setImage(this.tabImg[4]);
		}
		else if( this.vie.get() > 45 && this.vie.get() <= 60) {
			this.img.setImage(this.tabImg[3]);
		}
		else if (this.vie.get() > 60 && this.vie.get() <= 75) {
			this.img.setImage(this.tabImg[2]);
		}
		else if(this.vie.get() > 75 && this.vie.get() <= 90) {
			this.img.setImage(this.tabImg[1]);
		}
		else if(this.vie.get() > 90 && this.vie.get() <=100) {
			this.img.setImage(this.tabImg[0]);
		}
		
	}
	
}
