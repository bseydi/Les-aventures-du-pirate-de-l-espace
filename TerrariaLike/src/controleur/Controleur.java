package controleur;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import applicationV1.modele.Acteur;
import applicationV1.modele.Creature1;
import applicationV1.modele.Environnement;
import applicationV1.modele.Personnage;
import applicationV1.vue.ArbreVue;
import applicationV1.vue.BarNourritureVue;
import applicationV1.vue.Creature1Vue;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

public class Controleur implements Initializable {
	
	private Environnement env;
	
	private TerrainVue terrainVue;
	private PersonnageVue personnageVue;

	private InventaireVue inventaireVue;
	
	private PnjCraftVue pnjVue;
	
	private ArbreVue arbrevue1;
	private ArbreVue arbrevue2;
	private ArbreVue arbrevue3;
	
	private PommeDeTerreVue pommeDeTerreVue;

	private VieVue vieVue;
	private BarNourritureVue bNourriture;

	private RessourcesDeBaseVue ressourcesDeBaseVue;

	private Creature1Vue creature1Vue;
	

	private Timeline gameLoop;
	private int temps;
	private int temps2;
	private int temps3;	

	@FXML
    private BorderPane root;
	
	@FXML
	private ImageView fermerPopUp;
	
	@FXML
	private Pane popUpCraft;
	
	@FXML
	private Pane popUpFeuDeCamp;
	
	@FXML
	private TextField repMenu;
	
	@FXML
	private TilePane terrainJeu;

	@FXML
	private Pane panneauJeu;

	@FXML
	private Pane placeCoeur;
	
   @FXML
    private Pane placeBar;

	@FXML
	private Label labelBois;

	@FXML
	private Label labelFer;

	@FXML
	private Label labelPierre;
	
	@Override		
	public void initialize(URL location, ResourceBundle resources) {
		Image image = new Image("./image/background.jpg");		
		BackgroundImage arrièrePlan = new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		
		Background background = new Background(arrièrePlan);
		panneauJeu.setBackground(background);
		
		popUpCraft.setVisible(false);
		popUpFeuDeCamp.setVisible(false);

		this.env = new Environnement();
		
		this.pnjVue = new PnjCraftVue(this.panneauJeu, this.env.getPnj());
		
		this.terrainVue = new TerrainVue(this.env.getPersonnage(), this.terrainJeu, this.env.getTerrain());
		this.personnageVue = new PersonnageVue(this.panneauJeu,this.env.getPersonnage());
		this.vieVue = new VieVue(placeCoeur,this.env.getPersonnage().pointdeVieProperty());
		this.bNourriture = new BarNourritureVue(this.placeBar,this.env.getPersonnage().pointdeNourritureProperty());
		this.ressourcesDeBaseVue = new RessourcesDeBaseVue(this.env.getPersonnage(),labelBois,labelFer,labelPierre);
		
		this.env.getPersonnage().pointdeVieProperty().addListener((o, oldVal, newVal) -> { vieVue.afficheCoeur();});
		this.env.getPersonnage().pointdeNourritureProperty().addListener((o, oldVal, newVal) -> { bNourriture.afficheNourritureBar();});

		this.pommeDeTerreVue = new PommeDeTerreVue(panneauJeu, this.env.getPommeDeTerre());
		
		this.inventaireVue = new InventaireVue(panneauJeu, this.env.getPersonnage());

		initAnimation();
		gameLoop.play();
		try {
			this.terrainVue.creerTerrainJeu();
			this.vieVue.afficheCoeur();
			this.bNourriture.afficheNourritureBar();
			this.ressourcesDeBaseVue.afficheRessources();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.personnageVue.perso();
		this.pnjVue.pnj();

			 
		creature1Vue = new Creature1Vue(panneauJeu, this.env.getCreature1());
		creature1Vue.creature1();
		root.addEventHandler(KeyEvent.KEY_PRESSED, new ControleurClavier(env, inventaireVue, popUpCraft));
	}	

	private void initAnimation() {
		gameLoop = new Timeline();
		temps=0;
		temps2=0;
		temps3=0;

		this.env.getPersonnage().setPosYInit(0);
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame (Duration.seconds(0.017),(ev ->{	
			Personnage perso = this.env.getPersonnage();
			Creature1 creature = this.env.getCreature1();
			
			if (perso.isRemettreDirection0()) {//Remet la direction du perso à 0 au bout d'un certain temps.
				temps++;
				if (!perso.isSauter() && !this.env.getC1().blocDessous(perso.getX(), perso.getY())) {
					if (temps%40==0) {
						perso.setDirection(0);
						temps = 0;
						perso.setRemettreDirection0(false);
					}
				}
			}		
			
			//creature.suivre(perso, this.env.getC2());
			
		/*------------------------- saut et gravité du personnage ------------------------------------*/
			if (!perso.isSauter()) {
				Acteur.tomber(perso,this.env.getC1(), perso.getDirection(), perso.getPosYInit());
			}			
			if (perso.isSauter()) {	
				perso.saut(perso.getDirection());
				perso.setTemps(perso.getTemp()+1);
			}
			
			if(perso.getTemp()%20==0) {
				perso.setTemps(0);
				perso.setSauter(false);
			}
		/*------------------------- saut et gravité de la créature ------------------------------------*/	
			if(!creature.isSauter()) {
				Acteur.tomber(creature,this.env.getC2(),creature.getDirection(),creature.getPosYInit());
			}
			
			if (creature.isSauter()) {
				creature.saut(creature.getDirection());
				creature.setTemps(creature.getTemp()+1); //temps++
			}
			
			if(creature.getTemp()%20==0) {
				creature.setTemps(0);
				creature.setSauter(false);
			}		
			
			if(temps3%200==0) {
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
	void fermerPopUp () {		// Appelé par le joueur depuis l'interface du pnj des crafts
		popUpCraft.setVisible(false);
		popUpFeuDeCamp.setVisible(false);
		panneauJeu.requestFocus();
	}
	
	@FXML
	void confirmer () {			// Appelé par le joueur depuis l'interface du pnj des crafts
		 this.env.getPnj().dialogue(this.env.getPersonnage(),Integer.parseInt(repMenu.getText()));
		 fermerPopUp();
	}

	
	@FXML
	void cuirePatate () {		// Appelé par le joueur depuis l'interface du feu de camp
		if (this.env.getPersonnage().getInventaire().getListeNourriture().get(3).getQuantiteProperty() >= 1 ) {
			this.env.getPersonnage().getInventaire().ajouterNourriture(4);
			this.env.getPersonnage().getInventaire().retirerNourriture(3);
		}
	}
	
	@FXML
	void cuireViande () {		// Appelé par le joueur depuis l'interface du feu de camp 
		if (this.env.getPersonnage().getInventaire().getListeNourriture().get(1).getQuantiteProperty() >= 1 ) {
			this.env.getPersonnage().getInventaire().ajouterNourriture(2);
			this.env.getPersonnage().getInventaire().retirerNourriture(1);			
		}	 
	}
}		
