package applicationV1.vue;

import applicationV1.modele.PnjCraft;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PnjCraftVue {
	
	
	
	private Pane panneauJeu;
	private PnjCraft pnj;
	
	public PnjCraftVue (Pane panneauJeu, PnjCraft pnj) {
		
		this.panneauJeu = panneauJeu;
		this.pnj = pnj;
	}
	
	public void pnj () {
		ImageView img = new ImageView(new Image("./image/alien.gif"));	// Creation du modèle pnj
		img.translateXProperty().bind(pnj.xProperty());
    	img.translateYProperty().bind(pnj.yProperty());
   	 	panneauJeu.getChildren().add(img);
	}
	

}
