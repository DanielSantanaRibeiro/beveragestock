package com.danielribeiro.beveragestock.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BeverageRecord {
	
	@EmbeddedId
	@JsonIgnore
	private BeverageRecordPK id = new BeverageRecordPK();
	
	private int volume;

	public BeverageRecord() {
		super();
	}

	public BeverageRecord(Beverage beverage, Record record , int volume) {
		super();
		this.volume = volume;
		id.setBeverage(beverage);
		id.setRecord(record);		
	}
	
	public BeverageRecordPK getId() {
		return id;
	}

	public void setId(BeverageRecordPK id) {
		this.id = id;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public Beverage getBeverage() {
		return id.getBeverage();
	}
	
	@JsonIgnore
	public Record getRecord() {
		return id.getRecord();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeverageRecord other = (BeverageRecord) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
