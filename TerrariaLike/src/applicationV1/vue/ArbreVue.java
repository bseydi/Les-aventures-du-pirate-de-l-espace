package applicationV1.vue;

import applicationV1.modele.Arbre;
import applicationV1.modele.Personnage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ArbreVue {

	private Arbre arbre;
	private Pane paneArbre;
	private Personnage p;
	private ImageView img;
	
	public ArbreVue(Pane paneArbre, Arbre arbre,Personnage p) {
		this.paneArbre=paneArbre;
		this.arbre=arbre;
		this.p=p;
		this.img=new ImageView( new Image("./image/imageArbre/Fraisier.png"));
		paneArbre.getChildren().add(img);
		img.setTranslateX(arbre.getX());
    	img.setTranslateY(arbre.getY());
	}

	public void afficherArbre() {
		paneArbre.getChildren().remove(img);
		img.setTranslateX(arbre.getX());
    	img.setTranslateY(arbre.getY());
		paneArbre.getChildren().add(img);
	}
	
	// vérifier que le personnage se trouve devant l'arbre
	public boolean ArbreACotePerso() {
		if(p.getX()<arbre.getX()+40 && p.getX()>arbre.getX()-15)
			return true;
		return false;
	}
}