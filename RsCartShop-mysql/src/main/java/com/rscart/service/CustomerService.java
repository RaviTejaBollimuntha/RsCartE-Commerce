package com.rscart.service;

import com.rscart.model.Customer;

public interface CustomerService {

	public Customer validateUsers(String userName, String password);

	public Long registerUser(Customer customer);
	
	public Integer upadateUser(Customer customer);

	public boolean changePassword(String password1, Customer customer);

	public Customer getCustomerById(Long customerId);

	public Long getCustomerId(String userName);

	public void updateLogStatus(Customer customer);

}
