package applicationV1.vue;

import java.io.FileNotFoundException;
import applicationV1.modele.Terrain;
import controleur.ControleurClick;
import controleur.ControleurTileQuitté;
import controleur.ControleurTileSurvolé;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;

public class TerrainVue {

	private TilePane terrainJeu;
	private Terrain terrain;

	public TerrainVue(TilePane terrainJeu, Terrain terrain) {
		this.terrainJeu = terrainJeu;
		this.terrain = terrain;

	}

	public void creerTerrainJeu() throws FileNotFoundException  {  

		ImageView img = null;
		int[] carte = terrain.getCarte();
		for(int i = 0; i < carte.length ;i++) {
			switch(carte[i]) {
			case 1:
				img = new ImageView(new Image("./image/Ciel.png"));
				break;
			case 2:
				img = new ImageView(new Image("./image/gazon.png"));
				break;
			case 3:
				img = new ImageView(new Image("./image/Terre.png"));
				break;
			case 4:
				img = new ImageView(new Image("./image/fer1.png"));
				break;
			case 5:
				img = new ImageView(new Image("./image/fer2.png"));
				break;
			case 6:
				img = new ImageView(new Image("./image/pierre.png"));
				break;

			default: break;
			}
			terrainJeu.getChildren().add(img);
			img.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, new ControleurTileSurvolé());
			img.addEventHandler(MouseEvent.MOUSE_EXITED, new ControleurTileQuitté());
			img.addEventHandler(MouseEvent.MOUSE_CLICKED, new ControleurClick(terrain,carte[i],i));
		}
	}
}	