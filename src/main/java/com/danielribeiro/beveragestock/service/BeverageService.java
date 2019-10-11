package com.danielribeiro.beveragestock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielribeiro.beveragestock.domain.Beverage;
import com.danielribeiro.beveragestock.domain.enums.BeverageType;
import com.danielribeiro.beveragestock.dto.BeverageDTO;
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
	
	public Beverage insert(Beverage obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Beverage update(Beverage obj) {
		Optional <Beverage> newOpt = repo.findById(obj.getId());
		Beverage newObj = newOpt.get();
		updateData(newObj,obj);
		return repo.save(newObj);		
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	private void updateData(Beverage newObj, Beverage obj) {
		newObj.setName(obj.getName());
		newObj.setType(obj.getType());
		
	}
	
	public Beverage fromDTO(BeverageDTO obj) {
		return new Beverage(obj.getId(), obj.getName(), BeverageType.toEnum(obj.getType()));
	}
}
