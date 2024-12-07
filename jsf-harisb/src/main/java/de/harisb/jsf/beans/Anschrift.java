package de.harisb.jsf.beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

@Named
@RequestScoped
public class Anschrift {
	private String name;
	private String strasse;
	private int hausnummer;
	private String plz;
	private String ort;
	
	public Anschrift() {
		this.name = "MarsTech Solutions GmbH";
		this.strasse = "Valles Marineris Boulevard";
		this.hausnummer = 42;
		this.plz = "MRS-0042";
		this.ort = "Ares City, Mars";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public int getHausnummer() {
		return hausnummer;
	}
	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	
}





