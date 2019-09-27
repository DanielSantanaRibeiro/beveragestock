package com.danielribeiro.beveragestock;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danielribeiro.beveragestock.domain.Beverage;
import com.danielribeiro.beveragestock.domain.Section;
import com.danielribeiro.beveragestock.domain.Tun;
import com.danielribeiro.beveragestock.domain.User;
import com.danielribeiro.beveragestock.domain.enums.BeverageType;
import com.danielribeiro.beveragestock.repository.BeverageRepository;
import com.danielribeiro.beveragestock.repository.SectionRepository;
import com.danielribeiro.beveragestock.repository.TunRepository;
import com.danielribeiro.beveragestock.repository.UserRepository;

@SpringBootApplication
public class BeveragestockApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;
	@Autowired
	BeverageRepository beverageRepo;
	@Autowired
	TunRepository tunRepo;
	@Autowired
	SectionRepository sectionRepo;
	
	
	@Autowired 
	
	public static void main(String[] args) {
		SpringApplication.run(BeveragestockApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Afonso Silva", "Rua Dolores Campo e Silva", "(11) 99422-4413");
		User u2 = new User(null, "Marlene Schimit Oliveira", "Rua General Hernandez", "(19) 98437-1480");
		
		userRepo.saveAll(Arrays.asList(u1,u2));
		
		Beverage b1 = new Beverage(null, "Catuaba", BeverageType.ALCOHOLIC);
		Beverage b2 = new Beverage(null, "Fanta", BeverageType.NON_ALCOHOLIC);
		
		beverageRepo.saveAll(Arrays.asList(b1,b2));
		
		Tun t1 = new Tun(null, 400);
		Tun t2 = new Tun(null, 100);

		tunRepo.saveAll(Arrays.asList(t1,t2));		
		
		Section s1 = new Section(null, "Seção 1");
		Section s2 = new Section(null, "Seção 2");
		Section s3 = new Section(null, "Seção 3");
		
		sectionRepo.saveAll(Arrays.asList(s1,s2,s3));
		
	}

}
