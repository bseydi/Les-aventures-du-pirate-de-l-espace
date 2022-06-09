package controleur;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import applicationV1.modele.Environnement;
import applicationV1.modele.fonctionnalités.Range;
import applicationV1.vue.ArbreVue;
import applicationV1.modele.fonctionnalités.Collisions;
import applicationV1.modele.Personnage;
import applicationV1.modele.PnjCraft;
import applicationV1.modele.Terrain;
import applicationV1.vue.InventaireVue;
import applicationV1.vue.PersonnageVue;
import applicationV1.vue.PnjCraftVue;
import applicationV1.vue.PommeDeTerreVue;
import applicationV1.vue.RessourcesDeBaseVue;
import applicationV1.vue.TerrainVue;
import applicationV1.vue.VieVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

public class Controleur implements Initializable {
	
	Environnement env;
	
	TerrainVue terrainVue;
	PersonnageVue personnageVue;

	InventaireVue inventaireVue;
	
	PnjCraftVue pnjVue;
	
	ArbreVue arbrevue1;
	ArbreVue arbrevue2;
	ArbreVue arbrevue3;
	
	PommeDeTerreVue pommeDeTerreVue;

	VieVue vieVue;

	RessourcesDeBaseVue ressourcesDeBaseVue;

	private Timeline gameLoop;

	private int temps;
	private int temps2;
	private int temps3;
	private int posYInit;
	private boolean remettreDirection0 = false; // remet la direction à 0 au bout d'un certain temps.

	private int direction = 0;
	private boolean sauter = false;

	@FXML
	private ImageView fermerPopUp;
	
	@FXML
	private Pane popUpCraft;
	
	@FXML
	private TextField repMenu;
	
	@FXML
	private TilePane terrainJeu;

	@FXML
	private Pane panneauJeu;

	@FXML
	private Pane placeCoeur;

	@FXML
	private Label labelBois;

	@FXML
	private Label labelFer;

	@FXML
	private Label labelPierre;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		
		this.env = new Environnement();
		
		this.pnjVue = new PnjCraftVue(panneauJeu, this.env.getPnj());
		
		this.terrainVue = new TerrainVue(this.env.getPersonnage(), terrainJeu, this.env.getTerrain());
		this.personnageVue = new PersonnageVue(panneauJeu,this.env.getPersonnage());
		this.vieVue = new VieVue(placeCoeur,this.env.getPersonnage().pointdeVieProperty());
		
		this.ressourcesDeBaseVue = new RessourcesDeBaseVue(this.env.getPersonnage(),labelBois,labelFer,labelPierre);
		this.env.getPersonnage().pointdeVieProperty().addListener((o, oldVal, newVal) -> { vieVue.afficheCoeur();});
		
		this.arbrevue1 = new ArbreVue(panneauJeu,this.env.getArbre1(),this.env.getPersonnage());
		this.arbrevue2 = new ArbreVue(panneauJeu,this.env.getArbre2(),this.env.getPersonnage());
		this.arbrevue3 = new ArbreVue(panneauJeu,this.env.getArbre3(),this.env.getPersonnage());
		
		this.pommeDeTerreVue = new PommeDeTerreVue(panneauJeu, this.env.getPommeDeTerre());
		
		this.inventaireVue = new InventaireVue(panneauJeu, this.env.getPersonnage());

		initAnimation();
		gameLoop.play();
		try {
			this.terrainVue.creerTerrainJeu();
			this.vieVue.afficheCoeur();
			this.ressourcesDeBaseVue.afficheRessources();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.personnageVue.perso();

		this.pnjVue.pnj();
	
	}	

