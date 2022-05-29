package com.ave;

import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ave.repositories.I_UsuarioRepository;
import com.ave.services.UsuarioService;

public class TestRepo {

	public static void main(String[] args) {

		System.out.println("1*************************************************");
        System.out.println(LocalTime.now());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        System.out.println("2*************************************************");
        EntityManager em = emf.createEntityManager();
		
        I_UsuarioRepository us = new UsuarioService(em);
        us.getAll().forEach(System.out::println);
        emf.close();
        
	}

}
