package com.danielribeiro.beveragestock.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class BeverageRecordPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="beverage_id")
	@JsonIgnore
	private Beverage beverage;
	
	@ManyToOne
	@JoinColumn(name="record_id")
	@JsonIgnore
	private Record record;
	
	public BeverageRecordPK() {
		super();
	}
	
	public BeverageRecordPK(Beverage beverage, Record record) {
		super();
		this.beverage = beverage;
		this.record = record;
	}

	public Beverage getBeverage() {
		return beverage;
	}

	public void setBeverage(Beverage beverage) {
		this.beverage = beverage;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beverage == null) ? 0 : beverage.hashCode());
		result = prime * result + ((record == null) ? 0 : record.hashCode());
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
		BeverageRecordPK other = (BeverageRecordPK) obj;
		if (beverage == null) {
			if (other.beverage != null)
				return false;
		} else if (!beverage.equals(other.beverage))
			return false;
		if (record == null) {
			if (other.record != null)
				return false;
		} else if (!record.equals(other.record))
			return false;
		return true;
	}	
	
}
