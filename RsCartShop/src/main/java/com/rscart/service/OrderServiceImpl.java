package com.rscart.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rscart.constants.ControllerConstants;
import com.rscart.model.Customer;
import com.rscart.model.InvoiceOrderItem;
import com.rscart.model.Order;
import com.rscart.model.OrderItem;
import com.rscart.model.Product;
import com.rscart.model.ShippingForm;
import com.rscart.repository.OrderRepository;
import com.rscart.util.SessionUtils;
import com.rscart.util.Utility;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	private final String PENDING_ORDER_STATUS = "IN_PROCESS";


	@Override
	public Order createOrder(CartService cartService,
			Customer customer, ShippingForm shippingAddress, HttpServletRequest request)
			throws ParseException {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(date);
		Date presentDate = dateFormat.parse(formattedDate);
		java.util.Date sqlDate = new java.util.Date(presentDate.getTime());
		Long orderId = Utility.generateOrderNumber(date, customer);
		Order order = new Order();
		order.setOrderId(orderId);
		order.setCreatedDate(sqlDate);
		order.setUpdatedDate(sqlDate);
		order.setEmailAddress(customer.getEmailAddress());
		order.setOrderStatus(PENDING_ORDER_STATUS);
		CartData cartData = SessionUtils.getSessionVariables(request,
				ControllerConstants.CART);
		order.setOrderTotal(new BigDecimal(cartService.getTotal(cartData)));
		order.setCustomerId(customer.getCustomerId());
		List<OrderItem> orderItemsList = new ArrayList<OrderItem>();
		for (OrderItem orderItem : cartService.getOrderItemsList(cartData)) {
			orderItemsList.add(orderItem);
		}
		orderRepository.createOrder(order, orderItemsList, shippingAddress);
		return order;
	}

	@Override
	public List<Product> getAllOrderItems(Order order) {

		return orderRepository.readAllOrderItems(order);
	}
	@Override
	public List<InvoiceOrderItem> getOrderItems(Order order) {

		return orderRepository.AllOrderItems(order);
	}

	@Override
	public List<Order> getAllOrdersForCustomer(Customer customer) {

		return orderRepository.readAllOrdersForCustomer(customer);
	}

	@Override
	public Order getOrderById(Long orderId) {
		return orderRepository.readOrderById(orderId);
	}

}