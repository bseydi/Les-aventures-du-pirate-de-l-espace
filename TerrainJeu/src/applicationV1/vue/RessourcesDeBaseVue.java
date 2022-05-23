package applicationV1.vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import applicationV1.modele.Ressources;
import applicationV1.modele.RessourcesDeBase;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

public class RessourcesDeBaseVue {
	
	private TilePane placeRessources;
	private Label labelRessources;
	private HBox hBoxRessources;
	private Map<Ressources,Integer> ressourcesBase;
	private Ressources r;
	private int nbRessources;
	private int bois;
	private int fer;
	private int fraise;
	private int pierre;
	private int pommeDeTerre;
	private int viandesDeCreatures;
	private int pommeDeTerreCuite;
	private int viandesDeCreaturesCuite;
	
	public RessourcesDeBaseVue(TilePane placeRessource,Label labelRessources,HBox hBoxRessources,Map<Ressources,Integer> ressourcesBase) {
		this.placeRessources=placeRessource;
		this.ressourcesBase=ressourcesBase;
	}
	
public void afficheRessources() throws FileNotFoundException {
		bois();
		fer();
		fraise();
		pierre();
		pommeDeTerre();
		viandesDeCreature();
		pommeDeTerreCuite();
		viandesDeCreatureCuite();
	}
	public void bois() throws FileNotFoundException{
		
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/coeur.png");
		ImageView img = new ImageView(new Image (input));
        this.placeRessources.getChildren().add(img);
        this.nbRessources=this.ressourcesBase.get(r);
	}
	
	public void fer() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/coeur.png");
		ImageView img = new ImageView(new Image (input));
        this.placeRessources.getChildren().add(img);
        this.nbRessources=this.ressourcesBase.get(r);
	}
	
	public void fraise() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/coeur.png");
		ImageView img = new ImageView(new Image (input));
        this.placeRessources.getChildren().add(img);
        this.nbRessources=this.ressourcesBase.get(r);
	}
	
	public void pierre() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/coeur.png");
		ImageView img = new ImageView(new Image (input));
        this.placeRessources.getChildren().add(img);
        this.nbRessources=this.ressourcesBase.get(r);
	}
	
	public void pommeDeTerre() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/coeur.png");
		ImageView img = new ImageView(new Image (input));
        this.placeRessources.getChildren().add(img);
        this.nbRessources=this.ressourcesBase.get(r);
	}
	
	public void pommeDeTerreCuite() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/coeur.png");
		ImageView img = new ImageView(new Image (input));
        this.placeRessources.getChildren().add(img);
        this.nbRessources=this.ressourcesBase.get(r);
	}
	
	public void viandesDeCreature() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/coeur.png");
		ImageView img = new ImageView(new Image (input));
        this.placeRessources.getChildren().add(img);
        this.nbRessources=this.ressourcesBase.get(r);
	}
	
	public void viandesDeCreatureCuite() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/coeur.png");
		ImageView img = new ImageView(new Image (input));
        this.placeRessources.getChildren().add(img);
        this.nbRessources=this.ressourcesBase.get(r);
	}
}
