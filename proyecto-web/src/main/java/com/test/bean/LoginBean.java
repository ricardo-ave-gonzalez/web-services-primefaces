package com.test.bean;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.ave.AuthServiceService;
import com.test.connections.URLFactory;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private String username = "";
	private String password = "";
	private String mensaje = "";

	public URL url= URLFactory.create("http://localhost:8080/ROOT/ws/hello");	
	
	AuthServiceService autoService = new AuthServiceService(url);
	
	public LoginBean() {}

	public LoginBean(String username, String password, String mensaje, URL url, AuthServiceService auth) {
		this.username = username;
		this.password = password;
		this.mensaje = mensaje;
	}

	
	
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

	public boolean getLogin(String username, String password) {
		return autoService.getAuthServicePort().getTrueLogin(username, password);
	}
	
	/*public String loginStatus(String username, String password) {
		boolean result = autoService.getAuthServicePort().getTrueLogin(username, password);
		if(result) {
			return "Correcto";
		} else {
			return "Verifique nuevamente los datos";
		}
	}*/
	
	public String loginStatus(String username, String password) {
		return username + " " + password;
	}
	
}
