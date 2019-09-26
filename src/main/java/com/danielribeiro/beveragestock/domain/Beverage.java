package com.danielribeiro.beveragestock.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.danielribeiro.beveragestock.domain.enums.BeverageType;

@Entity
public class Beverage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;
	private String name;
	private Integer type;

	public Beverage() {
		super();
	}

	public Beverage(Integer id, String name, BeverageType type) {
		super();
		Id = id;
		this.name = name;
		this.type = (type == null) ? null : type.getCod();
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

}
