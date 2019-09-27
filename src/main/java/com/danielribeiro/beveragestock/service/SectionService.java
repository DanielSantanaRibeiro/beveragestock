package com.danielribeiro.beveragestock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielribeiro.beveragestock.domain.Section;
import com.danielribeiro.beveragestock.exceptions.ObjectNotFoundException;
import com.danielribeiro.beveragestock.repository.SectionRepository;

@Service
public class SectionService {
	
	@Autowired
	private SectionRepository repo;
	
	public Section find(Integer id) {
		Optional<Section> obj = repo.findById(id);		
		return obj.orElseThrow(()->new ObjectNotFoundException("Object not found! ID: " + id + ", Type: " + Section.class.getName()));
	}
	
	public List<Section> findAll(){
		List<Section> list = repo.findAll();
		return list;
	}
}
