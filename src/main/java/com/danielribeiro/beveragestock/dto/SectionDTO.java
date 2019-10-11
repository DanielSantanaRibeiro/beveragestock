package com.danielribeiro.beveragestock.dto;

import java.io.Serializable;

import com.danielribeiro.beveragestock.domain.Section;

public class SectionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	
	public SectionDTO() {
		super();
	}
	
	public SectionDTO(Section section) {
		super();
		this.id = section.getId();
		this.name = section.getName();
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
	

}
