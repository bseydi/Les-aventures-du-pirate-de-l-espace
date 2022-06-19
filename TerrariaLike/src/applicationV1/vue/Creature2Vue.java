package applicationV1.vue;

import applicationV1.modele.Environnement;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Creature2Vue {

	private Pane panneauJeu;
	private Environnement env;
	private ImageView r;
	
	public Creature2Vue (Pane panneauJeu, Environnement env) {
		this.panneauJeu = panneauJeu;
		this.env = env;		
	}
	
	public void creature2 () {
		r = new ImageView(new Image("./image/creature.gif"));
		r.translateXProperty().bind(this.env.getCreature2().xProperty());
    	r.translateYProperty().bind(this.env.getCreature2().yProperty());
    	panneauJeu.getChildren().add(r);  	 	
	}	
}