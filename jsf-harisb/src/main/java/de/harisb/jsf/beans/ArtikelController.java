package de.harisb.jsf.beans;

import java.io.Serializable;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("artikelController")
@SessionScoped
public class ArtikelController implements Serializable {

    @Inject
    private Artikelverwaltung artikelverwaltung;

    private Artikel aktuellerArtikel;
    private static final long serialVersionUID = 1L;
    private int index = 0;

    // Standard-Konstruktor
    public ArtikelController() {
        System.out.println("ArtikelController Konstruktor aufgerufen");
    }

    // Methode, die nach dem Konstruktor aufgerufen wird und sicherstellt, dass die Artikelverwaltung verfügbar ist
    @PostConstruct
    public void init() {
        if (artikelverwaltung != null && artikelverwaltung.getArtikelList() != null && !artikelverwaltung.getArtikelList().isEmpty()) {
            aktuellerArtikel = artikelverwaltung.getArtikelList().get(0);
            System.out.println("Erster Artikel gesetzt: " + aktuellerArtikel.getName());
        } else {
            System.out.println("Artikelverwaltung ist nicht initialisiert oder leer");
        }
    }

    // Getter für aktuellerArtikel, wichtig für die Anzeige in der View
    public Artikel getAktuellerArtikel() {
        if (aktuellerArtikel == null) {
            System.out.println("aktuellerArtikel ist null");
        } else {
            System.out.println("aktuellerArtikel: " + aktuellerArtikel.getName());
        }
        return aktuellerArtikel;
    }

    public void setAktuellerArtikel(Artikel aktuellerArtikel) {
        this.aktuellerArtikel = aktuellerArtikel;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    //Speichere Artikel
    public String speichereArtikel() {
    	if(aktuellerArtikel != null) {
    		System.out.println("Artikel ist nicht NULL!");
    	}
    	return "startseite?faces-redirect=true";
    }

    // Navigation: Vorwärts
    public void vor() {
        if (index < artikelverwaltung.getArtikelList().size() - 1) {
            index++;
            aktuellerArtikel = artikelverwaltung.getArtikelList().get(index);
            System.out.println("Vorwärts navigiert zu Artikel: " + aktuellerArtikel.getName());
        } else {
            System.out.println("Kein weiterer Artikel vorhanden");
        }
    }

    // Navigation: Zurück
    public void zurueck() {
        if (index > 0) {
            index--;
            aktuellerArtikel = artikelverwaltung.getArtikelList().get(index);
            System.out.println("Zurück navigiert zu Artikel: " + aktuellerArtikel.getName());
        } else {
            System.out.println("Kein vorheriger Artikel vorhanden");
        }
    }
    
}
