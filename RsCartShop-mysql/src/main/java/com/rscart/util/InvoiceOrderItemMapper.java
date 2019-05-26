package com.rscart.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rscart.model.InvoiceOrderItem;

public class InvoiceOrderItemMapper implements RowMapper<InvoiceOrderItem> {

	@Override
	public InvoiceOrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		InvoiceOrderItem orderItem = new InvoiceOrderItem();
		orderItem.setOrderItemId(rs.getLong("ORDERITEM_ID"));
		orderItem.setOrderId(rs.getLong("ORDER_ID"));
		orderItem.setProductId(rs.getLong("PRODUCT_ID"));
        orderItem.setQUANTITY(rs.getLong("QUANTITY"));
        orderItem.setNAME(rs.getString("NAME"));
        orderItem.setPRICE(rs.getLong("PRICE"));
        orderItem.setCATEGORY_ID(rs.getLong("CATEGORY_ID"));
        orderItem.setSUBCATEGORY_ID(rs.getLong("SUBCATEGORY_ID"));
		return orderItem;
	}

}
