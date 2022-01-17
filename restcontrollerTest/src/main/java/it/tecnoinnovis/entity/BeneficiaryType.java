package it.tecnoinnovis.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BeneficiaryType {
	
	NATURAL_PERSON("NATURAL_PERSON"),
	LEGAL_PERSON("LEGAL_PERSON");
	
	private String type;
	
	private BeneficiaryType(String type) {
		this.type = type;
	}

	@JsonValue
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
