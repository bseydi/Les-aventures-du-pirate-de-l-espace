package applicationV1.vue;

import applicationV1.modele.Creature1;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Creature1Vue {

	private Pane panneauJeu;
	private Creature1 creature1;
	
	public Creature1Vue (Pane panneauJeu, Creature1 creature1) {
		this.panneauJeu = panneauJeu;
		this.creature1 = creature1;
	}
	
	public void creature1 () {
		ImageView r = new ImageView(new Image("./image/astronaut.png"));
		r.translateXProperty().bind(creature1.xProperty());
    	r.translateYProperty().bind(creature1.yProperty());
   	 	panneauJeu.getChildren().add(r);
	}
	
	
}
