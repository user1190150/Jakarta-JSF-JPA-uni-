package de.harisb.jsf.beans;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;

@Entity
@Named
@RequestScoped
public class Bewertung implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBewertung;
	private String kommentar;
	private int sterne;	
	
	@ManyToOne
	private Artikel artikel;
		
	public Bewertung() {}

	

	public int getIdBewertung() {
		return idBewertung;
	}



	public void setIdBewertung(int idBewertung) {
		this.idBewertung = idBewertung;
	}



	public Artikel getArtikel() {
		return artikel;
	}



	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}



	public String getKommentar() {
		return kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

	public int getSterne() {
		return sterne;
	}

	public void setSterne(int sterne) {
		this.sterne = sterne;
	}
	
	
}
