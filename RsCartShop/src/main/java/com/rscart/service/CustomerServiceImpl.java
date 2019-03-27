package com.rscart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rscart.model.Customer;
import com.rscart.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;	

	@Override
	public Customer validateUsers(String userName, String password) {
		Customer customer = customerRepository
				.validateUsers(userName, password);
		return customer;
	}

	@Override
	public Long registerUser(Customer customer) {
		return customerRepository.registerUser(customer);
	}
    @Override
    public Integer upadateUser(Customer customer) {
    	return customerRepository.upadateUser(customer);
    }
	@Override
	public boolean changePassword(String password, Customer customer) {
		return customerRepository.changePassword(password, customer);
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		return customerRepository.getCustomerById(customerId);
	}

	@Override
	public Long getCustomerId(String userName) {
		return customerRepository.getCustomerById(userName);
	}	 
}
