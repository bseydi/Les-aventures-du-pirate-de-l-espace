package controleur;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControleurTileSurvol√© implements EventHandler<MouseEvent>{
	
	private int idBlock;

	public ControleurTileSurvol√©( ) {
		this.idBlock = idBlock;
	}
	@Override
	public void handle(MouseEvent event) {
		ImageView img =(ImageView) event.getSource();
		if ( this.idBlock != 0)
	        img.setOpacity(0.8);
	}

}
