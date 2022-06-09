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
		
		img1 = new ImageView(new Image("./image/BlocFer.png"));
		panneauJeu.getChildren().add(img1);
		img1.setTranslateX(192);
    	img1.setTranslateY(18);
    	
    	img2 = new ImageView(new Image("./image/BlocFer.png"));  	
		panneauJeu.getChildren().add(img2);
		img2.setTranslateX(240);
    	img2.setTranslateY(18); 
    	
    	img3  = new ImageView(new Image("./image/pelle.jpeg"));  	
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
				img = new ImageView(new Image("./image/BlocFer.png"));
			} else if (typeItems == 2) {
				img = new ImageView(new Image("./image/BlocFer.png"));
			} else if (typeItems == 3) {
				img = new ImageView(new Image("./image/pelle.jpeg"));
			}	
			break;
		case 2 :
			if (typeItems == 1) {
				img = new ImageView(new Image("./image/Pierre.png"));
			} else if (typeItems == 2) {
				img = new ImageView(new Image("./image/Pierre.png"));
			} else if (typeItems == 3) {
				img = new ImageView(new Image("./image/epeePierre.jpg"));
			}			
			break;
		case 3 :
			if (typeItems == 1) {
				img = new ImageView(new Image("./image/PommeDeTerre.png"));
			} else if (typeItems == 2) {
				img = new ImageView(new Image("./image/PommeDeTerre.png"));
			} else if (typeItems == 3) {
				img = new ImageView(new Image("./image/epeeFer.jpg"));
			}		
			break;
		case 4 :
			if (typeItems == 1) {
				img = new ImageView(new Image("./image/Fraise.png"));
			} else if (typeItems == 2) {
				img = new ImageView(new Image("./image/Fraise.png"));
			} else if (typeItems == 3) {
				img = new ImageView(new Image("./image/piocheEnBois.jpg"));
			}		
			break;
		case 5 :
			if (typeItems == 1) {
				img = new ImageView(new Image("./image/Bois(1).png"));
			} else if (typeItems == 2) {
				img = new ImageView(new Image("./image/Bois(1).png"));
			} else if (typeItems == 3) {
				img = new ImageView(new Image("./image/pioche.jpg"));
			}	
			break;
		case 6 :
			if (typeItems == 1) {
				img = new ImageView(new Image("./image/ressource_bois.png"));	
			} else if (typeItems == 2) {
				img = new ImageView(new Image("./image/ressource_bois.png"));
			} else if (typeItems == 3) {
				img = new ImageView(new Image("./image/hache.jpeg"));
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