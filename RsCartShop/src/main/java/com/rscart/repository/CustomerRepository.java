package com.rscart.repository;

import com.rscart.model.Customer;

public interface CustomerRepository {

	public Customer validateUsers(String userName, String password);

	public Long registerUser(Customer customer);
	
	public boolean changePassword(String password,Customer customer);

	public Customer getCustomerById(Long customerId);

	public Long getCustomerById(String userName);

	public Integer upadateUser(Customer customer);

	public void updateHitCount();
}
