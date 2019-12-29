package com.metrotnx.firstPlugin;

public enum DataTypes {

	INT("Integer"),
	DOUBLE("Double"),
	STRING("String"),
	FLOAT("Float"),
	BOOLEAN("Boolean"),
	BYTE("Byte"),
	SHORT("Short"),
	LONG("Long");
	
	public String name;
	
	private DataTypes(String name) {
		this.name = name;
	}
	
}
