package com.danielribeiro.beveragestock.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danielribeiro.beveragestock.domain.Tun;
import com.danielribeiro.beveragestock.service.TunService;

@RestController
@RequestMapping(value="/tuns")
public class TunResource {
	
	@Autowired
	private TunService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Tun> find(@PathVariable Integer id){
		Tun obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Tun> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
