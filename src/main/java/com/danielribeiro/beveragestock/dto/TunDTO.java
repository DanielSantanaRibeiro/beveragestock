package com.danielribeiro.beveragestock.dto;

import java.io.Serializable;

import com.danielribeiro.beveragestock.domain.Tun;

public class TunDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer capacity;
	
	
	public TunDTO() {
		super();
	}
	
	public TunDTO(Tun tun) {
		super();
		this.id = tun.getId();
		this.capacity = tun.getCapacity();
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
	

}
