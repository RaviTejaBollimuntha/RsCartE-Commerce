package com.rscart.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.rscart.model.OrderItem;
import com.rscart.model.Product;

public class CartData implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<Long, OrderItem> productsMap;
	private int numberOfItems;
	private List<OrderItem> orderItemsList;
	private List<Product> productsList;
	private double subtotal;
	private double total;
	private int couponvalue;	
	private double grandtotal;
	private int quantity;
	public void setCouponvalue(int couponvalue) {
		this.couponvalue = couponvalue;
	}
	public int getQuantity() {
		return quantity;
	}

	public CartData() {
		productsMap = new ConcurrentHashMap<Long, OrderItem>();
	}

	public void add(Long productId, OrderItem orderItem) {
		productsMap.put(productId, orderItem);
	}

	public int getNumberOfItems() {
		numberOfItems = 0;
		List<OrderItem> itemsList = new ArrayList<OrderItem>();
		itemsList.addAll(productsMap.values());
		for (OrderItem item : itemsList) {
			numberOfItems += item.getQuantity();
		}

		return numberOfItems;
	}

	public boolean contains(Long productId) {
		return productsMap.containsKey(productId);
	}

	public void incrementProductQuantity(Long productId) {
		OrderItem orderItem = productsMap.get(productId);
		orderItem.incrementQuantity();
	}

	public void clearCart() {
		productsMap.clear();
		numberOfItems = 0;
	}

	public void decrementProductQuantity(Long productId) {
		OrderItem orderItem = productsMap.get(productId);
		orderItem.decrementQuantity();
	}

	public void removeProduct(Long productId) {
		decrementProductQuantity(productId);
		productsMap.remove(productId);
	}

	public List<OrderItem> getOrderItemsList() {
		// HashMap.values() returns a Collection which cannot be cast into List
		// Thus create an ArrayList and set it as a constructor.
		orderItemsList = new ArrayList<OrderItem>(productsMap.values());
		return orderItemsList;
	}

	public List<Product> getProductsList() {
		orderItemsList = getOrderItemsList();
		productsList = new ArrayList<Product>();
		for (OrderItem o : orderItemsList) {
			productsList.add(o.getProduct());
		}
		return productsList;
	}

	public double getTotal() {
		double amount = 0.0;
		for (OrderItem item : productsMap.values()) {
			amount = amount + (item.getTotal()).doubleValue();
		}
		total = amount;
		return total;
	}

	public double getSubtotal() {

		subtotal = getTotal() * 0.18;
		return subtotal;
	}

	public double getGrandtotal() {
       		grandtotal = getTotal() + getSubtotal();
       		if(getTotal()!=0.0) {
       		if(grandtotal<750)
		    return grandtotal+50-((couponvalue*0.01)* getTotal());
       		else
       			return grandtotal-((couponvalue*0.01)* getTotal());
       		}else
       			return total;
	}

	public boolean isCartEmpty() {
		return productsMap.isEmpty();
	}

	public OrderItem getProduct(Long productId) {
		return productsMap.get(productId);
	}

	public int getCartSize() {
		return productsMap.size();
	}

	public boolean containsKey(Long productId) {
		return productsMap.containsKey(productId);
	}
	
}
