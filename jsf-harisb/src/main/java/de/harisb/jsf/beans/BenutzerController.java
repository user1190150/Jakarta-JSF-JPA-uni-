package de.harisb.jsf.beans;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class BenutzerController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private BenutzerVerwaltung benutzerVerwaltung;
	private Benutzer aktuellerBenutzer;
	//Dieses Attribut ist zum Zwischenspeichern des Benutzernamen.
	//1. Attribut zum Zwischenspeichern des Benutzernamens im Controller hinzufügen.
	private String benutzername;
	
	
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
	
	public String getBenutzername() {
		return benutzername;
	}
	
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
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
	
	//2. Listener-Methode im Controller zum Abfangen des PostValidate-Events implementiert (ZWISCHENSPEICHERN)
	public void postValidateName(ComponentSystemEvent event) throws AbortProcessingException {
		
		UIInput temp = (UIInput) event.getComponent();		
		
		this.benutzername = (String) temp.getValue();
		System.out.println("SystemEvent abgefangen. Benutzername: " + this.benutzername + " Zwischengespeichert.");
	}
	
	//4. Im Passwort-Validator des Controllers anhand des gespeicherten Attributs(benutzername) validieren.
	public void validatePassword(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		List<Benutzer> bliste = benutzerVerwaltung.getBenutzerList();
		for (Benutzer b : bliste) {
			Benutzer temp = new Benutzer(this.benutzername, (String) value);
			if(b.equals(temp)) 
				return;
		} throw new ValidatorException(new FacesMessage("Login falsch!"));
		
	}
	

}
