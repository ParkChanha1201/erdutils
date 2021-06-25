package com.chcraft.erd.utils;

import com.chcraft.erd.Entity;

public interface JavaFileGenerator{
	public String generateFile(Entity entity, String packagePath, boolean generateGetterAndSetter);
}
