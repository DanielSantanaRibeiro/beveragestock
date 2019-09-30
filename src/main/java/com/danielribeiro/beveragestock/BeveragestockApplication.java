package com.danielribeiro.beveragestock;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danielribeiro.beveragestock.domain.Beverage;
import com.danielribeiro.beveragestock.domain.BeverageRecord;
import com.danielribeiro.beveragestock.domain.Record;
import com.danielribeiro.beveragestock.domain.Section;
import com.danielribeiro.beveragestock.domain.Tun;
import com.danielribeiro.beveragestock.domain.User;
import com.danielribeiro.beveragestock.domain.enums.BeverageType;
import com.danielribeiro.beveragestock.repository.BeverageRecordRepository;
import com.danielribeiro.beveragestock.repository.BeverageRepository;
import com.danielribeiro.beveragestock.repository.RecordRepository;
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
	RecordRepository recordRepo;
	@Autowired
	BeverageRecordRepository bevrecRepo;
	
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
		
		Section s1 = new Section(null, "Seção 1");
		Section s2 = new Section(null, "Seção 2");
		Section s3 = new Section(null, "Seção 3");
		
		sectionRepo.saveAll(Arrays.asList(s1,s2,s3));
		
		Tun t1 = new Tun(null, 400, s1);
		Tun t2 = new Tun(null, 100, s1);
		Tun t3 = new Tun(null, 350, s2);
		Tun t4 = new Tun(null, 125, s3);

		tunRepo.saveAll(Arrays.asList(t1,t2,t3,t4));		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Record r1 = new Record(null, sdf.parse("04/02/1996 20:00"),u1);
		Record r2 = new Record(null, sdf.parse("31/12/1989 10:30"),u2);
		Record r3 = new Record(null, sdf.parse("02/05/1991 18:00"),u1);
		//Record r4 = new Record(null, sdf.parse("15/09/1987 23:20"),u2);
		
		recordRepo.saveAll(Arrays.asList(r1,r2,r3));
		
		BeverageRecord bv1 = new BeverageRecord(b1, r1, 300);
		BeverageRecord bv2 = new BeverageRecord(b2, r1, 140);
		BeverageRecord bv3 = new BeverageRecord(b2, r2, 220);
		BeverageRecord bv4 = new BeverageRecord(b1, r3, 470);
		
		
		bevrecRepo.saveAll(Arrays.asList(bv1,bv2,bv3,bv4));
		
	}

}
