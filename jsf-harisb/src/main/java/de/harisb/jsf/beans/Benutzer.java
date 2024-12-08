package de.harisb.jsf.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class Benutzer implements Serializable {

	private String name;
	private String password;
	private static final long serialVersionUID = 1L;
	
	public Benutzer() {
		
	}
	
	public Benutzer(String name, String password) {
		this();
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Benutzer) {
			Benutzer b = (Benutzer) obj;
			if(b.getName().equals(this.name) && 
			b.getPassword().equals(this.password)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + password.hashCode();
	}
	
}






