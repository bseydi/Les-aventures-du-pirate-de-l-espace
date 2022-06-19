package controleur;

import applicationV1.modele.Terrain;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControleurTileQuitté implements EventHandler<MouseEvent>{
	
	private int num;
    private Terrain t;
    
    public ControleurTileQuitté(Terrain t,int numéro ) {
        this.num = numéro;
        this.t= t;
    }

	@Override
	public void handle(MouseEvent event) {
		ImageView img =(ImageView) event.getSource();
		if (t.getIdBlock(this.num) != 0)
	        img.setOpacity(1);
		else
			img.setOpacity(0);
	}
}
