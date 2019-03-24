package com.rscart.customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rscart.entities.Customer;
import com.rscart.entities.Order;

/**
 * @author Raviteja Bollimuntha
 *
 */
@Service
@Transactional
public class CustomerService {
	@Autowired CustomerRepository customerRepository;
	
	public Customer getCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}
	public void getCustomerDeactivate(int id) {
		customerRepository.deactivate(id);
	}
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.getCustomers();
	}

	public Customer getCustomerById(Integer id) {
		return customerRepository.findOne(id);
	}

	public List<Order> getCustomerOrders(String email) {
		return customerRepository.getCustomerOrders(email);
	}

}
