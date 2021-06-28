package com.chcraft.erd;

interface InitialToOrigin {
	String initialToOrigin();
}

public enum FieldOption implements InitialToOrigin {
	PK {
		public String initialToOrigin() {
			return "PRIMARY KEY";
		}
	},
	NN {
		public String initialToOrigin() {
			return "NOT NULL";
		}
	},
	UQ {
		public String initialToOrigin() {
			return "UNIQUE";
		}
	},
	AI {
		public String initialToOrigin() {
			return "AUTO_INCREMENT";
		}
	};
}