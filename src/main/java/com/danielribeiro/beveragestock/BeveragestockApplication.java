package com.danielribeiro.beveragestock;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danielribeiro.beveragestock.domain.User;
import com.danielribeiro.beveragestock.repository.UserRepository;

@SpringBootApplication
public class BeveragestockApplication implements CommandLineRunner {

	@Autowired
	UserRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(BeveragestockApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Afonso Silva", "Rua Dolores Campo e Silva", "(11) 99422-4413");
		User u2 = new User(null, "Marlene Schimit Oliveira", "Rua General Hernandez", "(19) 98437-1480");
		
		repo.saveAll(Arrays.asList(u1,u2));
	}

}
