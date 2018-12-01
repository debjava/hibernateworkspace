package com.ddlab.rnd.orm;

public class BankAccount {

	private long actId;

	private String currency;
	
	private String accountNo;
	
    private BankCustomer bankCustomer;
	
	public BankCustomer getBankCustomer() {
		return bankCustomer;
	}

	public void setBankCustomer(BankCustomer bankCustomer) {
		this.bankCustomer = bankCustomer;
	}

	public BankAccount() {
		
	}
	
	public BankAccount(String currency,String accountNo,BankCustomer bankCustomer) {
		this.currency = currency;
		this.accountNo = accountNo;
		this.bankCustomer = bankCustomer;
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
