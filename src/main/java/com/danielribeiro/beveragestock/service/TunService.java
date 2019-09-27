package com.danielribeiro.beveragestock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielribeiro.beveragestock.domain.Tun;
import com.danielribeiro.beveragestock.exceptions.ObjectNotFoundException;
import com.danielribeiro.beveragestock.repository.TunRepository;

@Service
public class TunService {

	@Autowired
	private TunRepository repo;
	
	public Tun find(Integer id){
		Optional<Tun> obj = repo.findById(id);
		return obj.orElseThrow(()->new ObjectNotFoundException("Invalid ID: " + id + ", Type: " + Tun.class.getName()));
	}
	
	public List<Tun> findAll(){
		List<Tun> list = repo.findAll();
		return list;
	}
}
