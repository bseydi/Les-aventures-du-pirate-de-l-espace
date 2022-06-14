package applicationV1.vue;

import applicationV1.modele.Personnage;
import applicationV1.modele.nourriture.Nourriture;
import applicationV1.modele.nourriture.PommeDeTerre;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PommeDeTerreVue {

	private Nourriture pommeDeTerre;
	private Nourriture pommeDeTerre2;
	private Pane panneauJeu;
	private ImageView img=new ImageView();
	
	
	private Personnage p;

	
	
	public PommeDeTerreVue(Pane panneauJeu,Nourriture pommeDeTerre,Personnage p) {
		this.panneauJeu=panneauJeu;
		this.pommeDeTerre=pommeDeTerre;
		this.p=p;
		this.img=new ImageView(new Image("./image/PommeDeTerre2.png"));
		panneauJeu.getChildren().add(img);
		img.setTranslateX(pommeDeTerre.getX());
    	img.setTranslateY(pommeDeTerre.getY());	
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
    	
	//	img.addEventHandler(MouseEvent.MOUSE_CLICKED,new ControleurClickPommeDeTerre(personnage, pommeDeTerreVue, pommeDeTerreList));

    }
	
	public Nourriture getPommeDeTerre2() {
		return pommeDeTerre2;
	}
/*
	public boolean PommeDeTerreACotePerso() {
		if(p.getX()<pommeDeTerre.getX()+40 && p.getX()>pommeDeTerre.getX()-15 && p.getY()<pommeDeTerre.getY()+40 && p.getY()>pommeDeTerre.getY()-15)
			return true;
		return false;
	}*/
	
	public int coordonneeImgX() {
		return (int)img.getLayoutX();
	}
	
	public int coordonneeImgY() {
		return (int)img.getLayoutY();
	}

	
	
}