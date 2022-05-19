package controleur;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControleurTileQuitté implements EventHandler<MouseEvent>{

	@Override
	public void handle(MouseEvent event) {
		ImageView img =(ImageView) event.getSource();
		img.setOpacity(1);
	}

}
