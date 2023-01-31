package org.sid.enums;

public enum TypeChasseur {
	XWING("X-Wing"), YWING("Y-Wing");
	
	public final String LABEL;
	
	private TypeChasseur(String label) {
		this.LABEL = label;
	}
}
