package vue;


import modele.Personnage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PersonnageVue {
	
	private Pane panneauJeu;
	Personnage personnage;
		
	public PersonnageVue(Pane panneauJeu, Personnage personnage) {
		super();
		this.panneauJeu = panneauJeu;
		this.personnage = personnage;
	}

	public void perso () {
		ImageView r = new ImageView(new Image("./image/astronaut.png"));	// Creation de notre sprite
		r.translateXProperty().bind(personnage.xProperty());
    	r.translateYProperty().bind(personnage.yProperty());
   	 	panneauJeu.getChildren().add(r);
	}
}
