package applicationV1.modele;

import java.util.HashMap;
import java.util.Map;

public class RessourcesDeBase {

	private Map<Ressources,Integer> ressourcesBase;
	private Ressources bois;
	private Ressources fer;
	private Ressources fraise;
	private Ressources pierre;
	private Ressources pommeDeTerre;
	private Ressources viandesDeCreatures;
	private Ressources pommeDeTerreCuite;
	private Ressources viandesDeCreaturesCuite;
	
	public RessourcesDeBase() {
		this.ressourcesBase=new HashMap<>();
		this.ressourcesBase.put("bois", 0);
		this.ressourcesBase.put("fer", 0);
		this.ressourcesBase.put("fraise", 2);
		this.ressourcesBase.put("pierre", 0);
		this.ressourcesBase.put("pommeDeTerre", 2);
		this.ressourcesBase.put("viandesDeCreatures", 0);
		this.ressourcesBase.put("pommeDeTerreCuite", 0);
		this.ressourcesBase.put("viandesDeCreaturesCuite", 0);
	}
	
	

	public Map<Ressources,Integer> getRessourcesBase() {
		return ressourcesBase;
	}

	public void setRessourcesBase(Map<Ressources,Integer> ressourcesBase) {
		this.ressourcesBase = ressourcesBase;
	}

	// ajoute l'objet dans la liste
	public void ajouterRessources(Ressources r) {
		this.ressourcesBase.put(r, this.ressourcesBase.get(r)+1);
	}
	
	
	// supprime l'objet de la list
	public void supprimmeRessources(Ressources r) {
		this.ressourcesBase.put(r, this.ressourcesBase.get(r)-1);
	}
	
	// dit si l'objet est dans la list
	public boolean contientRessources(Ressources r) {
		return this.ressourcesBase.get(r)>0;
	}

}
