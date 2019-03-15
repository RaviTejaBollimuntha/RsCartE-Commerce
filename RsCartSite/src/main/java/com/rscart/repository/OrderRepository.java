package com.rscart.repository;

import java.util.List;

import com.rscart.model.AddressForm;
import com.rscart.model.Customer;
import com.rscart.model.InvoiceOrderItem;
import com.rscart.model.Order;
import com.rscart.model.OrderItem;
import com.rscart.model.Product;
import com.rscart.model.ShippingForm;

public interface OrderRepository {
	void createOrder(Order order, List<OrderItem> orderItemsList, ShippingForm shippingAddress);

	List<Product> readAllOrderItems(Order order);

	List<Order> readAllOrdersForCustomer(Customer customer);

	Order readOrderById(Long orderId);

	List<InvoiceOrderItem> AllOrderItems(Order order);
}
