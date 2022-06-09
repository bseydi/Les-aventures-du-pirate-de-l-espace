package applicationV1.vue;

import applicationV1.modele.Personnage;
import applicationV1.modele.fonctionnalités.Arbre;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ArbreVue {

	private Arbre arbre;
	private Pane paneArbre;
	private Personnage p;
	private Image[] tabImg;
	ImageView img=new ImageView();
	
	public ArbreVue(Pane paneArbre, Arbre arbre,Personnage p) {
		this.paneArbre=paneArbre;
		this.arbre=arbre;
		this.p=p;
		this.tabImg=new Image[2];
		tabImg[0]=new Image("./image/imageArbre/arbreFruitier.png");
		tabImg[1]=new Image("./image/imageArbre/arbreSansFruit.png");
		this.img = new ImageView(tabImg[0]);
		paneArbre.getChildren().add(img);
		img.setTranslateX(arbre.getxProperty().intValue());
    	img.setTranslateY(arbre.getyProperty().intValue());
	}

	public void afficherArbre() {
		paneArbre.getChildren().remove(img);
		if(this.arbre.getArbreProperty().getValue()==1) {
			img = new ImageView(tabImg[0]);
		}else if(this.arbre.getArbreProperty().getValue()==2){
			img = new ImageView(tabImg[1]);
		}
		img.setTranslateX(arbre.getxProperty().intValue());
    	img.setTranslateY(arbre.getyProperty().intValue());
		paneArbre.getChildren().add(img);
	}
	
	// vérifier que le personnage se trouve devant l'arbre
	public boolean changerArbre() {
		if(p.getX()<arbre.getxProperty().intValue()+40 && p.getX()>arbre.getxProperty().intValue()-15)
			return true;
		return false;
	}
}
