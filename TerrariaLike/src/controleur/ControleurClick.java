package controleur;

import applicationV1.modele.Terrain;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import applicationV1.modele.Personnage;
import applicationV1.modele.fonctionnalités.Range;


public class ControleurClick implements EventHandler<MouseEvent> {
	private int idBlock;
	private int numéro;
	private Terrain terrain;
	private Personnage perso;

	public ControleurClick(Personnage p,Terrain t,int idBlock,int numéro ) {
		this.idBlock= idBlock;
		this.numéro = numéro;
		this.terrain = t;
		this.perso = p;
	}

	@Override
	public void handle(MouseEvent event) {
		ImageView img =(ImageView) event.getSource();
		if (event.getButton() == MouseButton.SECONDARY && Range.coordTile(perso,numéro)) {
			if (this.idBlock >= 2 && this.idBlock <=6 ) {
				img.setImage(new Image("./image/Ciel.png"));
					terrain.supprimerCase(numéro);
			}
			if ( this.idBlock == 6) {
				perso.getRessource().ajoutPierre(1);
				idBlock = 1;

			} else if ( this.idBlock == 5 || this.idBlock == 4) {
				perso.getRessource().ajoutFer(1);
				idBlock = 1;
			}
		}


	}

}


