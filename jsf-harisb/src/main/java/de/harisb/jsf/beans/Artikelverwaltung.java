package de.harisb.jsf.beans;

import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

@Named
@ApplicationScoped
public class Artikelverwaltung implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Artikel> artikelList;
	
	public Artikelverwaltung() {
		System.out.println("Artikelverwaltung Konstruktor aufgerufen");
		artikelList = new ArrayList<>();
		
		artikelList.add( new Artikel(1, "QuantumScope X7",
				"Der QuantumScope X7 ist ein Meisterwerk moderner"
				+ " Technologie und Design. Dieser tragbare Scanner wurde speziell"
				+ " für die multidimensionale Analyse entwickelt und verfügt über"
				+ " eine holografische Benutzeroberfläche, die Umgebungsdaten in Echtzeit"
				+ " visualisiert. Sein ultraleichtes Gehäuse besteht aus Titan-Polymer, das"
				+ " Langlebigkeit und Eleganz kombiniert. Der QuantumScope X7 ist perfekt"
				+ " für Forscher und Ingenieure, die komplexe Materialien, Umgebungen oder"
				+ " Strukturen auf Molekularebene untersuchen müssen.",
				"QuantumScope.jpg"));
		artikelList.add( new Artikel(2, "EnviroProbe Z1",
				"Der EnviroProbe Z1 revolutioniert die Erkundung natürlicher Umgebungen."
				+ " Mit einem integrierten Bio- und Geo-Analysetool kann er Luftqualität,"
				+ " Bodenzusammensetzung und organische Lebensformen in Sekundenschnelle"
				+ " scannen. Das ergonomische Design mit einem rotierenden 360°-Sensor"
				+ " garantiert maximale Flexibilität in jeder Situation. Perfekt für "
				+ "Archäologen, Wissenschaftler oder Umweltschutzteams.",
				"EnviroProbe Z1.jpg"));
		artikelList.add( new Artikel(3, "LuminaTracer G9",
				"Der LuminaTracer G9 ist ein optischer Scanner der nächsten Generation,"
				+ " der auf Lichtwellenanalyse basiert. Sein innovativer Prismensensor erfasst"
				+ " Materialdichten, Farbnuancen und sogar verborgene energetische Signaturen."
				+ " Der eingebaute AI-Analysemotor liefert präzise Berichte direkt auf das"
				+ " projizierte HUD (Heads-Up-Display). Besonders geeignet für Kunstrestauratoren,"
				+ " Sicherheitskräfte und High-Tech-Designer.",
				"LuminaTracer G9.jpg"));
		artikelList.add( new Artikel(4, "SpectraMap V2",
				"Mit dem SpectraMap V2 wird die Visualisierung unsichtbarer Strahlen Realität."
				+ " Dieser Scanner kann Infrarot-, Ultraviolett- und Röntgenwellen in Echtzeit"
				+ " analysieren und in ein verständliches Bild umwandeln. Das intuitive"
				+ " Touchscreen-Display und die KI-gestützte Objekterkennung machen"
				+ " ihn unverzichtbar für Mediziner, Ingenieure und Rettungskräfte.",
				"SpectraMap V2.jpg"));
		artikelList.add( new Artikel(5, "OmniScan HyperNova",
				"Der OmniScan HyperNova ist ein universeller Scanner, der keine Wünsche offen lässt. Er kombiniert"
				+ " spektrale Analyse, chemische Identifikation und thermografische Kartierung in einem Gerät. Mit"
				+ " seinem robusten Design hält er extremen Temperaturen und Bedingungen stand, wodurch er ideal"
				+ " für Weltraummissionen, industrielle Inspektionen oder"
				+ " Katastrophenhilfe geeignet ist. Ein wahres",
				"OmniScan HyperNova.jpg"));
		System.out.println("Artikel hinzugefügt: " + artikelList.size());
	}
	
	public List<Artikel> getArtikelList() {
		return artikelList;
	}
	public void setArtikelList(List<Artikel> artikelList) {
		this.artikelList = artikelList;
	}
	
	//Entfernt Artikel aus der List
	public void entferneArtikel(Artikel artikel) {
		artikelList.remove(artikel);
	}
	
	
}
