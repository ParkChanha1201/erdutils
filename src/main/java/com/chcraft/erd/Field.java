package com.chcraft.erd;

import java.util.List;


public class Field {
	private String name;
	private String type;
	private List<FieldOption> options;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<FieldOption> getOptions() {
		return options;
	}

	public void setOptions(List<FieldOption> options) {
		this.options = options;
	}

	public boolean addOption(FieldOption option) {
		return options.add(option);
	}

	public boolean removeOption(FieldOption option) {
		return options.remove(option);
	}
}