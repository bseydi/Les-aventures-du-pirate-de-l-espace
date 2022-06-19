package applicationV1.vue;

import applicationV1.modele.Environnement;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Creature1Vue {

	private Pane panneauJeu;
	private Environnement env;
	private ImageView r;
	
	public Creature1Vue (Pane panneauJeu, Environnement env) {
		this.panneauJeu = panneauJeu;
		this.env = env;
	}
	
	public void creature1 () {
		r = new ImageView(new Image("./image/corbeau.gif"));
		r.translateXProperty().bind(this.env.getCreature1().xProperty());
    	r.translateYProperty().bind(this.env.getCreature1().yProperty());
   	 	panneauJeu.getChildren().add(r);
	}
	
	
}
