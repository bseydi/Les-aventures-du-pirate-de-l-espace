package applicationV1.modele.nourriture;


import java.util.ArrayList;
import applicationV1.modele.Personnage;
import applicationV1.vue.PommeDeTerreVue;
import javafx.scene.image.ImageView;
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
		
		this.listCoordonneeImgPommeDeTerre.add(this.pommeDeTerreVue.getPommeDeTerre2().getX());
    	this.listCoordonneeImgPommeDeTerre.add(this.pommeDeTerreVue.getPommeDeTerre2().getY());
    	this.listImgPommeDeTerre.add(pommeDeTerreVue.img());
	}
	
	public boolean PommeDeTerreACotePerso() {
		for(int i=0;i<getListCoordonneeImgPommeDeTerre().size();i=i+2) {
			
			if((Math.abs(getListCoordonneeImgPommeDeTerre().get(i)-this.personnage.getX()))<=60 && (Math.abs(getListCoordonneeImgPommeDeTerre().get(i+1)-personnage.getY()))<=60) {
				this.indice=i;
				return true;
			}
		}
		if(this.personnage.getX()<pommeDeTerre.getX()+40 && this.personnage.getX()>this.pommeDeTerre.getX()-15 && personnage.getY()<pommeDeTerre.getY()+40 && personnage.getY()>pommeDeTerre.getY()-15)
			return true;
		return false;
	}
	
	public ArrayList<Integer> getListCoordonneeImgPommeDeTerre() {
		return this.listCoordonneeImgPommeDeTerre;
	}
	public ArrayList<ImageView> getListImgPommeDeTerre() {
		return this.listImgPommeDeTerre;
	}
	
	// permet de savoir si l'image de la pomme de terre se trouve au même endroit que la souris
	public void srupprimerPommeDeTerre() {
		if(this.indice==0) {
			this.panneauJeu.getChildren().remove(this.listImgPommeDeTerre.get(this.indice));
			this.listImgPommeDeTerre.remove(this.indice);
			this.listCoordonneeImgPommeDeTerre.remove(this.indice);
			this.listCoordonneeImgPommeDeTerre.remove(this.indice);
		}
		else {
			this.indice2=(this.indice/2);
			this.panneauJeu.getChildren().remove(this.listImgPommeDeTerre.get(this.indice2));
			this.listImgPommeDeTerre.remove(this.indice2);
			this.listCoordonneeImgPommeDeTerre.remove(this.indice);
			this.listCoordonneeImgPommeDeTerre.remove(this.indice);
		}
		this.indice2=0;
		
	}
}
