package de.harisb.jsf.beans;

import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

@Named
@ApplicationScoped
public class Artikelverwaltung implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("marstech");
	private List<Artikel> artikelList = new ArrayList<>();
	
	public Artikelverwaltung() {
		System.out.println("Artikelverwaltung Konstruktor aufgerufen");				
		System.out.println("Artikel hinzugefügt: " + artikelList.size());
	}
	
	public void saveArtikel(Artikel neuerArtikel) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
	        t.begin();
	        em.merge(neuerArtikel); // Verwende merge statt persist
	        t.commit();
	    } catch (Exception e) {
	        if (t.isActive()) {
	            t.rollback();
	        }
	        throw e;
	    } finally {
	        em.close();
	    }
	}
	
	public List<Artikel> getArtikelList() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT a FROM Artikel a");
		artikelList = q.getResultList();
		em.close();
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
