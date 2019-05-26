package com.rscart.service;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.rscart.model.Customer;
import com.rscart.model.InvoiceOrderItem;
import com.rscart.model.Order;
import com.rscart.model.Product;
import com.rscart.model.ShippingForm;

public interface OrderService {
	public Order createOrder(CartService cartService,
			Customer customer,  ShippingForm shippingAddress, HttpServletRequest request) throws ParseException;
	public List<Product> getAllOrderItems(Order order);
	
	public List<Order> getAllOrdersForCustomer(Customer customer);
	
	public Order getOrderById(Long orderId);
	public List<InvoiceOrderItem> getOrderItems(Order order);

}
