package controleur;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControleurTileSurvolé implements EventHandler<MouseEvent>{

	public ControleurTileSurvolé( ) {
		
	}
	@Override
	public void handle(MouseEvent event) {
		ImageView img =(ImageView) event.getSource();
		img.setOpacity(0.8);
	}

}