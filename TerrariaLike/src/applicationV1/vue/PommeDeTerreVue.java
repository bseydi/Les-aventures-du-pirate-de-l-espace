package applicationV1.vue;

import java.util.ArrayList;
import java.util.Random;

import applicationV1.modele.Personnage;
import applicationV1.modele.nourriture.PommeDeTerre;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PommeDeTerreVue {

	private PommeDeTerre pommeDeTerre;
	private Pane panneauJeu;
	private ImageView img=new ImageView();
	private int xMin,xMax,yMin,yMax;
	private int nbX,nbY;
	private Random randomX = new Random();
	private Random randomY = new Random();
	private ArrayList<Integer> listImgPommeDeTerre;
	
	public PommeDeTerreVue(Pane panneauJeu,PommeDeTerre pommeDeTerre) {
		this.panneauJeu=panneauJeu;
		this.pommeDeTerre=pommeDeTerre;
		this.img=new ImageView(new Image("./image/PommeDeTerre.png"));
		panneauJeu.getChildren().add(img);
		this.xMin=0; // valeur minimal de x
		this.xMax=500; // valeur maximal de x
		this.yMin=400; // valeur minimal de y
		this.yMax=600; // valeur maximal de y
		
		nbX=xMin+randomX.nextInt(xMax-xMin); // valeur aléatoire de x pour positionner l'image sur le plateau de jeu
		nbY=yMin+randomY.nextInt(yMax-yMin); // valeur aléatoire de y pour positionner l'image sur le plateau de jeu
		//System.out.println(nbX);
		//System.out.println(nbY);
		img.setTranslateX(nbX);
    	img.setTranslateY(nbY);
    	this.listImgPommeDeTerre=new ArrayList<Integer>();
    	listImgPommeDeTerre.add(nbX);
    	listImgPommeDeTerre.add(nbY);
    	
	}
	public ImageView img() {
		return img;
	}
	
	public void supprimerPommeDeTerre() {
		panneauJeu.getChildren().remove(img);
	}
	
	// permet de savoir si l'image de la pomme de terre se trouve au même endroit que la souris
		public static boolean pouvoirSrupprimerPommeDeTerre(PommeDeTerreVue pommeDeTerreVue,Personnage perso) {
			for(int i=0;i<pommeDeTerreVue.getListImgPommeDeTerre().size();i=i+2) {
				if((pommeDeTerreVue.getListImgPommeDeTerre().get(i)-perso.getX())<=70 && (pommeDeTerreVue.getListImgPommeDeTerre().get(i+1)-perso.getY())<=70) {
					return true;
				}
			}
			return false;
		}
		
	public void afficherPommeDeTerre() {
		this.img=new ImageView(new Image("./image/PommeDeTerre.png"));
		panneauJeu.getChildren().add(img);
		nbX=xMin+randomX.nextInt(xMax-xMin);
		nbY=yMin+randomY.nextInt(yMax-yMin);
		//System.out.println(nbX);
		//System.out.println(nbY);
		img.setTranslateX(nbX);
    	img.setTranslateY(nbY);
    	listImgPommeDeTerre.add(nbX);
    	listImgPommeDeTerre.add(nbY);
	}
	
	public int coordonneeImgX() {
		return (int)img.getLayoutX();
	}
	
	public int coordonneeImgY() {
		return (int)img.getLayoutY();
	}

	public int getNbX() {
		return nbX;
	}

	public int getNbY() {
		return nbY;
	}
	public ArrayList<Integer> getListImgPommeDeTerre() {
		return listImgPommeDeTerre;
	}
	
}