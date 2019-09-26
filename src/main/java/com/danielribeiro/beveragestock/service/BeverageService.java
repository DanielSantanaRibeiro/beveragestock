package com.danielribeiro.beveragestock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielribeiro.beveragestock.domain.Beverage;
import com.danielribeiro.beveragestock.exceptions.ObjectNotFoundException;
import com.danielribeiro.beveragestock.repository.BeverageRepository;

@Service
public class BeverageService {

	@Autowired
	private BeverageRepository repo;

	public Beverage find(Integer id){
		Optional<Beverage> obj = repo.findById(id);
		return obj.orElseThrow(()->new ObjectNotFoundException("Object not found! ID: " + id + ", Type: " + Beverage.class.getName()));
	}
	
	public List<Beverage> findAll(){
		return repo.findAll();
	}
}
