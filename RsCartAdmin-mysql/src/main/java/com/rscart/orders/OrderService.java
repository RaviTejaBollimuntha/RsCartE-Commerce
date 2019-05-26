package com.rscart.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rscart.common.services.EmailService;
import com.rscart.common.services.RsCLogger;
import com.rscart.entities.Order;

/**
 * @author Raviteja Bollimuntha
 *
 */
@Service
@Transactional
public class OrderService
{
	private static final RsCLogger logger = RsCLogger.getLogger(OrderService.class);
	
	@Autowired EmailService emailService;
	@Autowired OrderRepository orderRepository;
	
	public Order createOrder(Order order)
	{
		//order.setOrderNumber(UUID.randomUUID().toString());
		order.setOrderNumber(String.valueOf(System.currentTimeMillis()));
		Order savedOrder = orderRepository.save(order);
		logger.info("New order created. Order Number : {}", savedOrder.getOrderNumber());
		return savedOrder;
	}
	
	public Order getOrder(String orderNumber)
	{
		return orderRepository.findByOrderNumber(orderNumber);
	}

	public List<Order> getAllOrders()
	{
		Sort sort = new Sort(Direction.DESC, "createdOn");
		return orderRepository.findAll(sort);
	}

	public Order updateOrder(Order order) {
		Order o = getOrder(order.getOrderNumber());
		o.setStatus(order.getStatus());
		Order savedOrder = orderRepository.save(o);
		return savedOrder;
	}
	public List<Order> getLastestedOrders() {

		return orderRepository.findTop5ByOrderByCreatedOnDesc();
	}
	
}
