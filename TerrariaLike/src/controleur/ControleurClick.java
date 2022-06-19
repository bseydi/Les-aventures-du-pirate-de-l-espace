
package controleur;

import applicationV1.modele.Environnement;
import applicationV1.modele.Personnage;
import applicationV1.modele.Terrain;
import applicationV1.modele.fonctionnalités.GestionErreur;
import applicationV1.modele.fonctionnalités.Range;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ControleurClick implements EventHandler<MouseEvent> {
	private int idBlock;
	private int numéro;
	private Environnement env;
	private GestionErreur gn;

	
	public ControleurClick(Environnement env,int idBlock,int numéro, GestionErreur gn) {
		this.idBlock= idBlock;
		this.numéro = numéro;
		this.env = env;
		this.gn = gn;
	
	}

	public void handle(MouseEvent event) {
		ImageView img =(ImageView) event.getSource();
		if ( event.getButton() == MouseButton.PRIMARY && Range.coordTile(this.env.getPersonnage(),numéro)) {
			if(this.env.getPersonnage().getObjetEnMains() == 6) {
				if (this.env.getPersonnage().getInventaire().getNbOutils("Pelle") > 0 ) {
					if (this.idBlock == 1 || this.idBlock == 2) {
						img.setImage(new Image("./image/Blanc.png"));
						this.idBlock = 0;
						this.env.getTerrain().supprimerCase(numéro,0);
						img.setOpacity(0);
					}
				}
				else {
					gn.testerEreur(4);
				}
			}
			else if (this.env.getPersonnage().getObjetEnMains() == 5) {//pioche en pierre
				if (this.env.getPersonnage().getInventaire().getNbOutils("PiocheEnPierre") > 0) {
					if(this.idBlock == 4 ) {
						img.setImage(new Image("./image/Blanc.png"));
						this.env.getTerrain().supprimerCase(numéro,0);
						this.env.getPersonnage().getRessource().ajoutFer(1);
						this.idBlock = 0;
					}
					else if ( this.idBlock == 3) {
						img.setImage(new Image("./image/Blanc.png"));
						this.env.getTerrain().supprimerCase(numéro,0);
						this.env.getPersonnage().getRessource().ajoutPierre(1);
						this.idBlock = 0;                    
					}     
					img.setOpacity(0);
				}
				else {
					gn.testerEreur(4);
				}
			}
			else if (this.env.getPersonnage().getObjetEnMains() == 4){// pioche en bois
				if (this.env.getPersonnage().getInventaire().getNbOutils("PiocheEnBois") > 0) {
					if(this.idBlock == 3) {
						img.setImage(new Image("./image/Blanc.png"));
						this.env.getTerrain().supprimerCase(numéro,0);
						this.env.getPersonnage().getRessource().ajoutPierre(1);
						this.idBlock = 0;  
						 img.setOpacity(0);
					}
					else {
						gn.testerEreur(4);
					}
				}
			}

			else if (this.env.getPersonnage().getObjetEnMains() == 3 ) { 
				if (this.env.getPersonnage().getInventaire().getNbOutils("HacheEnPierre") > 0) {
					if ( this.idBlock > 10 && this.idBlock < 20 ) {
						img.setImage(new Image("./image/transparent.png"));
						this.env.getTerrain().supprimerCase(numéro,0);
						this.env.getPersonnage().getRessource().ajoutBois(1);
						this.idBlock = 0;    
					}		
				}
			}
			else if (this.env.getPersonnage().getObjetEnMains() == 1 || this.env.getPersonnage().getObjetEnMains() == 2) {
                if (Range.rangeTo(this.env.getPersonnage().getX(), this.env.getPersonnage().getY(), this.env.getCreature1().getX(), this.env.getCreature1().getY())) {
                    this.env.getCreature1().perdVie();
                }
            }
		}

		if ( event.getButton() == MouseButton.MIDDLE && Range.coordTile(this.env.getPersonnage(),numéro)) {
			if (this.env.getPersonnage().getBlocEnMains() == 1 && this.env.getPersonnage().getInventaire().getNbBloc("MurDePierre") >= 1 ) {
				img.setImage(new Image("./image/pierre.png"));
				if ( this.env.getTerrain().getIdBlock(numéro+50) != 0) {    
                    img.setImage(new Image("./image/pierre.png"));
                    this.env.getTerrain().supprimerCase(numéro,3);
                    this.idBlock = 3;
                    img.setOpacity(1);
                }
			}

			if (this.env.getPersonnage().getBlocEnMains()== 2 && this.env.getPersonnage().getInventaire().getNbBloc("Planche") >= 1 ) {
				img.setImage(new Image("./image/PlancheBlock.jpg"));
				this.env.getTerrain().supprimerCase(numéro,10);
				this.idBlock = 11;
				this.env.getPersonnage().getInventaire().supprimerObjets("Planche");
                img.setOpacity(1);
			}
			if (this.env.getPersonnage().getBlocEnMains() == 3 && this.env.getPersonnage().getInventaire().getNbBloc("FeuDeCamp") >= 1 && this.idBlock == 0) {
                img.setImage (new Image("./image/feuDeCamp.gif"));
                this.env.creerFeuDeCamp(numéro);
                this.env.getTerrain().supprimerCase(numéro,19);
                this.env.getPersonnage().getInventaire().supprimerObjets("FeuDeCamp");
                this.idBlock = 11;
                img.setOpacity(1);
            }
		}
	}
}

