package com.rscart.service;

import javax.servlet.http.HttpServletRequest;

import com.rscart.model.CreditCardForm;

public interface PaymentService {
	public void payByCreditCard(CreditCardForm creditCardForm);

	public CreditCardForm gatherCardDetails(CreditCardForm creditCardForm,
			HttpServletRequest request);

	boolean transferMoney(double srcAcno, double amount);
}
