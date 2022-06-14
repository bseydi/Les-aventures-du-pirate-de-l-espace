package applicationV1.modele;

import java.util.HashMap;
import java.util.Map;

public class Inventaire {
    
    private Map<String, Integer> outils;
    private Map<String, Integer> objets;
        
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
    }
    
    public void ajouterOutils(String outils) {
        this.outils.replace(outils, this.outils.get(outils) + 1);    
    }
    
    public void supprimerOutils(String outils) {
        this.outils.replace(outils, this.outils.get(outils) - 1);
    }
    
    public void ajouterObjets(String objets) {
        this.objets.replace(objets, this.objets.get(objets) + 1);    
    }
    
    public void supprimerObjets(String objets) {
        this.objets.replace(objets, this.objets.get(objets) - 1);
    }
    
    public int nbOutils(String outil) {
    	return this.outils.get(outil);
    }
    
    public int nbObjets(String objet) {
    	return this.objets.get(objet);
    }     
}    
