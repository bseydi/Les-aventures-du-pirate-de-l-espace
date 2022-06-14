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
			System.out.println("test1");

			if(personnage.getObjetEnMains() == 1) {
				if (personnage.getInventaire().nbOutils("Pelle") > 0 ) {
					if (this.idBlock == 1 || this.idBlock == 2) {
						img.setImage(new Image("./image/transparent.png"));
						terrain.supprimerCase(numéro,0);
						this.idBlock = 0;
					}
				}else {
					System.out.println("Vous n'avez pas de pelle !");
				}
			}else if (personnage.getObjetEnMains() == 5) {//pioche en pierre
				if (personnage.getInventaire().nbOutils("PiocheEnPierre") > 0) {
					if(this.idBlock == 4 ) {
						img.setImage(new Image("./image/transparent.png"));
						terrain.supprimerCase(numéro,0);
						personnage.getRessource().ajoutFer(1);
						this.idBlock = 0;
					}else if ( this.idBlock == 3) {
						img.setImage(new Image("./image/transparent.png"));
						terrain.supprimerCase(numéro,0);
						personnage.getRessource().ajoutPierre(1);
						this.idBlock = 0;                    
					}                
				} else {
					System.out.println("Vous n'avez pas de pioche en pierre !");
				}

			}else if (personnage.getObjetEnMains() == 4){// pioche en bois
				if (personnage.getInventaire().nbOutils("PiocheEnBois") > 0) {
					if(this.idBlock == 3) {
						img.setImage(new Image("./image/transparent.png"));
						terrain.supprimerCase(numéro,0);
						personnage.getRessource().ajoutPierre(1);
						this.idBlock = 0;    
					} else {
						System.out.println("Vous n'avez pas de pioche en bois !");

					}
				}
			}

			else if (personnage.getObjetEnMains() == 3 ) { 
				if (personnage.getInventaire().nbOutils("HacheEnPierre") > 0) {
					if ( this.idBlock > 10 && this.idBlock < 20 ) {
						img.setImage(new Image("./image/transparent.png"));
						terrain.supprimerCase(numéro,0);
						personnage.getRessource().ajoutBois(1);
						System.out.println("test22");
						this.idBlock = 0;    
					}		
				}
			}
		}

		if ( event.getButton() == MouseButton.MIDDLE && Range.coordTile(personnage,numéro)) {
			if ( personnage.getBlocEnMains() == 1 && personnage.getInventaire().getNbBloc("MurDePierre") >= 1 ) {
				System.out.println("test2");
				img.setImage(new Image("./image/pierre.png"));
				terrain.supprimerCase(numéro,3);
				this.idBlock = 3;
				personnage.getInventaire().supprimerObjets("MurDePierre");
			}

			if (personnage.getBlocEnMains()== 2 && personnage.getInventaire().getNbBloc("Planche") >= 1 ) {
				System.out.println("test3");

				img.setImage(new Image("./image/PlancheBlock.jpg"));
				terrain.supprimerCase(numéro,19);
				this.idBlock = 19;
				personnage.getInventaire().supprimerObjets("Planche");
			}


		}
	}

}

