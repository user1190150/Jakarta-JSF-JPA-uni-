package de.harisb.jsf.beans;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class BenutzerController implements Serializable {
	
	@Inject
	private BenutzerVerwaltung benutzerVerwaltung;
	private Benutzer aktuellerBenutzer;
	private static final long serialVersionUID = 1L;
	
	public BenutzerController() {
		System.out.println("Benutzer: Konstruktor wurde aufgerufen!");
		aktuellerBenutzer = new Benutzer();
	}
	
	public Benutzer getAktuellerBenutzer() {
		return aktuellerBenutzer;
	}
	
	public void setAktuellerBenutzer(Benutzer aktuellerBenutzer) {
		this.aktuellerBenutzer = aktuellerBenutzer;
	}
	
	public String login() {
		List<Benutzer> benutzerListeDurchlaufen = benutzerVerwaltung.getBenutzerList();
		System.out.println("Login Methode: Hier in der Liste sind: " + benutzerListeDurchlaufen.size());
		for(Benutzer b : benutzerListeDurchlaufen) {
			if(b.equals(this.aktuellerBenutzer)) {
				System.out.println("Gefunden!");
				return "startseite?faces-redirect=true";
			}
		}
		System.out.println("Nicht Gefunden!");
		return "login.xhtml";
	}

}
