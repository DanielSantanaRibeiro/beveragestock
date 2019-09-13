package com.danielribeiro.beveragestock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielribeiro.beveragestock.domain.User;
import com.danielribeiro.beveragestock.exceptions.ObjectNotFoundException;
import com.danielribeiro.beveragestock.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	UserRepository repo;

	public User find(Integer id){
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(()->new ObjectNotFoundException("Objeto nao enontrado! ID: " + id + ", Tipo:" + User.class.getName()));
	}

}