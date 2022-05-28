package com.test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import com.test.ave.ServicioSaludar;

public class Init {

	public static void main(String[] args) throws MalformedURLException {
		
		//com.ave.test.ServicioSaludar service = new com.ave.test.ServicioSaludar();
		//String bonjour = service.getHelloPort().bonjour("Andy");
		//System.out.println(bonjour);	
		
		final String endpoint = "http://localhost:8080/ROOT/ws/hello";
		final URL url = URI.create(endpoint).toURL();
		
		final ServicioSaludar service = new ServicioSaludar(url);
		final String bonjour = service.getHelloPort().bonjour("Richard", "Gonzalez");
		System.out.println(bonjour);
	}

}
