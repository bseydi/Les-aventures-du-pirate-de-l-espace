package applicationV1.vue;

import java.util.Random;

import applicationV1.modele.nourriture.Nourriture;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PommeDeTerreVue {

	private Pane panneauJeu;
	ImageView img=new ImageView();
	private int xMin,xMax,yMin,yMax;
	private int nbX,nbY;
	
	public PommeDeTerreVue(Pane panneauJeu,Nourriture nourriture) {
		this.panneauJeu=panneauJeu;
		this.img=new ImageView(new Image("./image/PommeDeTerre2.png"));
		panneauJeu.getChildren().add(img);
		this.xMin=0;
		this.xMax=800;
		this.yMin=400;
		this.yMax=600;
		Random randomX = new Random();
		Random randomY = new Random();
		nbX=xMin+randomX.nextInt(xMax-xMin);
		nbY=yMin+randomY.nextInt(yMax-yMin);
		img.setTranslateX(nbX);
    	img.setTranslateY(nbY);
	}
}
