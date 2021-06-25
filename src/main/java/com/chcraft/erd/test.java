package com.chcraft.erd;

import java.util.ArrayList;
import java.util.List;

import com.chcraft.erd.utils.SQLFileGenerator;
import com.chcraft.erd.utils.SimpleSQLFileGenerator;

public class test {
	public static void main(String[] args) {
		Entity entity = new Entity();
		Field field = new Field();
		Field field2 = new Field();


		field.setName("testField");
		field2.setName("testField2");
		field.setType("testType");
		field2.setType("testType");

		List<FieldOption> options = new ArrayList<FieldOption>();
		options.add(FieldOption.PK);
		options.add(FieldOption.AI);
		field.setOptions(options);
		field2.setOptions(options);


		entity.setName("testEntity");
		entity.setFields(new ArrayList<Field>());
		entity.addField(field);
		entity.addField(field2);

		SQLFileGenerator sfg = new SimpleSQLFileGenerator();
		System.out.println(sfg.generateEntity(entity));
	}
}
