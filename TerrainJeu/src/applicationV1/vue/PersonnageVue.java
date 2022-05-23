package applicationV1.vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import applicationV1.modele.principal.Personnage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PersonnageVue {
	
	private Pane panneauJeu;
	Personnage personnage;
		
	public PersonnageVue(Pane panneauJeu, Personnage personnage) {
		super();
		this.panneauJeu = panneauJeu;
		this.personnage = personnage;
	}

	public void perso () {
		/*Circle r;
		r = new Circle(5);
		r.setFill(Color.RED);*/
		ImageView r = new ImageView(new Image("./image/astronaute(2).jpeg"));
		r.translateXProperty().bind(personnage.xProperty());
    	r.translateYProperty().bind(personnage.yProperty());
   	 	panneauJeu.getChildren().add(r);
	}
}
