package applicationV1.vue;

import java.util.Random;

import applicationV1.modele.nourriture.PommeDeTerre;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PommeDeTerreVue {

	private PommeDeTerre pommeDeTerre;
	private Pane panneauJeu;
	ImageView img=new ImageView();
	private int xMin,xMax,yMin,yMax;
	private int nbX,nbY;
	
	public PommeDeTerreVue(Pane panneauJeu,PommeDeTerre pommeDeTerre) {
		this.panneauJeu=panneauJeu;
		this.pommeDeTerre=pommeDeTerre;
		this.img=new ImageView(new Image("./image/PommeDeTerre.png"));
		panneauJeu.getChildren().add(img);
		this.xMin=0;
		this.xMax=500;
		this.yMin=400;
		this.yMax=850;
		Random randomX = new Random();
		Random randomY = new Random();
		nbX=xMin+randomX.nextInt(xMax-xMin);
		nbY=yMin+randomY.nextInt(yMax-yMin);
		System.out.println(nbX);
		System.out.println(nbY);
		img.setTranslateX(nbX);
    	img.setTranslateY(nbY);
	}
}
