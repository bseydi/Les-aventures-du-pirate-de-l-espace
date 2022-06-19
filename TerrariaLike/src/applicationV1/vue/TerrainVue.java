package applicationV1.vue;

import java.io.FileNotFoundException;

import applicationV1.modele.Environnement;
import controleur.ControleurClick;
import controleur.ControleurTileQuitté;
import controleur.ControleurTileSurvolé;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;

public class TerrainVue {

	private TilePane terrainJeu;
	private Environnement env;
	private Image imageTerrain[];

	public TerrainVue(Environnement env,TilePane terrainJeu) {
		this.terrainJeu = terrainJeu;
		this.env = env;
		creerImageTerrain();

	}
	/*0 = ciel
	 * 1 = gazon
	 * 2 = terre
	 * 3 = pierre
	 * 4 = fer
	 */
	
	
	public void creerImageTerrain() {
		this.imageTerrain = new Image[19];
		this.imageTerrain[0] = new Image ("./image/transparent.png");
		this.imageTerrain[1] = new Image ("./image/gazon.png");
		this.imageTerrain[2] = new Image ("./image/terre.png");
		this.imageTerrain[3] = new Image ("./image/pierre.png");
		this.imageTerrain[4] = new Image ("./image/fer.png");
		
		this.imageTerrain[5] = new Image ("./image/imageArbre/arbre11.png");
		this.imageTerrain[6] = new Image ("./image/imageArbre/arbre12.png");
		this.imageTerrain[7] = new Image ("./image/imageArbre/arbre13.png");
		this.imageTerrain[8] = new Image ("./image/imageArbre/arbre14.png");
		this.imageTerrain[9] = new Image ("./image/imageArbre/arbre15.png");
		this.imageTerrain[10] = new Image ("./image/imageArbre/arbre16.png");
		this.imageTerrain[11] = new Image ("./image/imageArbre/arbre17.png");
		this.imageTerrain[12] = new Image ("./image/imageArbre/arbre18.png");
		
	}
	public void creerTerrainJeu() throws FileNotFoundException  {  

		ImageView img = null;
		int[] carte = env.getTerrain().getCarte();
		for(int i = 0; i < carte.length ;i++) {
			switch(carte[i]) {
			case 0:
				img = new ImageView(imageTerrain[0]);
				break;
			case 1:
				img = new ImageView(imageTerrain[1]);				
				break;
			case 2:
				img = new ImageView(imageTerrain[2]);		
				break;
			case 3:
				img = new ImageView(imageTerrain[3]);	
				break;
			case 4:
				img = new ImageView(imageTerrain[4]);	
				break;
			case 11:
				img = new ImageView(imageTerrain[5]);	
				break;
			case 12:
				img = new ImageView(imageTerrain[6]);			
				break;
			case 13:
				img = new ImageView(imageTerrain[7]);
				break;
			case 14:
				img = new ImageView(imageTerrain[8]);
				break;
			case 15:
				img = new ImageView(imageTerrain[9]);
				break;
			case 16:
				img = new ImageView(imageTerrain[10]);
				break;
			case 17:
				img = new ImageView(imageTerrain[11]);
				break;
			case 18:
				img = new ImageView(imageTerrain[12]);
				break;
				
			default: break;
			}
			terrainJeu.getChildren().add(img);
			img.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, new ControleurTileSurvolé());
			img.addEventHandler(MouseEvent.MOUSE_EXITED, new ControleurTileQuitté(this.env.getTerrain(), i));
			img.addEventHandler(MouseEvent.MOUSE_CLICKED, new ControleurClick(env,carte[i],i, env.getGn()));
		}
	}
}	