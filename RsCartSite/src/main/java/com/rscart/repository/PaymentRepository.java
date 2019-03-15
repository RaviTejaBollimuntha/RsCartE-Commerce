package com.rscart.repository;

import com.rscart.model.CreditCardForm;

public interface PaymentRepository {
	void payByCreditCard(CreditCardForm creditCardForm);

	int withdraw(double accNo, double amt);

	int deposite(double accNo, double amt);
}
