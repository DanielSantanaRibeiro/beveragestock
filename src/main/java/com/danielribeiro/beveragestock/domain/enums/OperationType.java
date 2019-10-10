package com.danielribeiro.beveragestock.domain.enums;

public enum OperationType {
	RECEIPT(1, "Goods receipt"), 
	ISSUE(2, "Goods issue");

	private int cod;
	private String description;

	private OperationType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static OperationType toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (OperationType x : OperationType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid ENUM COD: " + cod);
	}
}
