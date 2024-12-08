package de.harisb.jsf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class BenutzerVerwaltung implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Benutzer> benutzerList;
	
	public BenutzerVerwaltung() {
		System.out.println("BenutzerVerwaltung: Konstruktor wurde aufgerufen");
		
		benutzerList = new ArrayList<Benutzer>();
		
		benutzerList.add(new Benutzer("Max90", "passwordmax"));
		benutzerList.add(new Benutzer("Elena85", "passwordelena"));
		benutzerList.add(new Benutzer("Miriam90", "passwordmiriam"));
		benutzerList.add(new Benutzer("Mike19", "passwordmike"));
		System.out.println("Benutzerliste hat: " + benutzerList.size() + " Benutzer.");
	}
	
	public List<Benutzer> getBenutzerList() {
		return benutzerList;
	}
	
	public void setBenutzerList(List<Benutzer> benutzerList) {
		this.benutzerList = benutzerList;
	}
	
}




