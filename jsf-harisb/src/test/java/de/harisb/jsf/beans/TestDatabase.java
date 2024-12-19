package de.harisb.jsf.beans;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestDatabase {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("marstech");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Artikel artikel = new Artikel();
		
		artikel.setName("Testartikel");
		artikel.setBeschreibung("Ein Testartikel");
		artikel.setPreis(10.99);
		
		em.persist(artikel);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		System.out.println("Artikel gespeichert! Erfolg!");
		
		
	}

}
