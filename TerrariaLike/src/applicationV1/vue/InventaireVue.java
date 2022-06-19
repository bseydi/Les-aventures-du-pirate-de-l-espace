package applicationV1.vue;

import applicationV1.modele.Personnage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class InventaireVue {
	
	private Pane panneauJeu;
	private Personnage personnage;
	private ImageView[] tabImgView ;
	private ImageView imgView;
	private Image[] tabImg ;
	private Image img;
	
	public InventaireVue (Pane panneauJeu, Personnage personnage) {
		this.panneauJeu = panneauJeu;
		this.personnage = personnage;
		
    	this.tabImg = new Image[14];
    	
    	this.tabImg[0] = img = new Image("./image/Fraise.png");
    	this.tabImg[1] = img = new Image("./image/ViandeCreature.png");
    	this.tabImg[2] = img = new Image("./image/ViandeCreatureCuite.png");
    	this.tabImg[3] = img = new Image("./image/PommeDeTerre.png");
    	this.tabImg[4] = img = new Image("./image/PatateCuite.png");
    	
    	this.tabImg[5] = img = new Image("./image/coblestone.png");
    	this.tabImg[6] = img = new Image("./image/planche.png");
    	this.tabImg[7] = img = new Image("./image/feuDeCampCadre.gif");
    	
    	this.tabImg[8] = img = new Image("./image/pelleBois.png");
    	this.tabImg[9] = img = new Image("./image/EpeePierre.png");
    	this.tabImg[10] = img = new Image("./image/epeeFer.png");
    	this.tabImg[11] = img = new Image("./image/hachePierre.png");
    	this.tabImg[12] = img = new Image("./image/piocheBois.png");
    	this.tabImg[13] = img = new Image("./image/piochePierre.png");
    	
    	this.tabImgView = new ImageView[3];
    	
    	this.tabImgView[0] = imgView = new ImageView(this.tabImg[3]);
		this.tabImgView[1] = imgView = new ImageView(this.tabImg[5]);
		this.tabImgView[2] = imgView = new ImageView(this.tabImg[8]);
		
    	this.panneauJeu.getChildren().add(tabImgView[0]);
		this.tabImgView[0].setTranslateX(192);
		this.tabImgView[0].setTranslateY(18);
		
		this.panneauJeu.getChildren().add(tabImgView[1]);
		this.tabImgView[1].setTranslateX(240);
		this.tabImgView[1].setTranslateY(18);
		this.tabImgView[1].setOpacity(0.5);
		
		this.panneauJeu.getChildren().add(tabImgView[2]);
		this.tabImgView[2].setTranslateX(288);
		this.tabImgView[2].setTranslateY(18);
		
	}
	
	public void changerItems(int typeItems) {
		int i=0;
		if (typeItems == 1) {
			i=personnage.changerItemsEnMain(typeItems);						
		}
		else if (typeItems == 2) {
			i=personnage.changerItemsEnMain(typeItems);			
		}
		else if (typeItems == 3) {
			i=personnage.changerItemsEnMain(typeItems);
		}
	
		switch(i) {
		case 1 :
			if (typeItems == 1) {
				this.tabImgView[0].setImage(this.tabImg[0]);
			}
			else if (typeItems == 2) {
				this.tabImgView[1].setImage(this.tabImg[6]);
				if (personnage.getInventaire().getNbBloc("Planche") == 0) {
					this.tabImgView[1].setOpacity(0.5);
				}
			}
			else if (typeItems == 3) {
				this.tabImgView[2].setImage(this.tabImg[9]);
				if (personnage.getInventaire().getNbOutils("EpéeEnPierre") == 0) {
					this.tabImgView[2].setOpacity(0.5);
				}
			}	
			break;
		case 2 :
			if (typeItems == 1) {
				this.tabImgView[0].setImage(this.tabImg[1]);
			}
			else if (typeItems == 2) {
				this.tabImgView[1].setImage(this.tabImg[7]);
			}
			else if (typeItems == 3) {
				this.tabImgView[2].setImage(this.tabImg[10]);
				if (personnage.getInventaire().getNbOutils("EpéeEnFer") == 0) {
					this.tabImgView[2].setOpacity(0.5);
				}
			}	
			break;
		case 3 :
			if (typeItems == 1) {
				this.tabImgView[0].setImage(this.tabImg[2]);
			} 
			else if (typeItems == 2) {
				this.tabImgView[1].setImage(this.tabImg[5]);
				if (personnage.getInventaire().getNbBloc("MurDePierre") == 0) {
					this.tabImgView[1].setOpacity(0.5);
				}
			}
			else if (typeItems == 3) {
				this.tabImgView[2].setImage(this.tabImg[11]);
				if (personnage.getInventaire().getNbOutils("HacheEnPierre") == 0) {
					this.tabImgView[2].setOpacity(0.5);
				}
			}		
			break;
		case 4 :
			if (typeItems == 1) {
				this.tabImgView[0].setImage(this.tabImg[3]);
			}
			else if (typeItems == 3) {
				this.tabImgView[2].setImage(this.tabImg[12]);
				if (personnage.getInventaire().getNbOutils("PiocheEnBois") == 0) {
					this.tabImgView[2].setOpacity(0.5);
				}
			}		
			break;
		case 5 :
			if (typeItems == 1) {
				this.tabImgView[0].setImage(this.tabImg[4]);
			}
			else if (typeItems == 3) {
				this.tabImgView[2].setImage(this.tabImg[13]);
				if (personnage.getInventaire().getNbOutils("PiocheEnPierre") == 0) {
					this.tabImgView[2].setOpacity(0.5);
				}
			}	
			break;
		case 6 :
			if (typeItems == 3) {
				this.tabImgView[2].setImage(this.tabImg[8]);
				if (personnage.getInventaire().getNbOutils("Pelle") == 0) {
					this.tabImgView[2].setOpacity(0.5);
				}
			}
			break;

		default: break;
		}
	
	}
	
}