package de.harisb.jsf.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class HelloBean {
    private String message;

    public HelloBean() {
        message = "Hallo, willkommen bei Jakarta EE!";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Aktion, die beim Klicken ausgeführt wird
    public void sayHello() {
        message = "Hallo von der Bean!"; // Nachricht ändert sich bei Aufruf
        System.out.println("sayHello() wurde aufgerufen"); // Konsolen-Ausgabe zum Testen
    }
    
    //Navigation zur Startseite
    public String zurStartseite() {
    	return "startseite";
    }
}




