package com.rscart.orders;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rscart.entities.Order;

/**
 * @author Raviteja Bollimuntha
 *
 */
public interface OrderRepository extends JpaRepository<Order, Integer>
{
	Order findByOrderNumber(String orderNumber);
	List<Order> findTop5ByOrderByCreatedOnDesc();
}
