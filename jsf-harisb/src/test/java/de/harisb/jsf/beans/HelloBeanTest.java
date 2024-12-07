package de.harisb.jsf.beans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HelloBeanTest {
	
	HelloBean helloBean;

	@BeforeEach
	void setUp() {
		helloBean = new HelloBean();
	}

	@Test
	void testGetMessage() {
		assertEquals("Hallo, willkommen bei Jakarta EE!", helloBean.getMessage());
	}

	@Test
	void testSetMessage() {
		helloBean.setMessage("Kommt die Nachricht an?");
		assertEquals("Kommt die Nachricht an?", helloBean.getMessage());
	}

	@Test
	void testSayHello() {
		helloBean.sayHello();
		assertEquals("Hallo von der Bean!", helloBean.getMessage());
	}

	@Test
	void testZurStartseite() {
		assertEquals("startseite", helloBean.zurStartseite());
	}

}
