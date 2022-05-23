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
	private Map<String,Integer> ressourcesBase;
	private String r;
	private int nbRessources;

	
	public RessourcesDeBaseVue(TilePane placeRessource,Map<String,Integer> ressourcesBase) {
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
		/*for(String key : this.ressourcesBase.keySet()){
			System.out.println(key + " -> " + this.ressourcesBase.get(key));
			if(key=="bois") {
				bois();
				System.out.println("bois");
			}else if(key=="fer") {
				fer();
			}else if(key=="fraise") {
				fraise();
			}else if(key=="pierre") {
				pierre();
			}else if(key=="pommeDeTerre") {
				pommeDeTerre();
			}else if(key=="viandesDeCreatures") {
				viandesDeCreature();
			}else if(key=="pommeDeTerreCuite") {
				pommeDeTerreCuite();
			}else if(key=="viandesDeCreaturesCuite") {
				viandesDeCreatureCuite();
			}
		}
		*/
	}
	
	public void bois() throws FileNotFoundException{
		
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/bois_ressources.jpg");
		ImageView img = new ImageView(new Image (input));
        this.placeRessources.getChildren().add(img);
        
        
	}
	
	public void fer() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/fer_ressourcesBase.jpg");
		ImageView img = new ImageView(new Image (input));
        this.placeRessources.getChildren().add(img);
	}
	
	public void fraise() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/Fraise_ressources.jpg");
		ImageView img = new ImageView(new Image (input));
        this.placeRessources.getChildren().add(img);
	}
	
	public void pierre() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/Pierre_ressources.jpg");
		ImageView img = new ImageView(new Image (input));
        this.placeRessources.getChildren().add(img);
	}
	
	public void pommeDeTerre() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/PommeDeTerre_ressources_ressources.jpg");
		ImageView img = new ImageView(new Image (input));
        this.placeRessources.getChildren().add(img);
        //this.nbRessources=this.ressourcesBase.get("pommeDeTerre");
	}
	
	public void pommeDeTerreCuite() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/PommeDeTerreCuite.jpg");
		ImageView img = new ImageView(new Image (input));
        this.placeRessources.getChildren().add(img);
       // this.nbRessources=this.ressourcesBase.get("pommeDeTerreCuite");
	}
	
	public void viandesDeCreature() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/ViandesdeCreatures_ressources.jpg");
		ImageView img = new ImageView(new Image (input));
        this.placeRessources.getChildren().add(img);
        //this.nbRessources=this.ressourcesBase.get("viandesDeCreatures");
	}
	
	public void viandesDeCreatureCuite() throws FileNotFoundException{
		FileInputStream input = new FileInputStream("/home/etudiants/info/slecomte/works_01/TerrainJeu/src/image/ViandeDeCreaturesCuite_ressources.jpg");
		ImageView img = new ImageView(new Image (input));
        this.placeRessources.getChildren().add(img);
   // this.nbRessources=this.ressourcesBase.get("viandesDeCreaturesCuite");
	}
}
