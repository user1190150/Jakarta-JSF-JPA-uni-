package de.harisb.jsf.beans;

import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import jakarta.enterprise.context.RequestScoped;

@Named
@RequestScoped
public class Artikel implements Serializable {
	private int id;
	private String name;
	private String beschreibung;
	private String bild;
	private double preis;
	private double bewertung;
	private double energie;
	private Date verfuegbarAb;
	private static final long serialVersionUID = 1L;
	
	public Artikel() {
		verfuegbarAb = getDefaultVerfuegbarkeitsDatum();
		this.setBewertung(0);
		this.setEnergie(0);
		System.out.println(verfuegbarAb + " ist das aktuell verfuegbare Datum.");
	}
	
	public Artikel(int id, String name, String beschreibung, String bild, double preis) {
		this();
		this.id = id;
		this.name = name;
		this.beschreibung = beschreibung;
		this.bild = bild;
		this.preis = preis;
	}
	
	public Artikel(int id, String name, String beschreibung, String bild,double preis, Date verfuegbarAb) {
		this(id, name, beschreibung, bild, preis);
		this.verfuegbarAb = verfuegbarAb;
	}
	
	public Date getDefaultVerfuegbarkeitsDatum() {		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		return calendar.getTime();		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public String getBild() {
		return bild;
	}
	public void setBild(String bild) {
		this.bild = bild;
	}
	public Date getVerfuegbarAb() {
		return verfuegbarAb;
	}
	public void setVerfuegbarAb(Date verfuegbarAb) {
		this.verfuegbarAb = verfuegbarAb;
	}

	public double getBewertung() {
		return bewertung;
	}

	public void setBewertung(double bewertung) {
		this.bewertung = bewertung;
	}

	public double getEnergie() {
		return energie;
	}

	public void setEnergie(double energie) {
		this.energie = energie;
	}
	
	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	
}
