package applicationV1.modele.nourriture;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import applicationV1.modele.Personnage;
import applicationV1.vue.PommeDeTerreVue;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PommeDeTerreList {

	private Pane panneauJeu;
	private Nourriture pommeDeTerre;
	private PommeDeTerreVue pommeDeTerreVue;
	private ArrayList<Integer> listCoordonneeImgPommeDeTerre;
	private ArrayList<ImageView> listImgPommeDeTerre;
	private int indice,indice2;
	private Personnage personnage;
	
	
	
	public PommeDeTerreList(Pane panneauJeu, Personnage personnage, Nourriture pommeDeTerre, PommeDeTerreVue pommeDeTerreVue) {
		// TODO Auto-generated constructor stub
		this.panneauJeu=panneauJeu;
		this.personnage=personnage;
		this.pommeDeTerre=pommeDeTerre;
		this.pommeDeTerreVue=pommeDeTerreVue;
		this.listCoordonneeImgPommeDeTerre=new ArrayList<Integer>();
    	listCoordonneeImgPommeDeTerre.add(pommeDeTerre.getX());
    	listCoordonneeImgPommeDeTerre.add(pommeDeTerre.getY());
    	this.listImgPommeDeTerre=new ArrayList<ImageView>();
    	this.listImgPommeDeTerre.add(pommeDeTerreVue.img());
    	this.indice=0;// indice du tableau
    	this.indice2=0;
	}

	
	
	public void ajouterImagePommeDeTerre() {
		
		listCoordonneeImgPommeDeTerre.add(pommeDeTerreVue.getPommeDeTerre2().getX());
    	listCoordonneeImgPommeDeTerre.add(pommeDeTerreVue.getPommeDeTerre2().getY());
    	this.listImgPommeDeTerre.add(pommeDeTerreVue.img());
	}
	
	public boolean PommeDeTerreACotePerso() {
		for(int i=0;i<getListCoordonneeImgPommeDeTerre().size();i=i+2) {
			
			if((Math.abs(getListCoordonneeImgPommeDeTerre().get(i)-personnage.getX()))<=60 && (Math.abs(getListCoordonneeImgPommeDeTerre().get(i+1)-personnage.getY()))<=60) {
				this.indice=i;
				return true;
			}
		}
		if(personnage.getX()<pommeDeTerre.getX()+40 && personnage.getX()>pommeDeTerre.getX()-15 && personnage.getY()<pommeDeTerre.getY()+40 && personnage.getY()>pommeDeTerre.getY()-15)
			return true;
		return false;
	}
	
	public ArrayList<Integer> getListCoordonneeImgPommeDeTerre() {
		return listCoordonneeImgPommeDeTerre;
	}
	public ArrayList<ImageView> getListImgPommeDeTerre() {
		return listImgPommeDeTerre;
	}
	
	// permet de savoir si l'image de la pomme de terre se trouve au même endroit que la souris
	public void srupprimerPommeDeTerre() {
		if(indice==0) {
			panneauJeu.getChildren().remove(listImgPommeDeTerre.get(indice));
			listImgPommeDeTerre.remove(indice);
			listCoordonneeImgPommeDeTerre.remove(indice);
			listCoordonneeImgPommeDeTerre.remove(indice);
		}
		else {
			indice2=(indice/2);
			panneauJeu.getChildren().remove(listImgPommeDeTerre.get(indice2));
			listImgPommeDeTerre.remove(indice2);
			listCoordonneeImgPommeDeTerre.remove(indice);
			listCoordonneeImgPommeDeTerre.remove(indice);
		}
		indice2=0;
		
	}
}
