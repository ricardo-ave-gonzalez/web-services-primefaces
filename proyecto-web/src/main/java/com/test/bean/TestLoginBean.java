package com.test.bean;

import java.io.Serializable;

import java.net.URL;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.FacesComponent;
import javax.inject.Named;
import javax.xml.ws.WebServiceRef;

import com.ave.AuthServiceService;
import com.test.connections.URLFactory;


//@FacesComponent("testLoginBean")
//@Named("testLoginBean")
//@SessionScoped
@ManagedBean(eager = true)
@ViewScoped
public class TestLoginBean implements Serializable {

	private String username = "ricardito";
	private String password = "gonzalez";
	private String mensaje = "";
	

	public TestLoginBean() {}

	//public URL url= URLFactory.create("http://localhost:8080/ROOT/ws/auth");	
	@WebServiceRef(wsdlLocation = "http://localhost:8080/ROOT/ws/auth")
	AuthServiceService autoService = new AuthServiceService();
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/*
	public String loginStatus(String username, String password) {
		return username + " " + password;
	}*/


	public String loginStatus(String username, String password) {
		
		boolean result = autoService.getAuthServicePort().getTrueLogin(username, password);
		if(result) {
			return mensaje = "Login correcto";
		} else {
			return  mensaje = "Verifique nuevamente los datos";
		}
	}
	
}
