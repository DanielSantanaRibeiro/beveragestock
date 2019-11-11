package com.danielribeiro.beveragestock.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.danielribeiro.beveragestock.domain.Beverage;
import com.danielribeiro.beveragestock.dto.BeverageDTO;
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
	public ResponseEntity<List<Beverage>> findAll(){
		List<Beverage> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody BeverageDTO objDTO){
		Beverage obj = service.fromDTO(objDTO);		
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody BeverageDTO objDTO, @PathVariable Integer id){
		Beverage obj = service.fromDTO(objDTO);
		obj.setId(id);
		service.update(obj);		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
