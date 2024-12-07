package de.harisb.jsf.beans;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArtikelverwaltungTest {
	
	private Artikelverwaltung artikelverwaltung;
	
	@BeforeEach
	public void setUp() {
		artikelverwaltung = new Artikelverwaltung();
		
		//Initialisieren der Liste mit Test Artikeln
		artikelverwaltung.getArtikelList().add(new Artikel(1,"firstArtikel","abc","jpg1"));
		artikelverwaltung.getArtikelList().add(new Artikel(2,"secondArtikel","def","jpg2"));
		artikelverwaltung.getArtikelList().add(new Artikel(3,"thirdArtikel","ghi","jpg3"));
	}

	@Test
	public void testArtikelverwaltung() {
		Artikelverwaltung testartikelverwaltung = new Artikelverwaltung();
		assertNotNull(testartikelverwaltung);
	}
	
	@Test
	public void testEntferneArtikel() {
		//Welcher Artikel soll entfernt werden?
		Artikel artikelZumEntfernen = artikelverwaltung.getArtikelList().get(2);
		//Methode zum entfernen vom Artikel wird aufgerufen.
		artikelverwaltung.entferneArtikel(artikelZumEntfernen);
		//Liste ueberpruefen ob der Artikel geloescht wurde
		List<Artikel> aktuelleListe = artikelverwaltung.getArtikelList();
		assertEquals(7, aktuelleListe.size(), "Die Liste sollte 7 Artikel haben!");
		assertFalse(aktuelleListe.contains(artikelZumEntfernen), "Der Artikel sollte nicht in der Liste sein!");		
		
	}
	

}
