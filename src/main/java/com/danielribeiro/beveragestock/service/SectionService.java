package com.danielribeiro.beveragestock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielribeiro.beveragestock.domain.Section;
import com.danielribeiro.beveragestock.dto.SectionDTO;
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
	
	public Section insert(Section obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Section update(Section obj) {
		Optional <Section> opt = repo.findById(obj.getId());
		Section newObj = opt.get();
		updateDate(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);		
		repo.deleteById(id);
	}

	private void updateDate(Section section, Section obj) {
		section.setName(obj.getName());
	}

	public Section fromDTO(SectionDTO objDTO) {
		return new Section(objDTO.getId(), objDTO.getName()); 
	}
}
