package com.chcraft.erd.utils;

import java.util.List;

import com.chcraft.erd.Entity;
import com.chcraft.erd.Relationship;

public interface SQLFileGenerator{
	public String generateFileString(List<Entity> entities, List<Relationship> relationships);
	public String generateEntity(Entity entity);
	public String generateRelationship(Relationship relationship);
}
