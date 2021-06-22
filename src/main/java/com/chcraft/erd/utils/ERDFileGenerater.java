package com.chcraft.erd.utils;

import java.util.List;

import com.chcraft.erd.Entity;
import com.chcraft.erd.Relationship;

public interface ERDFileGenerater {
	String generateFile(List<Entity> entities, List<Relationship> relationships);
}