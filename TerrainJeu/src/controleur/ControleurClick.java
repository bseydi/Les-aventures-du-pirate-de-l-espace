package controleur;

import applicationV1.modele.Terrain;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ControleurClick implements EventHandler<MouseEvent> {
	private int idBlock;
	private int numéro;
	private Terrain terrain;
	
	public ControleurClick(Terrain t,int idBlock,int numéro ) {
		this.idBlock= idBlock;
		this.numéro = numéro;
		this.terrain = t;
	}

	@Override
	public void handle(MouseEvent event) {
		ImageView img =(ImageView) event.getSource();
		if ( event.getButton() == MouseButton.SECONDARY && (this.idBlock == 2 || this.idBlock == 3 )) {
			img.setImage(new Image("./image/Ciel.png"));
			terrain.supprimerCase(numéro);
			
		}
		
	}

}
