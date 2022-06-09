package controleur;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import applicationV1.modele.fonctionnalités.Arbre;
import applicationV1.modele.fonctionnalités.Collisions;
import applicationV1.modele.fonctionnalités.Range;
import applicationV1.modele.nourriture.Fraise;
import applicationV1.modele.nourriture.PommeDeTerre;
import applicationV1.modele.Personnage;
import applicationV1.modele.PnjCraft;
import applicationV1.modele.Terrain;
import applicationV1.vue.ArbreVue;
import applicationV1.vue.InventaireVue;
import applicationV1.vue.PersonnageVue;
import applicationV1.vue.PnjCraftVue;
import applicationV1.vue.PommeDeTerreVue;
import applicationV1.vue.RessourcesDeBaseVue;
import applicationV1.vue.TerrainVue;
import applicationV1.vue.VieVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

public class Controleur implements Initializable {
	Terrain terrain;
	Personnage personnage;

	TerrainVue terrainVue;
	PersonnageVue personnageVue;

	InventaireVue inventaireVue;
	PnjCraft pnj;
	PnjCraftVue pnjVue;
	
	ArbreVue arbrevue1;
	ArbreVue arbrevue2;
	ArbreVue arbrevue3;
	Arbre arbre1;
	Arbre arbre2;
	Arbre arbre3;
	
	Fraise fraise;
	
	PommeDeTerre pommeDeTerre;
	PommeDeTerreVue pommeDeTerreVue;

	Collisions c1;

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
		personnage = new Personnage(300,290,5);
		pnj = new PnjCraft(2,338);
		pnjVue = new PnjCraftVue(panneauJeu, pnj);
		this.terrain = new Terrain ();
		terrainVue = new TerrainVue(personnage, terrainJeu, terrain);
		personnageVue = new PersonnageVue(panneauJeu,personnage);
		vieVue = new VieVue(placeCoeur,personnage.pointdeVieProperty());
		c1 = new Collisions(personnage, terrain);
		ressourcesDeBaseVue = new RessourcesDeBaseVue(personnage,labelBois,labelFer,labelPierre);
		personnage.pointdeVieProperty().addListener((o, oldVal, newVal) -> { vieVue.afficheCoeur();});
		arbre1 = new Arbre(320,260);
		arbre2 = new Arbre(5,290);
		arbre3 = new Arbre(130,290);
		arbrevue1 = new ArbreVue(panneauJeu,arbre1,personnage);
		arbrevue2 = new ArbreVue(panneauJeu,arbre2,personnage);
		arbrevue3 = new ArbreVue(panneauJeu,arbre3,personnage);
		fraise = new Fraise();
		pommeDeTerre = new PommeDeTerre();
		pommeDeTerreVue = new PommeDeTerreVue(panneauJeu, pommeDeTerre);
		
		
		inventaireVue = new InventaireVue(panneauJeu, personnage);

		initAnimation();
		gameLoop.play();
		try {
			terrainVue.creerTerrainJeu();
			vieVue.afficheCoeur();
			ressourcesDeBaseVue.afficheRessources();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		personnageVue.perso();
		pnjVue = new PnjCraftVue(panneauJeu, pnj);

		pnjVue.pnj();
	
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
				if (!sauter && !c1.blocDessous(personnage.getX(), personnage.getY())) {
					if (temps2%20==0) {
						direction = 0;
						temps2 = 0;
						remettreDirection0 = false;
					}
				}
			}*/					
			if (!sauter) {
				if (c1.blocDessous(personnage.getX(), personnage.getY())) {			
					if(direction == 1) {
						personnage.setY(personnage.getY()+2);
						personnage.setX(personnage.getX()+2);
						if (personnage.getY() == posYInit-2) {
							direction = 0;
						}
					} else if (direction == 2) {
						personnage.setY(personnage.getY()+2);
						personnage.setX(personnage.getX()-2);
						if (personnage.getY() == posYInit-2) {
							direction = 0;
						}
					}else {
						personnage.setY(personnage.getY()+2);
					}				
				}
			}			
			if (sauter) {				
				if(direction == 1) {
					personnage.setY(personnage.getY()-2);
					personnage.setX(personnage.getX()+1);
				} else if (direction == 2) {
					personnage.setY(personnage.getY()-2);
					personnage.setX(personnage.getX()-1);
				}else {
					personnage.setY(personnage.getY()-2);
				}
				temps++;
			}

