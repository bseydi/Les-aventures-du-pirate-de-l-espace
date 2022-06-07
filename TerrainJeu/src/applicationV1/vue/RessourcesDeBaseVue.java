package vue;

import java.io.FileNotFoundException;
import modele.Personnage;

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
		labelBois.textProperty().bind(perso.getRessource().nombreBoisProperty().asString());           
		labelFer.textProperty().bind(perso.getRessource().nombreFerProperty().asString());
		labelPierre.textProperty().bind(perso.getRessource().nombrePierreProperty().asString());	
	}

}
