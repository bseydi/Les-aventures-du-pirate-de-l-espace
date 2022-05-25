package applicationV1.modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RessourcesDeBase {

	private ArrayList<Ressources> listRessources;
	private Ressources bois;
	private Ressources fer;
	private Ressources fraise;
	private Ressources pierre;
	private Ressources pommeDeTerre;
	private Ressources viandesDeCreatures;
	private Ressources pommeDeTerreCuite;
	private Ressources viandesDeCreaturesCuite;
	
	public RessourcesDeBase() {
		listRessources =  new ArrayList<Ressources>();
		this.bois=new Bois();
		this.fer = new Fer();
		this.pierre = new Pierre();
		this.listRessources.add(bois);
		this.listRessources.add(fer);
		this.listRessources.add(fraise);
		this.listRessources.add(pierre);
		this.listRessources.add(pommeDeTerre);
		this.listRessources.add(viandesDeCreatures);
		this.listRessources.add(pommeDeTerreCuite);
		this.listRessources.add(viandesDeCreaturesCuite);
	}
	
	

	public ArrayList<Ressources> getRessourcesBase() {
		return listRessources;
	}

	public void setRessourcesBase(ArrayList<Ressources> listRessources) {
		this.listRessources = listRessources;
	}

	// ajoute l'objet dans la liste
	public void ajouterRessources(Ressources r) {
		this.listRessources.add(r);
	}
	
	
	// supprime l'objet de la list
	public void supprimmeRessources(Ressources r) {
		this.listRessources.remove(r);
	}
	
	// dit si l'objet est dans la list
	public boolean contientRessources(Ressources r) {
		return this.listRessources.contains(r);
	}

}
