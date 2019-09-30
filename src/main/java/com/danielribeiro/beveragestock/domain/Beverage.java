package com.danielribeiro.beveragestock.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.danielribeiro.beveragestock.domain.enums.BeverageType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Beverage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer type;

	@JsonIgnore
	@OneToMany(mappedBy="id.beverage")
	private Set<BeverageRecord> beveragerecord = new HashSet<>();

	public Beverage() {
		super();
	}

	public Beverage(Integer id, String name, BeverageType type) {
		super();
		this.id = id;
		this.name = name;
		this.type = (type == null) ? null : type.getCod();
	}

	@JsonIgnore
	public List<Record> getRecord(){
		List<Record> list = new ArrayList<Record>();
		for(BeverageRecord x : beveragerecord) {
			list.add(x.getRecord());
		}
		return list;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BeverageType getType() {
		return BeverageType.toEnum(type);
	}

	public void setType(BeverageType type) {
		this.type = type.getCod();
	}

	public Set<BeverageRecord> getBeveragerecord() {
		return beveragerecord;
	}

	public void setBeveragerecord(Set<BeverageRecord> beveragerecord) {
		this.beveragerecord = beveragerecord;
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
		Beverage other = (Beverage) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
