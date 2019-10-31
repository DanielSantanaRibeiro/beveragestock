package com.danielribeiro.beveragestock.dto;

import java.io.Serializable;

public class TunDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer capacity;
	private Integer sectionId;
	
	public TunDTO() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}
	

}
