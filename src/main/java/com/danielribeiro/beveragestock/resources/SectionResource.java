package com.danielribeiro.beveragestock.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danielribeiro.beveragestock.domain.Section;
import com.danielribeiro.beveragestock.service.SectionService;

@RestController
@RequestMapping(value="/sections")
public class SectionResource {

	@Autowired
	private SectionService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Section> find(@PathVariable Integer id){
		Section obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Section> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}
}
