package de.harisb.jsf.beans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArtikelTest {

	@Test
	void testArtikel() {
		Artikel artikel = new Artikel(); // Standard-Konstruktor testen
        assertNotNull(artikel); // Prüfen, ob das Artikel-Objekt nicht null ist
	}

	@Test
	void testGetName() {
		Artikel artikel = new Artikel();
        artikel.setName("Testartikel");
        assertEquals("Testartikel", artikel.getName()); // Prüfen, ob getName() den gesetzten Wert zurückgibt
	}

	@Test
	void testSetName() {
		Artikel artikel = new Artikel();
        artikel.setName("Testartikel");
        assertEquals("Testartikel", artikel.getName()); // Prüfen, ob der Wert korrekt gesetzt wurde
	}

}
