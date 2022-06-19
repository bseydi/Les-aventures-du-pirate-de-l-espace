package applicationV1.modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import applicationV1.modele.fonctionnalités.GestionErreur;

class PnjCraftTest {
    
	private Personnage perso;
	private GestionErreur gn;
	private PnjCraft pnj;
	
    // ----------------------------------------------------------------------------------------------------------------------
    // Pour effectuer ces tests, des prérequis doivent etre fais dans les classe Ressources et Inventaires
    // Dans la classe Ressources, augmenter mettre la valeur des Property Bois,Pierre,Fer à 10 lors de leurs déclaration !
    // Dans la classe Inventaire, changer la valeur en 0 des outils lorsqu'ils sont ajoutter dans la liste d'outils, ex : this.outils.put("PiocheEnPierre", 0);
    // ----------------------------------------------------------------------------------------------------------------------

    @Test
    void craftEpeeFerTest () {
        perso = new Personnage (0,0,0, gn);
        pnj.dialogue(perso,2);
        assertEquals(8,perso.getRessource().getNbFer());
        assertEquals(9,perso.getRessource().getNbBois());
        assertEquals(1,perso.getInventaire().getNbOutils("EpéeEnFer"));
    }

    @Test
    void craftPiocheBoisTest () {
        
        perso = new Personnage (0,0,0, gn);
        pnj.dialogue(perso,4);
        assertEquals(5,perso.getRessource().getNbBois());
        assertEquals(1,perso.getInventaire().getNbOutils("PiocheEnBois"));
    }

    @Test
    void craftPiochePierreTest () {
        
        perso = new Personnage (0,0,0, gn);
        pnj.dialogue(perso,5);
        assertEquals(7,perso.getRessource().getNbPierre());
        assertEquals(8,perso.getRessource().getNbBois());
        assertEquals(1,perso.getInventaire().getNbOutils("PiocheEnPierre"));
    }


}
