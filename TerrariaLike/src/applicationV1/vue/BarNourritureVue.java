package applicationV1.vue;

import javafx.beans.property.IntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class BarNourritureVue {

	private Pane placeBar;
	private IntegerProperty nbNourriture;
	private Image[] tabImg;
	private ImageView img;
	
	public BarNourritureVue (Pane placeBar, IntegerProperty nbNourriture) {
		
		this.nbNourriture = nbNourriture;
		this.placeBar = placeBar;
		this.img = new ImageView();
		this.tabImg = new Image[11];
		
		this.tabImg[0] = new Image("./image/imageBarNourriture/nourritureBar100.png");
		this.tabImg[1] = new Image("./image/imageBarNourriture/nourritureBar90.png");
		this.tabImg[2] = new Image("./image/imageBarNourriture/nourritureBar80.png");
		this.tabImg[3] = new Image("./image/imageBarNourriture/nourritureBar70.png");
		this.tabImg[4] = new Image("./image/imageBarNourriture/nourritureBar60.png");
		this.tabImg[5] = new Image("./image/imageBarNourriture/nourritureBar50.png");
		this.tabImg[6] = new Image("./image/imageBarNourriture/nourritureBar40.png");
		this.tabImg[7] = new Image("./image/imageBarNourriture/nourritureBar30.png");
		this.tabImg[8] = new Image("./image/imageBarNourriture/nourritureBar20.png");
		this.tabImg[9]= new Image("./image/imageBarNourriture/nourritureBar10.png");
		this.tabImg[10]= new Image("./image/imageBarNourriture/nourritureBar0.png");
		
		this.placeBar.getChildren().add(this.img);

	}
	
	public void afficheNourritureBar() {
		
		if(this.nbNourriture.get() == 0) {
			this.img.setImage(this.tabImg[10]);
		}
		else if(this.nbNourriture.get() > 0 && this.nbNourriture.get() <= 10) {
			this.img.setImage(this.tabImg[9]);
		}
		else if (this.nbNourriture.get() > 10 && this.nbNourriture.get() <= 20) {
			this.img.setImage(this.tabImg[8]);
		}
		else if(this.nbNourriture.get() > 20 && this.nbNourriture.get() <= 30) {
			this.img.setImage(this.tabImg[7]);
		}
		else if( this.nbNourriture.get() > 30 && this.nbNourriture.get() <= 40) {
			this.img.setImage(this.tabImg[6]);
		}
		else if (this.nbNourriture.get() > 40 && this.nbNourriture.get() <= 50) {
			this.img.setImage(this.tabImg[5]);
		}
		else if(this.nbNourriture.get() > 50 && this.nbNourriture.get() <= 60) {
			this.img.setImage(this.tabImg[4]);
		}
		else if(this.nbNourriture.get() > 60 && this.nbNourriture.get() <=70) {
			this.img.setImage(this.tabImg[3]);
		}
		else if(this.nbNourriture.get() > 70 && this.nbNourriture.get() <=80) {
			this.img.setImage(this.tabImg[2]);
		}
		else if(this.nbNourriture.get() > 80 && this.nbNourriture.get() <=90) {
			this.img.setImage(this.tabImg[1]);
		}
		else if(this.nbNourriture.get() > 90 && this.nbNourriture.get() <=100) {
			this.img.setImage(this.tabImg[0]);
		}
	}
}


