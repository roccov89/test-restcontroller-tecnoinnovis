package it.tecnoinnovis.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FeeType {
	
	SHA("SHA"),
	OUR("OUR"),
	BEN("BEN");
	
    private String type;

    private FeeType(String type) {
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
