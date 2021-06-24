package com.chcraft.erd.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chcraft.erd.Entity;
import com.chcraft.erd.Field;
import com.chcraft.util.StringExtension;
import com.chcraft.util.TokenChanger;

public class JavaFileGenerator{
	public static void main(String[] args) {
		Entity entity = new Entity();
		Field field = new Field();

		field.setName("testField");

		entity.setName("testEntity");
		entity.setFields(new ArrayList<Field>());
		entity.addField(field);

		System.out.println(JavaFileGenerator.generateFile(entity, "test.com", true));
		System.out.println(JavaFileGenerator.generateFile(entity, "test.com", false));
	}

	private final static String TEMPLATE = "//generated by JavaFileGenerator\n"
			+"package [PACKAGEPATH];\n\n"
			+"public class [CLASSNAME]{\n"
			+"[FIELD]\n"
			+"[GETTERANDSETTER]\n"
			+"}";

	public static String generateFile(Entity entity, String packagePath, boolean generateGetterAndSetter) {
		String fields = generateFields(entity);
		String getterAndSetter = generateGetterAndSetter(entity);

		Map<String, String> tokenReplacement = new HashMap<String, String>();

		tokenReplacement.put("[PACKAGEPATH]", packagePath);
		tokenReplacement.put("[CLASSNAME]", StringExtension.toFirstCharUpperCase(entity.getName()));
		tokenReplacement.put("[FIELD]", fields);
		if(generateGetterAndSetter) {
			tokenReplacement.put("[GETTERANDSETTER]", getterAndSetter);
		} else {
			tokenReplacement.put("[GETTERANDSETTER]", "");
		}

		String result = TokenChanger.replaceToken(TEMPLATE, tokenReplacement);

		return result;
	}

	private static String generateFields(Entity entity) {
		List<Field> fields = entity.getFields();

		StringBuilder sb = new StringBuilder();

		int size = fields.size();
		for(int i = 0; i < size; i++) {
			Field field = fields.get(i);
			sb.append("\t");
			sb.append("private ");
			sb.append("type ");
			sb.append(StringExtension.toFirstCharLowerCase(field.getName()));
			sb.append(";\n");
		}

		return sb.toString();
	}

	private static String generateGetterAndSetter(Entity entity) {
		List<Field> fields = entity.getFields();

		StringBuilder sb = new StringBuilder();

		int size = fields.size();
		for(int i = 0; i < size; i++) {
			Field field = fields.get(i);
			//generate getter
			sb.append("\t");
			sb.append("public ");
			sb.append("type ");
			sb.append("get");
			sb.append(StringExtension.toFirstCharUpperCase(field.getName()));
			sb.append("() {\n");
			sb.append("\t\treturn this.");
			sb.append(StringExtension.toFirstCharLowerCase(field.getName()));
			sb.append(";\n");
			sb.append("\t}\n\n");

			//generate setter
			sb.append("\t");
			sb.append("public ");
			sb.append("void ");
			sb.append("set");
			sb.append(StringExtension.toFirstCharUpperCase(field.getName()));
			sb.append("(");
			sb.append("type ");
			sb.append(StringExtension.toFirstCharLowerCase(field.getName()));
			sb.append(") {\n");
			sb.append("\t\tthis.");
			sb.append(StringExtension.toFirstCharLowerCase(field.getName()));
			sb.append(" = ");
			sb.append(StringExtension.toFirstCharLowerCase(field.getName()));
			sb.append(";\n");
			sb.append("\t}\n\n");
		}

		return sb.toString();
	}
}
