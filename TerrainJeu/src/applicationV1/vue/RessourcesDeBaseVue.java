package applicationV1.vue;

import java.io.FileNotFoundException;
import applicationV1.modele.Personnage;

import javafx.scene.control.Label;


public class RessourcesDeBaseVue {
	
	
	private Label labelBois;
	private Label labelFer;
	private Label labelPierre;
	private Personnage perso;
	
	
	public RessourcesDeBaseVue(Personnage p,Label labelBois,Label labelFer,Label labelPierre) {
		this.labelBois=labelBois;
		this.labelFer=labelFer;
		this.labelPierre=labelPierre;
		this.perso = p;
	}
	
	public void afficheRessources() throws FileNotFoundException {
		labelBois.textProperty().bind(perso.getRessource().getNbBoisProperty().asString());           
		labelFer.textProperty().bind(perso.getRessource().getNbFerProperty().asString());
		labelPierre.textProperty().bind(perso.getRessource().getNbPierreProperty().asString());	
	}

}
