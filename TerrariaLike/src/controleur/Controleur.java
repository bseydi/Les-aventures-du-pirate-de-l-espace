package controleur;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import applicationV1.modele.Acteur;
import applicationV1.modele.Creature1;
import applicationV1.modele.Creature2;
import applicationV1.modele.Environnement;
import applicationV1.modele.fonctionnalités.GestionErreur;
import applicationV1.modele.nourriture.PommeDeTerreList;
import applicationV1.modele.Personnage;
import applicationV1.vue.ArbreVue;
import applicationV1.vue.BarNourritureVue;
import applicationV1.vue.EstMort;
import applicationV1.vue.FuséeVue;
import applicationV1.vue.Creature1Vue;
import applicationV1.vue.Creature2Vue;
import applicationV1.vue.InventaireVue;
import applicationV1.vue.PersonnageVue;
import applicationV1.vue.PnjCraftVue;
import applicationV1.vue.PommeDeTerreVue;
import applicationV1.vue.RessourcesDeBaseVue;
import applicationV1.vue.TerrainVue;
import applicationV1.vue.VieVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
	private PommeDeTerreList pommeDeTerreList;
	
	private VieVue vieVue;
	private BarNourritureVue bNourriture;

	private RessourcesDeBaseVue ressourcesDeBaseVue;
	
	
	private Creature1Vue creature1Vue;
	private Creature2Vue creature2Vue;
	
	private FuséeVue fuséeVue;
	private boolean finDuJeu = false;

	private Timeline gameLoop;
	private int temps;
	private int temps2;
	private int temps3;
	private int temps4;
	private int temps5;

	private EstMort estMort;
	
	private GestionErreur gn;  // gestionnaire d'erreur affiche toutes les erreurs


	@FXML
    private BorderPane root;
	
	@FXML
	private ImageView fermerPopUp;
	
	@FXML
    private ImageView fermerPopUp1;
	
	@FXML
	private Pane popUpCraft;
	
	@FXML
	private Pane popUpFeuDeCamp;
	
	@FXML
	private Pane popUpFinDeJeu;
	
	@FXML
    private Pane popUpErreur;
	
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
	
	@FXML
	private Pane popUpFusée;
    
    @FXML
    private Label textErreur;
    
    @FXML
	private ImageView fermerPopUpFusée;

	@FXML
	private Button BoutonRéparerFusée;

	@FXML
	private Button BoutonPartir;

	@FXML
	private Button boutonArreter;

	//@FXML			bouton rejouer retirer car n'est pas fonctionnel
	//private Button boutonRejouer;
    
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image image = new Image("./image/background.jpg");
		
		BackgroundImage arrièrePlan = new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		
		Background background = new Background(arrièrePlan);
		this.panneauJeu.setBackground(background);
		
		this.popUpCraft.setVisible(false);
		this.popUpFeuDeCamp.setVisible(false);
		this.popUpFusée.setVisible(false);
		this.BoutonPartir.setVisible(false);
		this.popUpFinDeJeu.setVisible(false);
		this.popUpErreur.setVisible(false);
		
		this.gn = new GestionErreur(this.textErreur, this.popUpErreur);
		this.env = new Environnement(this.gn);
		
		this.pnjVue = new PnjCraftVue(panneauJeu, this.env.getPnj());
		this.terrainVue = new TerrainVue(this.env, this.terrainJeu);
		this.personnageVue = new PersonnageVue(this.panneauJeu,this.env.getPersonnage(), this.env);
		this.vieVue = new VieVue(placeCoeur,this.env.getPersonnage().pointdeVieProperty());
		this.bNourriture = new BarNourritureVue(this.placeBar,this.env.getPersonnage().pointdeNourritureProperty());
		this.ressourcesDeBaseVue = new RessourcesDeBaseVue(this.env.getPersonnage(),labelBois,labelFer,labelPierre);
				
		//Bind de la vie et de la bar de nourriture pour pouvoir etre modifier à l'affichage
		this.env.getPersonnage().pointdeVieProperty().addListener((o, oldVal, newVal) -> { this.vieVue.afficheCoeur();});
		this.env.getPersonnage().pointdeNourritureProperty().addListener((o, oldVal, newVal) -> { this.bNourriture.afficheNourritureBar();});
		
		this.creature1Vue = new Creature1Vue(panneauJeu, this.env);
		this.creature2Vue = new Creature2Vue(panneauJeu, this.env);
		
		
		this.arbrevue1 = new ArbreVue(panneauJeu, this.env.getArbre1(), this.env.getPersonnage());
		this.arbrevue2 = new ArbreVue(panneauJeu, this.env.getArbre2(), this.env.getPersonnage());
		this.arbrevue3 = new ArbreVue(panneauJeu, this.env.getArbre3(), this.env.getPersonnage());
		
		this.pommeDeTerreVue = new PommeDeTerreVue(panneauJeu, this.env.getPersonnage().getInventaire().getListeNourriture().get(3),env.getPersonnage());
		this.pommeDeTerreList = new PommeDeTerreList(panneauJeu, env.getPersonnage(),this.env.getPersonnage().getInventaire().getListeNourriture().get(3), pommeDeTerreVue);
		
		this.inventaireVue = new InventaireVue(panneauJeu, this.env.getPersonnage());
		this.estMort=new EstMort(this.env.getPersonnage(), popUpFinDeJeu);
		this.env.getPersonnage().pointdeVieProperty().addListener(estMort);		
		this.fuséeVue = new FuséeVue (panneauJeu, env);
		
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
		this.creature1Vue.creature1();
		this.creature2Vue.creature2();
		this.fuséeVue.créerFusée();

		root.addEventHandler(KeyEvent.KEY_PRESSED, new ControleurClavier(env, inventaireVue, popUpCraft, popUpFusée, popUpFeuDeCamp, personnageVue));
	}	

	
	
	private void initAnimation() {
		gameLoop = new Timeline();
		temps=0;
		temps2=0;
		temps3=0;
		temps4=0;
		temps5=1;
		

		this.env.getPersonnage().setPosYInit(0);
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		

		KeyFrame kf = new KeyFrame (Duration.seconds(0.017),(ev ->{						
			Personnage perso = this.env.getPersonnage();
			Creature1 creature = this.env.getCreature1();
			Creature2 creature2 = this.env.getCreature2();
			
			if (perso.isRemettreDirection0()) { // Remet la direction du personnage à 0(ni droite ni gauche) au bout d'un certain temps.
				temps2++;
				if(!perso.isSauter() && !this.env.getC1().blocDessous(perso.getX(), perso.getY())) {
					if (temps2%40==0) {
						perso.setDirection(0);
						personnageVue.animationPerso();
						perso.setRemettreDirection0(false);
					}							
				}	
			}


			creature2.bouger(this.env.getC2());

			if (temps%40 ==0) {  
				creature2.attaquer(perso);
			}
			if (this.env.getFusée().isEnvol()) {
				this.env.getFusée().décollage();
			}
			
			
			/*------------------------- saut et gravité du personnage ------------------------------------*/
			if (!perso.isSauter()) {
				Acteur.tomber(perso,this.env.getC1(), perso.getDirection(), perso.getPosYInit());
			}			
			if (perso.isSauter()) {	
				perso.saut(this.env.getC1(), perso.getDirection());
				perso.setTemps(perso.getTemp()+1); //temps++
			}
			
			if(perso.getTemp()%25==0) {
				perso.setTemps(0);
				perso.setSauter(false);
			}
			/*------------------------- saut et gravité de la créature 1 ------------------------------------*/	
			if(!creature.isSauter()) {
				Acteur.tomber(creature,this.env.getC2(),creature.getDirection(),creature.getPosYInit());
			}
			
			if (creature.isSauter()) {
				creature.saut(this.env.getC2(),0);
				creature.setTemps(creature.getTemp()+1); //temps++
			}
			
			if(creature.getTemp()%25==0) {
				creature.setTemps(0);
				creature.setSauter(false);
			}
				
			/*-----------------------------gravité de la créature 2 -----------------------------------------*/				
				Acteur.tomber(creature2,this.env.getC2(),creature2.getDirection(),creature2.getPosYInit());
			
			/*---------------------------------    Evénements -------------------------------------------------*/		
			if (finDuJeu) {
				temps4++;
				if (temps4 > 200) {
					this.popUpFinDeJeu.setVisible(true);
				}
			}

			if (temps > 4000) {
				creature.suivre(perso, this.env.getC2());
			}

			Acteur.limiteDeMap(perso);
			Acteur.limiteDeMap(creature);
			Acteur.limiteDeMap(this.env.getCreature2());
			
			if(temps3%400==0) {
				//rajoute une pomme de terre sur le terrain
				temps3 = 0 ;
				pommeDeTerreVue.afficherPommeDeTerre();
				pommeDeTerreList.ajouterImagePommeDeTerre();
			}
			temps3++;
			if(temps4%20==0) {
				// regarde si on est a coté d'une pomme de terre
				if(pommeDeTerreList.PommeDeTerreACotePerso()) {
					pommeDeTerreList.srupprimerPommeDeTerre();
					//appeller methode pour ajouter une pomme de terre
					this.env.getPersonnage().getInventaire().ajouterNourriture(4);
				}
			}
			temps4++;
			
			temps++;
			
			if(temps5%800 == 0) {
				this.env.getPersonnage().perdNourriture(5);
				temps5 = 0;
			}
			temps5++;

		})
				);
		gameLoop.getKeyFrames().add(kf);	
	}
		
	@FXML
	void fermerPopUp () {	// Appelé par le joueur depuis l'interface du pnj des crafts et pour fermer  la popUp Erreur dans gestionErreur
		this.popUpCraft.setVisible(false);
		this.popUpFeuDeCamp.setVisible(false);
		this.popUpFusée.setVisible(false);
		this.popUpErreur.setVisible(false);
		this.panneauJeu.requestFocus();
	}
	
	@FXML
	void confirmer () {		// Appelé par le joueur depuis l'interface du pnj des crafts
		 this.env.getPnj().dialogue(this.env.getPersonnage(),Integer.parseInt(repMenu.getText()));
		 fermerPopUp();
	}
	
	@FXML
	void RéparerFusée(ActionEvent event) { // Fait apparaître la fusée et le bouton "EntrerEtPartir".
		this.popUpFusée.setVisible(false);
		this.popUpCraft.setVisible(false);
		if (this.env.getPersonnage().getRessource().getNbFer() >= 10) {				
			this.fuséeVue.FaireApparaîtreFusée();
			this.BoutonPartir.setVisible(true);
			this.panneauJeu.requestFocus();	
			this.env.getPersonnage().getRessource().retirerFer(10);
		}
	}
	
	@FXML
	void EntrerEtPartir(ActionEvent event) { // Le personnage entre dans la fusée et s'en va.		
			this.BoutonPartir.setVisible(false);
			this.personnageVue.FaireApparaîtrePerso();
			this.env.getFusée().setEnvol(true);
			this.fuséeVue.fuséeEnFeu();
			this.finDuJeu = true;
			this.panneauJeu.requestFocus();		
	}

	@FXML
	void cuirePatate () {	// Appelé par le joueur depuis l'interface du feu de camp
		if (this.env.getPersonnage().getInventaire().getListeNourriture().get(3).getQuantiteProperty() >= 1 ) {
			this.env.getPersonnage().getInventaire().ajouterNourriture(4);
			this.env.getPersonnage().getInventaire().retirerNourriture(3);
		}
	}
	
	@FXML
	void cuireViande () {	// Appelé par le joueur depuis l'interface du feu de camp 
		if (this.env.getPersonnage().getInventaire().getListeNourriture().get(1).getQuantiteProperty() >= 1 ) {
			this.env.getPersonnage().getInventaire().ajouterNourriture(2);
			this.env.getPersonnage().getInventaire().retirerNourriture(1);			
		}	 
	}
	
	@FXML
	void rejouer(ActionEvent event) {
		//réinitielise tous les paramettre pour rejouer
		
		this.env.getPersonnage().setPointDeVie(100);

		this.env.getPersonnage().setPointDeNourriture(100);
		this.env.getPersonnage().getInventaire().getListeNourriture().get(0).setQuantiteProperty(0);
		this.env.getPersonnage().getInventaire().getListeNourriture().get(1).setQuantiteProperty(0);
		this.env.getPersonnage().getInventaire().getListeNourriture().get(2).setQuantiteProperty(0);
		this.env.getPersonnage().getInventaire().getListeNourriture().get(3).setQuantiteProperty(0);
		this.env.getPersonnage().getInventaire().getListeNourriture().get(4).setQuantiteProperty(0);

		this.env.getPersonnage().getInventaire().getOutils().replace("EpéeEnPierre", 0);
		this.env.getPersonnage().getInventaire().getOutils().replace("EpéeEnFer", 0);
		this.env.getPersonnage().getInventaire().getOutils().replace("HacheEnPierre",1);
		this.env.getPersonnage().getInventaire().getOutils().replace("PiocheEnBois", 1);
		this.env.getPersonnage().getInventaire().getOutils().replace("PiocheEnPierre",1);
		this.env.getPersonnage().getInventaire().getOutils().replace("Pelle",1);

		this.env.getPersonnage().getInventaire().getObjets().replace("Planche", 5);
		this.env.getPersonnage().getInventaire().getObjets().replace("MurDePierre",5);
		this.env.getPersonnage().getInventaire().getObjets().replace("FeuDeCamp",1);
		this.env.getPersonnage().getInventaire().getObjets().replace("Pièges",0);
		
		this.finDuJeu = false;
		this.popUpFinDeJeu.setVisible(false);
		this.personnageVue.FaireApparaîtrePerso();
		panneauJeu.requestFocus();
	}

	@FXML
	void arreter(ActionEvent event) {
		//ferme la fennetre de jeu
		Platform.exit();
	}
}		
