package controleur;

import applicationV1.modele.Personnage;
import applicationV1.modele.Terrain;
import applicationV1.modele.fonctionnalités.Range;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ControleurClick implements EventHandler<MouseEvent> {
	private int idBlock;
	private int numéro;
	private Terrain terrain;
	private Personnage personnage;
	
	public ControleurClick(Personnage personnage,Terrain t,int idBlock,int numéro ) {
		this.idBlock= idBlock;
		this.numéro = numéro;
		this.terrain = t;
		this.personnage = personnage;
	}

	
	@Override
	public void handle(MouseEvent event) {
		ImageView img =(ImageView) event.getSource();
		if ( event.getButton() == MouseButton.PRIMARY && Range.coordTile(personnage,numéro)) {
			if(personnage.getObjetEnMains() == 6) { //pelle
				if (personnage.getInventaire().nbOutils("Pelle") > 0) { 
					if (this.idBlock == 2 || this.idBlock == 3) {
						img.setImage(new Image("./image/Ciel.png"));
						terrain.supprimerCase(numéro);
					}
				}else {
					System.out.println("Vous n'avez pas de pelle !");
				}
			}else if (personnage.getObjetEnMains() == 5) {//pioche en pierre
				if (personnage.getInventaire().nbOutils("PiocheEnPierre") > 0) {
					if(this.idBlock == 4 || this.idBlock == 5) {
						img.setImage(new Image("./image/Ciel.png"));
						terrain.supprimerCase(numéro);
						personnage.getRessource().ajoutFer(1);
						this.idBlock = 1;
					}else if ( this.idBlock == 6) {
						img.setImage(new Image("./image/Ciel.png"));
						terrain.supprimerCase(numéro);
						personnage.getRessource().ajoutPierre(1);
						this.idBlock = 1;					
					}				
				} else {
					System.out.println("Vous n'avez pas de pioche en pierre !");
				}
				
			}else if (personnage.getObjetEnMains() == 4){// pioche en bois
				if (personnage.getInventaire().nbOutils("PiocheEnBois") > 0) {
					if(this.idBlock == 6) {
						img.setImage(new Image("./image/Ciel.png"));
						terrain.supprimerCase(numéro);
						personnage.getRessource().ajoutPierre(1);
						this.idBlock = 1;	
					} else {
						System.out.println("Vous n'avez pas de pioche en bois !");
					}
				}
			}	
		}
		
		if ( event.getButton() == MouseButton.SECONDARY && Range.coordTile(personnage,numéro)) {
			System.out.println("secondary");
		}

	}

}
