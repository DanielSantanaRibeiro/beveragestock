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

import com.danielribeiro.beveragestock.domain.Tun;
import com.danielribeiro.beveragestock.dto.TunDTO;
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
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody TunDTO objDTO){
		Tun t = service.fromDTO(objDTO);
		t = service.insert(t);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(t.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody TunDTO objDTO, @PathVariable Integer id){
		Tun t = service.fromDTO(objDTO);
		t.setId(id);
		service.update(t);
		return ResponseEntity.noContent().build();
	}
	 
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
