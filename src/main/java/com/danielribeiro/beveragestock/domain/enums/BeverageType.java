package com.danielribeiro.beveragestock.domain.enums;

public enum BeverageType {
	ALCOHOLIC(1, "Alcoholic beverage"), 
	NON_ALCOHOLIC(2, "Non-Alcoholic beverage");

	private int cod;
	private String description;

	private BeverageType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static BeverageType toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (BeverageType x : BeverageType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid ID: " + cod);
	}
}
