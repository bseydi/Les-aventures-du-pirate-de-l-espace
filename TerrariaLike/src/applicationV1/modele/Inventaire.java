package applicationV1.modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import applicationV1.modele.nourriture.Fraise;
import applicationV1.modele.nourriture.Nourriture;
import applicationV1.modele.nourriture.PommeDeTerre;
import applicationV1.modele.nourriture.PommeDeTerreCuite;
import applicationV1.modele.nourriture.ViandeDeCreature;
import applicationV1.modele.nourriture.ViandeDeCreatureCuite;

public class Inventaire {
    
    private Map<String, Integer> outils;
    private Map<String, Integer> objets;
    private ArrayList<Nourriture> listeNourriture;
    private Nourriture n;
        
    public Inventaire () {
        this.outils = new HashMap<>();        
        this.outils.put("EpéeEnPierre", 0);
        this.outils.put("EpéeEnFer", 0);
        this.outils.put("HacheEnPierre", 0);
        this.outils.put("PiocheEnBois", 0);
        this.outils.put("PiocheEnPierre", 0);
        this.outils.put("Pelle", 1);
        
        this.objets = new HashMap<>();
        this.objets.put("Planche", 0);
        this.objets.put("MurDepierre", 0);
        this.objets.put("FeuDeCamp", 0);
        this.objets.put("Pièges", 0);
        
        this.listeNourriture = new ArrayList<Nourriture>();
        this.listeNourriture.add(this.n = new Fraise());
        this.listeNourriture.add(this.n = new ViandeDeCreature());
        this.listeNourriture.add(this.n = new ViandeDeCreatureCuite());
        this.listeNourriture.add(this.n = new PommeDeTerre());
        this.listeNourriture.add(this.n = new PommeDeTerreCuite());
   
    }
    
    public void ajouterOutils(String outils) {
        this.outils.replace(outils, this.outils.get(outils) + 1);    
    }
    
    public void supprimerOutils(String outils) {
        this.outils.replace(outils, this.outils.get(outils) - 1);
    }
    
    public void ajouterObjets(String objets, int valeur) {
        this.objets.replace(objets, this.objets.get(objets) + valeur);    
    }
    
    public void supprimerObjets(String objets) {
        this.objets.replace(objets, this.objets.get(objets) - 1);
    }
    
    public int nbOutils (String pelle) {
    	return this.outils.get(pelle);
    }
    
    public void ajouterNourriture(Nourriture n) {
    	this.listeNourriture.add(n);
    }
    
    public void retirerNourriture(Nourriture n) {
    	this.listeNourriture.remove(n);  
    }
    
    public ArrayList<Nourriture> getListeNourriture() {
    	return this.listeNourriture;
    }

}    
