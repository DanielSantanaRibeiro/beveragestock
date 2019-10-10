package com.danielribeiro.beveragestock.dto;

import java.io.Serializable;

import com.danielribeiro.beveragestock.domain.Beverage;

public class BeverageDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Integer type;

	public BeverageDTO() {
		super();
	}

	public BeverageDTO(Beverage beverage) {
		super();
		this.id = beverage.getId();
		this.name = beverage.getName();
		this.type = beverage.getType().getCod();
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
