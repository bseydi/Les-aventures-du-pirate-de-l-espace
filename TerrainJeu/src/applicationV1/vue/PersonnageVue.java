package applicationV1.vue;

import applicationV1.modele.Personnage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PersonnageVue {
	
	private Pane panneauJeu;
	
	
	public PersonnageVue(Pane panneauJeu) {
		super();
		this.panneauJeu = panneauJeu;
	}

	public void perso ( Personnage personnage) {
		Circle r;
		r = new Circle(5);
		r.setFill(Color.RED);
		r.translateXProperty().bind(personnage.xProperty());
    	r.translateYProperty().bind(personnage.yProperty());
   	 	panneauJeu.getChildren().add(r);   	 
	}
}
