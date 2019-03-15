package com.rscart.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rscart.model.CreditCardForm;
import com.rscart.model.Customer;
import com.rscart.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	private HttpSession session;

	@Override
	public void payByCreditCard(CreditCardForm creditCardForm) {
		paymentRepository.payByCreditCard(creditCardForm);
	}

	@Override
	public CreditCardForm gatherCardDetails(CreditCardForm creditCardForm,
			HttpServletRequest request) {
		System.out.println(creditCardForm);
		session = request.getSession();
		Long customerId = ((Customer) session.getAttribute("customer")).getCustomerId();
		double AccountNumber=Double.parseDouble(request.getParameter("AccountNumber"));
		double amount=Double.parseDouble( request.getParameter("amount"));
		String creditCardNumber = request.getParameter("creditCardNumber");
		Integer month = Integer.parseInt(request.getParameter("month"));
		Integer year = Integer.parseInt(request.getParameter("year"));
		String name = request.getParameter("name");
		String cvvCode = request.getParameter("cvvCode");
		
		creditCardForm.setCustomerId(customerId);
		creditCardForm.setCreditCardNumber(creditCardNumber);
		creditCardForm.setMonth(month);
		creditCardForm.setYear(year);
		creditCardForm.setCvvCode(cvvCode);
		creditCardForm.setName(name);
		creditCardForm.setAccountNumber(AccountNumber);
		creditCardForm.setAmount(amount);
		return creditCardForm;

	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false,transactionManager="dsTxMgmr")
	public boolean transferMoney(double srcAcno, double amount) {
		int count1=0,count2=0;
		//use DAO
		count1=paymentRepository.withdraw(srcAcno, amount);
		count2=paymentRepository.deposite(32165498712365.0, amount);
		if(count1==0 || count2==0)
			throw new IllegalArgumentException();		
		
		return true;
	}
}
