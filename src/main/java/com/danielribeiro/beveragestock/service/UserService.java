package com.danielribeiro.beveragestock.service;

import java.util.List;
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
		return obj.orElseThrow(()->new ObjectNotFoundException("Object not found! ID: " + id + ", Type:" + User.class.getName()));
	}
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User insert(User user) {
		user.setId(null);
		return repo.save(user);
	}
	
	public User update(User obj) {
		Optional<User> optObj = repo.findById(obj.getId());
		User newObj = optObj.get();
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setAddress(obj.getAddress());
		newObj.setPhone(obj.getPhone());
		
	}
	
	
}