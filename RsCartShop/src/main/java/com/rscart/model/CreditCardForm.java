package com.rscart.model;

public class CreditCardForm {

	private Long customerId;
    private double AccountNumber;
    private double amount;
	private String creditCardNumber;
	private Integer month;
	private Integer year;
	private String name;
	private String cvvCode;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
     
	public double getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(double accountNumber) {
		AccountNumber = accountNumber;
	}
    
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCvvCode() {
		return cvvCode;
	}

	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreditCardForm [customerId=");
		builder.append(customerId);
		builder.append(", AccountNumber=");
		builder.append(AccountNumber);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", creditCardNumber=");
		builder.append(creditCardNumber);
		builder.append(", month=");
		builder.append(month);
		builder.append(", year=");
		builder.append(year);
		builder.append(", name=");
		builder.append(name);
		builder.append(", cvvCode=");
		builder.append(cvvCode);
		builder.append("]");
		return builder.toString();
	}
   
}