	private void initAnimation() {
		gameLoop = new Timeline();
		temps=0;
		temps2 = 0;
		temps3=0;

		posYInit=0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame (Duration.seconds(0.017),(ev ->{						
			/*if (remettreDirection0 = true) {
				temps2++;
				if (!sauter && !this.env.getC1().blocDessous(this.env.getPersonnage().getX(), this.env.getPersonnage().getY())) {
					if (temps2%20==0) {
						direction = 0;
						temps2 = 0;
						remettreDirection0 = false;
					}
				}
			}*/	
			
			
			if (!sauter) {
				if (this.env.getC1().blocDessous(this.env.getPersonnage().getX(), this.env.getPersonnage().getY())) {			
					if(direction == 1) {
						this.env.getPersonnage().setY(this.env.getPersonnage().getY()+2);
						this.env.getPersonnage().setX(this.env.getPersonnage().getX()+2);
						if (this.env.getPersonnage().getY() == posYInit-2) {
							direction = 0;
						}
					} else if (direction == 2) {
						this.env.getPersonnage().setY(this.env.getPersonnage().getY()+2);
						this.env.getPersonnage().setX(this.env.getPersonnage().getX()-2);
						if (this.env.getPersonnage().getY() == posYInit-2) {
							direction = 0;
						}
					}else {
						this.env.getPersonnage().setY(this.env.getPersonnage().getY()+2);
					}				
				}
			}			
			if (sauter) {				
				if(direction == 1) {
					this.env.getPersonnage().setY(this.env.getPersonnage().getY()-2);
					this.env.getPersonnage().setX(this.env.getPersonnage().getX()+1);
				} else if (direction == 2) {
					this.env.getPersonnage().setY(this.env.getPersonnage().getY()-2);
					this.env.getPersonnage().setX(this.env.getPersonnage().getX()-1);
				}else {
					this.env.getPersonnage().setY(this.env.getPersonnage().getY()-2);
				}
				temps++;
			}

			if(temps%20==0) {
				temps = 0 ;
				sauter = false;
			}
			if(temps3%200==0) {
				temps = 0 ;
				sauter = false;
				if(this.env.getArbre1().getArbreProperty().intValue()==2) {
					this.env.getArbre1().changerArbre();
	        		arbrevue1.afficherArbre();
				}
				if(this.env.getArbre2().getArbreProperty().intValue()==2) {
					this.env.getArbre2().changerArbre();
	        		arbrevue2.afficherArbre();
				}
				if(this.env.getArbre3().getArbreProperty().intValue()==2) {
					this.env.getArbre3().changerArbre();
	        		arbrevue3.afficherArbre();
				}
			}
			temps3++;
		})
				);
		gameLoop.getKeyFrames().add(kf);	
	}

	@FXML
	void toucheAppuyée(KeyEvent event) {		
		if(event.getCode()==KeyCode.D) {
			if (!this.env.getC1().blocDessous(this.env.getPersonnage().getX(), this.env.getPersonnage().getY())) {
				if (this.env.getC1().blocDroit(this.env.getPersonnage().getX(), this.env.getPersonnage().getY())) {
					direction = 1;				
					this.env.getPersonnage().seDeplacerADroite();
					remettreDirection0 = true;
				}
			} 
		}
		else if(event.getCode()==KeyCode.Q) {
			if (!this.env.getC1().blocDessous(this.env.getPersonnage().getX(), this.env.getPersonnage().getY())) {
				if (this.env.getC1().blocGauche(this.env.getPersonnage().getX(), this.env.getPersonnage().getY())) {
					direction = 2;
					this.env.getPersonnage().seDeplacerAGauche(); 
					remettreDirection0 = true;
				}
			} 
		}
		
		else if(event.getCode()==KeyCode.Z) {   		
			if (!this.env.getC1().blocDessous(this.env.getPersonnage().getX(), this.env.getPersonnage().getY())) {
				sauter = true;
				posYInit = this.env.getPersonnage().getY();
			}	
		}else if(event.getCode()==KeyCode.S) {   		
			direction = 0;			
		}else if(event.getCode()==KeyCode.W) {   		
			inventaireVue.changerItems(1);

		}else if(event.getCode()==KeyCode.X) {   		
			inventaireVue.changerItems(2);	

		}else if(event.getCode()==KeyCode.C) { 
			inventaireVue.changerItems(3);	
		}else if(event.getCode()==KeyCode.SPACE && Range.rangeToPnj(this.env.getPersonnage(),this.env.getPnj())) {
			popUpCraft.setVisible(!popUpCraft.isVisible());
			
			
		}

		else if(event.getCode()==KeyCode.B) {
			popUpCraft.setVisible(true);
		System.out.println(this.env.getPersonnage().getPointDeVie());
		}	
		else if(event.getCode()==KeyCode.L) {
		System.out.println(this.env.getFraise().getQuantiteProperty());
		if(arbrevue1.changerArbre() && this.env.getArbre1().getArbreProperty().intValue()==1) {
			this.env.getArbre1().changerArbre();
    		arbrevue1.afficherArbre();
   			this.env.getFraise().setQuantiteProperty(this.env.getFraise().getQuantiteProperty().intValue()+1);
   		}else if(arbrevue2.changerArbre() && this.env.getArbre2().getArbreProperty().intValue()==1) {
			this.env.getArbre2().changerArbre();
			arbrevue2.afficherArbre();
   			this.env.getFraise().setQuantiteProperty(this.env.getFraise().getQuantiteProperty().intValue()+1); 			
		}else if(arbrevue3.changerArbre() && this.env.getArbre3().getArbreProperty().intValue()==1) {
			this.env.getArbre3().changerArbre();
			arbrevue3.afficherArbre();
			this.env.getFraise().setQuantiteProperty(this.env.getFraise().getQuantiteProperty().intValue()+1);
   		}
		System.out.println(this.env.getFraise().getQuantiteProperty());
		
	}

	}		
	@FXML
	void fermerPopUp () {
		popUpCraft.setVisible(false);
		panneauJeu.requestFocus();
	}
	@FXML
	void confirmer () {

		 this.env.getPnj().dialogue(this.env.getPersonnage(),Integer.parseInt(repMenu.getText()));
		 fermerPopUp();
	}


		
		 
}		


