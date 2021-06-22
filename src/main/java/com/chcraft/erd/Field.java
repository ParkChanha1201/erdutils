package com.chcraft.erd;

import java.util.List;


public class Field {
	private String name;
	private List<Option> options;

	enum Option {
		PK,//Primary Key
		NN,//Not Null
		UQ,//Unique
		AI;//Auto_Increment
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public boolean addOption(Option option) {
		return options.add(option);
	}
	
	public boolean removeOption(Option option) {
		return options.remove(option);
	}
}

