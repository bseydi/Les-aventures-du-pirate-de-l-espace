package applicationV1.vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

import applicationV1.modele.Ressources;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class RessourcesDeBaseVue {
	
	private TilePane placeRessources;
	private Label labelBois;
	private Label labelFer;
	private Label labelPierre;
	private ArrayList<Ressources> listRessources;
	private Ressources bois;
	private Ressources fer;
	private Ressources pierre;
	
	public RessourcesDeBaseVue(TilePane placeRessource,Label labelBois,Label labelFer,Label labelPierre,ArrayList<Ressources> listRessources) {
		this.placeRessources=placeRessource;
		this.labelBois=labelBois;
		this.labelFer=labelFer;
		this.labelPierre=labelPierre;
		this.listRessources=listRessources;
	}
	
	public void afficheRessources() throws FileNotFoundException {
		bois();
		fer();
		pierre
	}
	
	public void bois() throws FileNotFoundException{
		this.bois=listRessources.get(0);
		labelBois.textProperty().bind(this.bois.getQuantiteProperty().asString());
	}
	
	public void fer() throws FileNotFoundException{
		this.fer=listRessources.get(1);
		labelFer.textProperty().bind(this.fer.getQuantiteProperty().asString());
	}
	
	public void pierre() throws FileNotFoundException{
		this.pierre=listRessources.get(3);
		labelPierre.textProperty().bind(this.pierre.getQuantiteProperty().asString());
	}
}
