package de.harisb.jsf.beans;

import java.io.Serializable;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("artikelController")
@SessionScoped
public class ArtikelController implements Serializable {

	@Inject
	private Artikelverwaltung artikelverwaltung;

	private Artikel aktuellerArtikel;
	private Artikel neuerArtikel;
	private static final long serialVersionUID = 1L;
	private int index = 0;

	// Standard-Konstruktor
	public ArtikelController() {
		System.out.println("ArtikelController Konstruktor aufgerufen");
	}

	// Methode, die nach dem Konstruktor aufgerufen wird und sicherstellt, dass die
	// Artikelverwaltung verfügbar ist
	@PostConstruct
	public void init() {
		if (artikelverwaltung != null &&
			artikelverwaltung.getArtikelList() != null && 
			!artikelverwaltung.getArtikelList().isEmpty())
			
			aktuellerArtikel = artikelverwaltung.getArtikelList().get(0);			
	}

	// Getter für aktuellerArtikel, wichtig für die Anzeige in der View
	public Artikel getAktuellerArtikel() {
		return aktuellerArtikel;
	}
	public void setAktuellerArtikel(Artikel aktuellerArtikel) {
		this.aktuellerArtikel = aktuellerArtikel;
	}
	
	public Artikel getNeuerArtikel() {
		if(neuerArtikel == null)
			this.neuerArtikel = new Artikel();
		return this.neuerArtikel;
	}
	public void setNeuerArtikel(Artikel neuerArtikel) {
		this.neuerArtikel = neuerArtikel;
	}

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	public String speichern() {
		artikelverwaltung.saveArtikel(neuerArtikel);
		return "startseite?faces-redirect=true";
	}
	
	public String addArtikel() {
		return "edit?faces-redirect=true";
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

	// Benutzerdefinierte Validierung der gtin fuer Artikel
	public void validateGtin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String id = (String) value; // Eingabe vom Benutzer
		int chiper = Artikel.berechnePruefsumme(id); // Prüfsumme wird berechnet

		if (!id.endsWith(String.valueOf(chiper))) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
					id + " ist keine gültige GTIN. " + " Erwartete Prüfziffer: " + chiper, ""));

		}
	}

}




