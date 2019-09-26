package com.danielribeiro.beveragestock.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danielribeiro.beveragestock.domain.Beverage;
import com.danielribeiro.beveragestock.service.BeverageService;

@RestController
@RequestMapping(value="/beverages")
public class BeverageResource {
	
	@Autowired
	BeverageService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Beverage> find(@PathVariable Integer id){
		Beverage obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Beverage> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
