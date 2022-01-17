package it.tecnoinnovis.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Amount {
	
	private Integer debtorAmount;
	private String debtorCurrency;
	private Integer creditorAmount;
	private String creditorCurrency;
	private Date creditorCurrencyDate;
	private Integer exchangeRate;
	
	public Integer getDebtorAmount() {
		return debtorAmount;
	}
	public void setDebtorAmount(Integer debtorAmount) {
		this.debtorAmount = debtorAmount;
	}
	public String getDebtorCurrency() {
		return debtorCurrency;
	}
	public void setDebtorCurrency(String debtorCurrency) {
		this.debtorCurrency = debtorCurrency;
	}
	public Integer getCreditorAmount() {
		return creditorAmount;
	}
	public void setCreditorAmount(Integer creditorAmount) {
		this.creditorAmount = creditorAmount;
	}
	public String getCreditorCurrency() {
		return creditorCurrency;
	}
	public void setCreditorCurrency(String creditorCurrency) {
		this.creditorCurrency = creditorCurrency;
	}
	public Date getCreditorCurrencyDate() {
		return creditorCurrencyDate;
	}
	public void setCreditorCurrencyDate(Date creditorCurrencyDate) {
		this.creditorCurrencyDate = creditorCurrencyDate;
	}
	public Integer getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(Integer exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	
	
	

}
