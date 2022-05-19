package controleur;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ControleurClick implements EventHandler<MouseEvent> {
	int id;
	
	public ControleurClick(int i) {
		this.id= i;
	}

	@Override
	public void handle(MouseEvent event) {
		ImageView img =(ImageView) event.getSource();
		if ( event.getButton() == MouseButton.SECONDARY && this.id == 2 || this.id == 3 ) {
			img.setImage(new Image("./image/Ciel.png"));
		}
	}

}
