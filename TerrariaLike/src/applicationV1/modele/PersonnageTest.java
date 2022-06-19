package applicationV1.modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import applicationV1.modele.fonctionnalités.GestionErreur;

class PersonnageTest {

	private Personnage personnage;
	private GestionErreur gn;

	@Test
	void testPerdNourriture() {
		personnage = new Personnage(300,290,5, gn);
		personnage.perdNourriture(10);
		assertEquals(90,personnage.getPointDeNourriture());
		personnage.perdNourriture(10);
		assertEquals(80,personnage.getPointDeNourriture());
		personnage.perdNourriture(20);
		assertEquals(60, personnage.getPointDeNourriture());
	}
	
	@Test
	void testManger() {
		personnage = new Personnage(300,290,5,gn);
		personnage.setPointDeNourriture(20);
		assertEquals(20,personnage.getPointDeNourriture());
		personnage.manger();
		assertEquals(30,personnage.getPointDeNourriture());
		personnage.manger();
		personnage.manger();
		assertEquals(50,personnage.getPointDeNourriture());
	}
	
	@Test
	void testPerdPointDeVie() {
		personnage = new Personnage(300,290,5, gn);
		personnage.perdVie();
		assertEquals(90,personnage.getPointDeVie());
		personnage.perdVie();
		personnage.perdVie();
		personnage.perdVie();
		assertEquals(60,personnage.getPointDeVie());
		personnage.perdVie();
		assertEquals(50,personnage.getPointDeVie());
		
	}
	
	@Test
	void testEstVivant() {
		personnage = new Personnage(300,290,5, gn);
		assertTrue(personnage.estVivant());
		personnage.setPointDeVie(80);
		assertTrue(personnage.estVivant());
		personnage.setPointDeVie(500);
		assertTrue(personnage.estVivant());
		personnage.setPointDeVie(25);
		assertTrue(personnage.estVivant());
		personnage.setPointDeVie(0);
		assertFalse(personnage.estVivant());
	}
	
	@Test
	void testGetPointDeVie() {
		personnage = new Personnage(300,290,5, gn);
		assertEquals(100,personnage.getPointDeVie());
		personnage.setPointDeVie(90);
		assertEquals(90,personnage.getPointDeVie());
		personnage.setPointDeVie(55);
		assertEquals(55,personnage.getPointDeVie());
	}
	
	@Test
	void testGetPointDeNourriture() {
		personnage = new Personnage(300,290,5,gn);
		assertEquals(100,personnage.getPointDeNourriture());
		personnage.setPointDeNourriture(12);
		assertEquals(12,personnage.getPointDeNourriture());
		personnage.setPointDeNourriture(45);
		assertEquals(45,personnage.getPointDeNourriture());
	}
}
