package com.chcraft.erd;

public class Relationship {
	private Entity entity;
	private Entity other;
	private Relation relation;

	public enum Relation{
		ONE_TO_ONE,
		ONE_TO_MANY,
		MANY_TO_MANY
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Entity getOther() {
		return other;
	}

	public void setOther(Entity other) {
		this.other = other;
	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}
}
