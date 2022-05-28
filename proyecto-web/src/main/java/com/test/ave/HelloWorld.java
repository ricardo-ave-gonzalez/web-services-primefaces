package com.test.ave;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import com.test.connections.URLFactory;


@ManagedBean
//@Named("helloWorld")
//@RequestScoped
public class HelloWorld implements Serializable {

	//Conexion conn;
	final String endpoint = "http://localhost:8080/ROOT/ws/hello";
	final URL url = URLFactory.create(endpoint);
	
	final ServicioSaludar service = new ServicioSaludar(url);
	
	public void MyClass() throws MalformedURLException {}
	
	private String firstName = "Obi Wan";
	private String lastName = "Anakin Skywalker";
	
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String showGreeting() {
		//return firstName;
		return service.getHelloPort().bonjour(firstName, lastName);
	}	

}