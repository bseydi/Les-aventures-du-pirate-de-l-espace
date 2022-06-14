package applicationV1.vue;

<<<<<<< HEAD
import applicationV1.modele.Personnage;
import applicationV1.modele.nourriture.Nourriture;
import applicationV1.modele.nourriture.PommeDeTerre;
=======
import java.util.Random;

import applicationV1.modele.nourriture.Nourriture;
>>>>>>> branch 'develop' of https://github.com/bseydi/Les-aventures-du-pirate-de-l-espace.git
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PommeDeTerreVue {

<<<<<<< HEAD
	private Nourriture pommeDeTerre;
	private Nourriture pommeDeTerre2;
=======
>>>>>>> branch 'develop' of https://github.com/bseydi/Les-aventures-du-pirate-de-l-espace.git
	private Pane panneauJeu;
	private ImageView img=new ImageView();
	private Personnage p;

	
<<<<<<< HEAD
	
	public PommeDeTerreVue(Pane panneauJeu,Nourriture pommeDeTerre,Personnage p) {
=======
	public PommeDeTerreVue(Pane panneauJeu,Nourriture nourriture) {
>>>>>>> branch 'develop' of https://github.com/bseydi/Les-aventures-du-pirate-de-l-espace.git
		this.panneauJeu=panneauJeu;
<<<<<<< HEAD
		this.pommeDeTerre=pommeDeTerre;
		this.p=p;
=======
>>>>>>> branch 'develop' of https://github.com/bseydi/Les-aventures-du-pirate-de-l-espace.git
		this.img=new ImageView(new Image("./image/PommeDeTerre2.png"));
		panneauJeu.getChildren().add(img);
<<<<<<< HEAD
		img.setTranslateX(pommeDeTerre.getX());
    	img.setTranslateY(pommeDeTerre.getY());	
=======
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
>>>>>>> branch 'develop' of https://github.com/bseydi/Les-aventures-du-pirate-de-l-espace.git
	}
	
	public ImageView img() {
		return img;
	}
		
	public void afficherPommeDeTerre() {
		this.pommeDeTerre2=new PommeDeTerre();
		this.img=new ImageView(new Image("./image/PommeDeTerre2.png"));
		img.setTranslateX(pommeDeTerre2.getX());
    	img.setTranslateY(pommeDeTerre2.getY());
    	panneauJeu.getChildren().add(img);
    }
	
	public Nourriture getPommeDeTerre2() {
		return pommeDeTerre2;
	}

	public int coordonneeImgX() {
		return (int)img.getLayoutX();
	}
	
	public int coordonneeImgY() {
		return (int)img.getLayoutY();
	}

	
	
}