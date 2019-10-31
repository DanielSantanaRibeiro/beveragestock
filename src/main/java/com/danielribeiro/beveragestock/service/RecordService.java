package com.danielribeiro.beveragestock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielribeiro.beveragestock.domain.Record;
import com.danielribeiro.beveragestock.exceptions.ObjectNotFoundException;
import com.danielribeiro.beveragestock.repository.RecordRepository;

@Service
public class RecordService {

	@Autowired
	private RecordRepository repo;

	public Record find(Integer id) {
		Optional<Record> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! ID: " + id + ", Type: " + Record.class.getName()));
	}
	
	public List<Record> findAll(){
		List<Record> list = repo.findAll();
		return list;
	}
	
	public Record insert(Record obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Record update(Record obj) {
		Optional<Record> opt = repo.findById(obj.getId());
		Record newObj = opt.get();
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	private void updateData(Record newObj, Record obj){
		/*newObj.set*/
	}
	
	/*public Record fromDTO(RecordDTO obj) {
		return new Record(obj.getId(), obj.getCapacity(), null);
	}*/
}
