package com.core.springcore.bean;

public class Table {

	String name;

	public Table(String name) {
		super();
		this.name = name;
	}

	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Table [name=" + name + "]";
	}
	
}

