package com.danielribeiro.beveragestock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielribeiro.beveragestock.domain.Tun;
import com.danielribeiro.beveragestock.dto.TunDTO;
import com.danielribeiro.beveragestock.exceptions.ObjectNotFoundException;
import com.danielribeiro.beveragestock.repository.TunRepository;

@Service
public class TunService {

	@Autowired
	private TunRepository repo;
	
	public Tun find(Integer id){
		Optional<Tun> obj = repo.findById(id);
		return obj.orElseThrow(()->new ObjectNotFoundException("Object not found! ID: " + id + ", Type: " + Tun.class.getName()));
	}
	
	public List<Tun> findAll(){
		List<Tun> list = repo.findAll();
		return list;
	}
	
	public Tun insert(Tun obj) {
		obj.setId(null);		
		obj = repo.save(obj);
		return obj;
	}
	
	public Tun update(Tun obj) {
		Optional<Tun> optObj = repo.findById(obj.getId());
		Tun newObj = optObj.get();
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	private void updateData(Tun newObj, Tun obj){
		newObj.setCapacity(obj.getCapacity());
	}
	
	public Tun fromDTO(TunDTO obj) {
		return new Tun(obj.getId(), obj.getCapacity(), null);
	}
}
