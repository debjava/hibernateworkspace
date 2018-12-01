package com.ddlab.rnd.orm.bidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BankAccount")
public class BankAccount {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="actId")
	private long actId;

	@Column(name="currency")
	private String currency;
	
	@Column(name="accountNo")
	private String accountNo;
	
	@ManyToOne
    @JoinColumn(name="custId")
    private BankCustomer bankCustomer;
	
	public BankCustomer getBankCustomer() {
		return bankCustomer;
	}

	public void setBankCustomer(BankCustomer bankCustomer) {
		this.bankCustomer = bankCustomer;
	}

	public BankAccount() {
		
	}
	
	public BankAccount(String currency,String accountNo) {
		this.currency = currency;
		this.accountNo = accountNo;
	}

	public long getActId() {
		return actId;
	}

	public void setActId(long actId) {
		this.actId = actId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

}
