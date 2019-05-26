package com.rscart.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rscart.model.Order;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setOrderId(rs.getLong("Order_Id"));
		order.setCreatedDate(rs.getDate("CreatedDate"));
		order.setUpdatedDate(rs.getDate("UpdatedDate"));
		order.setEmailAddress(rs.getString("Email_Address"));
		order.setOrderStatus(rs.getString("Order_Status"));
		order.setOrderTotal(rs.getBigDecimal("Order_SubTotal"));
		order.setCustomerId(rs.getLong("Customer_Id"));
		order.setShippingId(rs.getLong("Shipping_Id"));
		return order;
	}

}