package it.tecnoinnovis.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LegalPersonBeneficiary {
	
	@NotEmpty
	private String fiscalCode;
	
	private String legalRepresentativeFiscalCode;
	
	public String getFiscalCode() {
		return fiscalCode;
	}
	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}
	public String getLegalRepresentativeFiscalCode() {
		return legalRepresentativeFiscalCode;
	}
	public void setLegalRepresentativeFiscalCode(String legalRepresentativeFiscalCode) {
		this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode;
	}

}
