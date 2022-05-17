package applicationV1.vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import applicationV1.modele.Personnage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PersonnageVue {
	
	private Pane panneauJeu;
	
	
	public PersonnageVue(Pane panneauJeu) {
		super();
		this.panneauJeu = panneauJeu;
	}

	public void perso ( Personnage personnage) throws FileNotFoundException {
		
		/*FileInputStream input = new FileInputStream("/home/etudiants/info/wvincent/prive/S2/DOO/TerrainJeu/src/image/perso.jpg");
		ImageView img = new ImageView(new Image (input));
   	 	panneauJeu.getChildren().add(img);
*/
		
		Circle r;
		r = new Circle(5);
		r.setFill(Color.RED);
		r.translateXProperty().bind(personnage.xProperty());
    	r.translateYProperty().bind(personnage.yProperty());
   	 	panneauJeu.getChildren().add(r);
   	 	  	 
	}
}
