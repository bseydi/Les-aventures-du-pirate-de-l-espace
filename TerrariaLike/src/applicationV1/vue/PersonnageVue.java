package applicationV1.vue;


import applicationV1.modele.Environnement;
import applicationV1.modele.Personnage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PersonnageVue {
	
	private Environnement env;
	private Pane panneauJeu;
	private Personnage personnage;
	private Image imagePerso[];
	private ImageView r;
	private int i = 0, i2 = 0;
		
	public PersonnageVue(Pane panneauJeu, Personnage personnage, Environnement env) {
		this.panneauJeu = panneauJeu;
		this.personnage = personnage;
		creerImagePerso();
	}

	public void creerImagePerso() {
		this.imagePerso = new Image[16];
		this.imagePerso[0] = new Image ("./image/Astronaute/astronaut.png");
		this.imagePerso[1] = new Image("./image/Astronaute/astronautinv.png");
		this.imagePerso[2] = new Image("./image/Astronaute/courir1.png");
		this.imagePerso[3] = new Image("./image/Astronaute/courir1inv.png");
		this.imagePerso[4] = new Image("./image/Astronaute/courir2.png");
		this.imagePerso[5] = new Image("./image/Astronaute/courir2inv.png");
		this.imagePerso[6] = new Image("./image/Astronaute/courir3.png");
		this.imagePerso[7] = new Image("./image/Astronaute/courir3inv.png");
		this.imagePerso[8] = new Image("./image/Astronaute/courir4.png");
		this.imagePerso[9] = new Image("./image/Astronaute/courir4inv.png");
		this.imagePerso[10] = new Image("./image/Astronaute/courir5.png");
		this.imagePerso[11] = new Image("./image/Astronaute/courir5inv.png");
		this.imagePerso[12] = new Image("./image/Astronaute/courir6.png");
		this.imagePerso[13] = new Image("./image/Astronaute/courir6inv.png");
		this.imagePerso[14] = new Image("./image/Astronaute/saut.png");
		this.imagePerso[15] = new Image("./image/Astronaute/sautinv.png");
	}
	
	
	public void perso () {
		r = new ImageView(this.imagePerso[0]);	// Creation de notre sprite
		r.translateXProperty().bind(personnage.xProperty());
    	r.translateYProperty().bind(personnage.yProperty());
   	 	panneauJeu.getChildren().add(r);
	}
	
	public void FaireApparaîtrePerso() { // Fait apparaître et disparaître la vue du personnage.
		r.setVisible(!r.isVisible());
	}
	
	public void animationPerso (){
		if (personnage.getDirection() == 1) {
			switch(i) {
			case 0:
				r.setImage(this.imagePerso[2]);
				break;
			case 1:
				r.setImage(this.imagePerso[4]);
				break;
			case 2:
				r.setImage(this.imagePerso[6]);
				break;
			case 3:
				r.setImage(this.imagePerso[8]);
				break;
			case 4:
				r.setImage(this.imagePerso[10]);
				break;
			case 5:
				r.setImage(this.imagePerso[12]);
				break;

			default: break;
			}	
			i++;
			if (i > 5) {
				i = 0;
			}
		} else if (personnage.getDirection() == 2) {
			if (personnage.isSauter() ) {
				r.setImage(this.imagePerso[15]);
			}
			switch(i2) {
			case 0:
				r.setImage(this.imagePerso[3]);
				break;
			case 1:
				r.setImage(this.imagePerso[5]);
				break;
			case 2:
				r.setImage(this.imagePerso[7]);
				break;
			case 3:
				r.setImage(this.imagePerso[9]);
				break;
			case 4:
				r.setImage(this.imagePerso[11]);
				break;
			case 5:
				r.setImage(this.imagePerso[13]);
				break;

			default: break;
			}	
			i2++;
			if (i2 > 5) {
				i2 = 0;
			}
		}
	}
}