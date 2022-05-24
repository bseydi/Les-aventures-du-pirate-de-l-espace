package applicationV1.vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import applicationV1.modele.Ressources;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class RessourcesDeBaseVue {
	
	private TilePane placeRessources;
	private Map<Ressources,Integer> ressourcesBase;
	private int nbRessources;

	
	public RessourcesDeBaseVue(TilePane placeRessource,Map<Ressurces,Integer> ressourcesBase) {
		this.placeRessources=placeRessource;

		this.ressourcesBase=ressourcesBase;
	}
	
	public void afficheRessources() throws FileNotFoundException {
		bois();
		fer();
		pierre
	}
	
	public void bois() throws FileNotFoundException{
		
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/imageRessources/ressource_bois.png");
		ImageView img = new ImageView(new Image (input));
		this.placeRessources.getChildren().add(img);
        
        
	}
	
	public void fer() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/imageRessources/ressource_fer.png");
		ImageView img = new ImageView(new Image (input));
        	this.placeRessources.getChildren().add(img);
	}
	
	public void fraise() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/Fraise_ressources.jpg");
		ImageView img = new ImageView(new Image (input));
       	 	this.placeRessources.getChildren().add(img);
	}
	
	public void pierre() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/imageRessources/ressource_pierre.png");
		ImageView img = new ImageView(new Image (input));
        	this.placeRessources.getChildren().add(img);
	}
	
	public void pommeDeTerre() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/PommeDeTerre_ressources_ressources.jpg");
		ImageView img = new ImageView(new Image (input));
        	this.placeRessources.getChildren().add(img);
	}
	
	public void pommeDeTerreCuite() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/PommeDeTerreCuite.jpg");
		ImageView img = new ImageView(new Image (input));
        	this.placeRessources.getChildren().add(img);
	}
	
	public void viandesDeCreature() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/ViandesdeCreatures_ressources.jpg");
		ImageView img = new ImageView(new Image (input));
       	 	this.placeRessources.getChildren().add(img);
	}
	
	public void viandesDeCreatureCuite() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/ViandeDeCreaturesCuite_ressources.jpg");
		ImageView img = new ImageView(new Image (input));
        	this.placeRessources.getChildren().add(img);
	}
}
