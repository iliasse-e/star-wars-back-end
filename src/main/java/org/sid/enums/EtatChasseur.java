package org.sid.enums;

public enum EtatChasseur {
	OPERATIONNEL("operationnel"), MAINTENANCE("maintenance"), DETRUIT("detruit");

	public final String LABEL;
	private EtatChasseur(String label) {
		this.LABEL = label;
	}
}
