package com.rscart.customers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.rscart.entities.Customer;
import com.rscart.entities.Order;

/**
 * @author Raviteja Bollimuntha
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	@Query("select c from Customer c where c.Active=1")
	List<Customer> getCustomers();

	Customer findByEmail(String email);

	@Query("select o from Order o where o.customer.email=?1")
	List<Order> getCustomerOrders(String email);
    @Transactional
	@Modifying
	@Query("update Customer c set c.Active =0 where c.id = ?1")
	void deactivate(int id);

}
