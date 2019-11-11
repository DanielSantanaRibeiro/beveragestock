package com.danielribeiro.beveragestock.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielribeiro.beveragestock.domain.BeverageRecord;
import com.danielribeiro.beveragestock.domain.Record;
import com.danielribeiro.beveragestock.exceptions.ObjectNotFoundException;
import com.danielribeiro.beveragestock.repository.BeverageRecordRepository;
import com.danielribeiro.beveragestock.repository.RecordRepository;

@Service
public class RecordService {

	@Autowired
	private RecordRepository repo;
	@Autowired
	private BeverageRecordRepository beveragerecordrepo;

	public Record find(Integer id) {
		Optional<Record> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! ID: " + id + ", Type: " + Record.class.getName()));
	}
	
	public List<Record> findAll(){
		List<Record> list = repo.findAll();
		return list;
	}
	
	@Transactional
	public Record insert(Record obj) {
		obj.setId(null);
		obj.setDate(new Date());
		obj = repo.save(obj);
		for(BeverageRecord x : obj.getBeveragerecord()) {
			x.setRecord(obj);
		}
		beveragerecordrepo.saveAll(obj.getBeveragerecord());
		return obj;
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
}
