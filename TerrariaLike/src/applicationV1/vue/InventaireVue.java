package applicationV1.vue;

import applicationV1.modele.Personnage;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class InventaireVue {
	
	private Pane panneauJeu;
	private Personnage personnage;
	private ImageView img1 = null, img2 = null,img3 = null;
	
	public InventaireVue (Pane panneauJeu, Personnage personnage) {
		this.panneauJeu = panneauJeu;
		this.personnage = personnage;
		
		img1 = new ImageView(new Image("./image/Fraise.png"));
		panneauJeu.getChildren().add(img1);
		img1.setTranslateX(192);
    	img1.setTranslateY(18);
    	
    	img2 = new ImageView(new Image("./image/coblestone.png"));  	
		panneauJeu.getChildren().add(img2);
		img2.setTranslateX(240);
    	img2.setTranslateY(18); 
    	
    	img3  = new ImageView(new Image("./image/pelleBois.png"));  	
		panneauJeu.getChildren().add(img3);
		img3.setTranslateX(288);
    	img3.setTranslateY(18);    	
	}
	
	
	public void changerItems(int typeItems) {
		ImageView img = null;
		int i=0;
		if (typeItems == 1) {
			i=personnage.changerItemsEnMain(typeItems);						
		}else if (typeItems == 2) {
			i=personnage.changerItemsEnMain(typeItems);			
		}else if (typeItems == 3) {
			i=personnage.changerItemsEnMain(typeItems);
		}
		panneauJeu.getChildren().remove(img);
		switch(i) {
		case 1 :
			if (typeItems == 1) {
				img = new ImageView(new Image("./image/Fraise.png"));
			} else if (typeItems == 2) {
				img = new ImageView(new Image("./image/coblestone.png"));
			} else if (typeItems == 3) {
				img = new ImageView(new Image("./image/EpeePierre.png"));
			}	
			break;
		case 2 :
			if (typeItems == 1) {
				img = new ImageView(new Image("./image/PommeDeTerre.png"));
			} else if (typeItems == 2) {
				img = new ImageView(new Image("./image/planche.png"));
			} else if (typeItems == 3) {
				img = new ImageView(new Image("./image/epeeFer.png"));
			}			
			break;
		case 3 :
			if (typeItems == 1) {
				img = new ImageView(new Image("./image/PatateCuite.png"));
			} else if (typeItems == 2) {
				img = new ImageView(new Image("./image/PommeDeTerre.png"));
			} else if (typeItems == 3) {
				img = new ImageView(new Image("./image/hachePierre.png"));
			}		
			break;
		case 4 :
			if (typeItems == 1) {
				img = new ImageView(new Image("./image/ViandeCreature.png"));
			} else if (typeItems == 2) {
				img = new ImageView(new Image("./image/Fraise.png"));
			} else if (typeItems == 3) {
				img = new ImageView(new Image("./image/piocheBois.png"));
			}		
			break;
		case 5 :
			if (typeItems == 1) {
				img = new ImageView(new Image("./image/ViandeCreatureCuite.png"));
			} else if (typeItems == 2) {
				img = new ImageView(new Image("./image/planche.png"));
			} else if (typeItems == 3) {
				img = new ImageView(new Image("./image/piochePierre.png"));
			}	
			break;
		case 6 :
			if (typeItems == 1) {
				img = new ImageView(new Image("./image/ressource_bois.png"));	
			} else if (typeItems == 2) {
				img = new ImageView(new Image("./image/ressource_bois.png"));
			} else if (typeItems == 3) {
				img = new ImageView(new Image("./image/pelleBois.png"));
			}
			break;

		default: break;
		}

		if (typeItems == 1) {
			panneauJeu.getChildren().remove(img1);			
			img1 = img;
			panneauJeu.getChildren().add(img1);	
			img1.setTranslateX(192);
			img1.setTranslateY(18);						
		}else if (typeItems == 2) {
			panneauJeu.getChildren().remove(img2);			
			img2 = img;
			panneauJeu.getChildren().add(img2);	
			img2.setTranslateX(240);
			img2.setTranslateY(18);	
			
		}else if (typeItems == 3) {
			panneauJeu.getChildren().remove(img3);
			img3 = img;
			panneauJeu.getChildren().add(img3);	
			img3.setTranslateX(288);
			img3.setTranslateY(18);
		}			
	}	
}
