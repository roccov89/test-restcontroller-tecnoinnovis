package it.tecnoinnovis.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MoneyTransferResponse {
	
	private String moneyTransferId;
	private String status;
	private String direction;
	private Creditor creditor;
	private Debtor debtor;
	private String cro;
	private String trn;
	private String uri;
	private String description;
	private XMLGregorianCalendar createdDatetime;
	private XMLGregorianCalendar accountedDatetime;
	private Date debtorValueDate;
	private Date creditorValueDate;
	private boolean isUrgent;
	private boolean isInstant;
	private FeeType feeType;
	private String feeAccountID;
	private List<Fees> fees;
	private boolean hasTaxRelief;
	
	public String getMoneyTransferId() {
		return moneyTransferId;
	}
	public void setMoneyTransferId(String moneyTransferId) {
		this.moneyTransferId = moneyTransferId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Creditor getCreditor() {
		return creditor;
	}
	public void setCreditor(Creditor creditor) {
		this.creditor = creditor;
	}
	public Debtor getDebtor() {
		return debtor;
	}
	public void setDebtor(Debtor debtor) {
		this.debtor = debtor;
	}
	public String getCro() {
		return cro;
	}
	public void setCro(String cro) {
		this.cro = cro;
	}
	public String getTrn() {
		return trn;
	}
	public void setTrn(String trn) {
		this.trn = trn;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public XMLGregorianCalendar getCreatedDatetime() {
		return createdDatetime;
	}
	public void setCreatedDatetime(XMLGregorianCalendar createdDatetime) {
		this.createdDatetime = createdDatetime;
	}
	public XMLGregorianCalendar getAccountedDatetime() {
		return accountedDatetime;
	}
	public void setAccountedDatetime(XMLGregorianCalendar accountedDatetime) {
		this.accountedDatetime = accountedDatetime;
	}
	public Date getDebtorValueDate() {
		return debtorValueDate;
	}
	public void setDebtorValueDate(Date debtorValueDate) {
		this.debtorValueDate = debtorValueDate;
	}
	public Date getCreditorValueDate() {
		return creditorValueDate;
	}
	public void setCreditorValueDate(Date creditorValueDate) {
		this.creditorValueDate = creditorValueDate;
	}
	public boolean isUrgent() {
		return isUrgent;
	}
	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}
	public boolean isInstant() {
		return isInstant;
	}
	public void setInstant(boolean isInstant) {
		this.isInstant = isInstant;
	}
	public FeeType getFeeType() {
		return feeType;
	}
	public void setFeeType(FeeType feeType) {
		this.feeType = feeType;
	}
	public String getFeeAccountID() {
		return feeAccountID;
	}
	public void setFeeAccountID(String feeAccountID) {
		this.feeAccountID = feeAccountID;
	}
	public boolean isHasTaxRelief() {
		return hasTaxRelief;
	}
	public void setHasTaxRelief(boolean hasTaxRelief) {
		this.hasTaxRelief = hasTaxRelief;
	}
	public List<Fees> getFees() {
		return fees;
	}
	public void setFees(List<Fees> fees) {
		this.fees = fees;
	}

	
	

}
