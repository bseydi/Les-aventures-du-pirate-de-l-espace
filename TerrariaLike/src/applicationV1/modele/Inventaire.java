package applicationV1.modele;

import java.util.HashMap;
import java.util.Map;

public class Inventaire {
    
    private Map<String, Integer> outils;
    private Map<String, Integer> objets;
    private Map<String, Integer> nourritures;

        
    public Inventaire () {
        this.outils = new HashMap<>();        
        this.outils.put("EpéeEnPierre", 0);
        this.outils.put("EpéeEnFer", 0);
        this.outils.put("HacheEnPierre", 1);
        this.outils.put("PiocheEnBois", 1);
        this.outils.put("PiocheEnPierre", 1);
        this.outils.put("Pelle", 1);
        
        this.objets = new HashMap<>();
        this.objets.put("Planche", 5);
        this.objets.put("MurDePierre", 5);
        this.objets.put("FeuDeCamp", 1);
        this.objets.put("Pièges", 0);

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
    
    public int nbOutils (String outils) {
    	return this.outils.get(outils);
    }
    
    public void ajouterNourriture(String nourriture, int valeur) {
    	this.nourritures.replace(nourriture, this.nourritures.get(nourriture) + valeur);
    }
    
    public void supprimerNourriture (String nourriture, int valeur ) {
    	this.nourritures.replace(nourriture, this.nourritures.get(nourriture) - 1);
    }  
    public int getNbNourritures(String nourriture) {
		return nourritures.get(nourriture);
	}
    
   public int getNbBloc (String bloc) {
	   return objets.get(bloc);
   }
}    