			if(temps%20==0) {
				temps = 0 ;
				sauter = false;
			}
			if(temps3%400==0) {
				temps = 0 ;
				sauter = false;
				if(arbre1.getArbreProperty().intValue()==2) {
					arbre1.changerArbre();
	        		arbrevue1.afficherArbre();
				}
				if(arbre2.getArbreProperty().intValue()==2) {
					arbre2.changerArbre();
	        		arbrevue2.afficherArbre();
				}
				if(arbre3.getArbreProperty().intValue()==2) {
					arbre3.changerArbre();
	        		arbrevue3.afficherArbre();
				}
				pommeDeTerreVue.afficherPommeDeTerre();
			}
			temps3++;
		})
				);
		gameLoop.getKeyFrames().add(kf);	
	}

	@FXML
	void toucheAppuyée(KeyEvent event) {		
		if(event.getCode()==KeyCode.D) {
			if (!c1.blocDessous(personnage.getX(), personnage.getY())) {
				if (c1.blocDroit(personnage.getX(), personnage.getY())) {
					direction = 1;				
					personnage.seDeplacerADroite();
					remettreDirection0 = true;
				}
			} 
		}
		else if(event.getCode()==KeyCode.Q) {
			if (!c1.blocDessous(personnage.getX(), personnage.getY())) {
				if (c1.blocGauche(personnage.getX(), personnage.getY())) {
					direction = 2;
					personnage.seDeplacerAGauche(); 
					remettreDirection0 = true;
				}
			} 
		}
		else if(event.getCode()==KeyCode.Z) {   		
			if (!c1.blocDessous(personnage.getX(), personnage.getY())) {
				sauter = true;
				posYInit = personnage.getY();
			}	
		}
		else if(event.getCode()==KeyCode.S) {   		
			direction = 0;			
		}
		else if(event.getCode()==KeyCode.W) {   		
			inventaireVue.changerItems(1);

		}
		else if(event.getCode()==KeyCode.X) {   		
			inventaireVue.changerItems(2);	

		}
		else if(event.getCode()==KeyCode.C) { 
			inventaireVue.changerItems(3);	
		}
		else if(event.getCode()==KeyCode.V) {
			popUpCraft.setVisible(false);
		}
		else if(event.getCode()==KeyCode.B) {
			popUpCraft.setVisible(true);
		}
		else if(event.getCode()==KeyCode.A) {
			personnage.perdVie();
			System.out.println(personnage.getPointDeVie());
    	} 
		else if(event.getCode()==KeyCode.E) {
			personnage.gagneVie();
			System.out.println(personnage.getPointDeVie());
		}	
		else if(event.getCode()==KeyCode.L) {
			if(arbrevue1.changerArbre() && arbre1.getArbreProperty().intValue()==1) {
				arbre1.changerArbre();
	    		arbrevue1.afficherArbre();
	   			fraise.setQuantiteProperty(fraise.getQuantiteProperty().intValue()+1);
			}
			else if(arbrevue2.changerArbre() && arbre2.getArbreProperty().intValue()==1) {
				arbre2.changerArbre();
				arbrevue2.afficherArbre();
	   			fraise.setQuantiteProperty(fraise.getQuantiteProperty().intValue()+1); 			
			}
			else if(arbrevue3.changerArbre() && arbre3.getArbreProperty().intValue()==1) {
				arbre3.changerArbre();
				arbrevue3.afficherArbre();
				fraise.setQuantiteProperty(fraise.getQuantiteProperty().intValue()+1);
	   		}
			else if(event.getCode()==KeyCode.M && Range.rangeToPommeDeTerre(pommeDeTerreVue, personnage)) {
				System.out.println("fhuihruhrg");
				pommeDeTerreVue.afficherPommeDeTerre();
			}
		}
	}		
	
	@FXML
	void confirmer () {
		 pnj.dialogue(personnage,Integer.parseInt(repMenu.getText()));
	}		
}
