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
	private Image[] tabImg;
	private ImageView img;
	
	public ArbreVue(Pane paneArbre, Arbre arbre,Personnage p) {
		this.paneArbre=paneArbre;
		this.arbre=arbre;
		this.p=p;
		this.tabImg=new Image[2];
		tabImg[0]=new Image("./image/imageArbre/Fraisier.png");
		tabImg[1]=new Image("./image/imageArbre/arbreSansFruit.png");
		this.img = new ImageView(tabImg[0]);
		paneArbre.getChildren().add(img);
		img.setTranslateX(arbre.getX());
    	img.setTranslateY(arbre.getY());
	}

	public void afficherArbre() {
		paneArbre.getChildren().remove(img);
		if(this.arbre.getArbre()==1) {
			img = new ImageView(tabImg[0]);
		}else if(this.arbre.getArbre()==2){
			img = new ImageView(tabImg[1]);
		}
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