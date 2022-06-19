package applicationV1.vue;

import applicationV1.modele.Environnement;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class FuséeVue {

	private Pane panneauJeu;
	private Environnement env;
	private ImageView r;
	
	public FuséeVue (Pane panneauJeu, Environnement env) {
		this.panneauJeu = panneauJeu;
		this.env = env;
	}
	
	public void créerFusée () {
		r = new ImageView(new Image ("./image/fuséeSansFeu.png"));	// Creation de notre sprite
		r.translateXProperty().bind(this.env.getFusée().xProperty());
    	r.translateYProperty().bind(this.env.getFusée().yProperty());
   	 	panneauJeu.getChildren().add(r);
   	 	r.setVisible(false);
	}
	
	public void FaireApparaîtreFusée() {
		r.setVisible(!r.isVisible());
	}
	
	public void fuséeEnFeu() {
		r.setImage(new Image ("./image/fuséeAvecFeu.png"));
	}
	
	
}