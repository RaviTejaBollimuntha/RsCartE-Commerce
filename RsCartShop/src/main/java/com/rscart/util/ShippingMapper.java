package com.rscart.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rscart.model.AddressForm;
import com.rscart.model.ShippingForm;

public class ShippingMapper implements RowMapper<ShippingForm> {

	@Override
	public ShippingForm mapRow(ResultSet rs, int rowNum) throws SQLException {
		ShippingForm address = new ShippingForm();
		address.setShippingId(rs.getLong("Shipping_Id"));
		address.setAddress1(rs.getString("Address_1"));
		address.setAddress2(rs.getString("Address_2"));
		address.setCity(rs.getString("City"));
		address.setZipCode(rs.getString("Zip"));
		address.setState(rs.getString("State"));
		address.setCountry(rs.getString("country"));
		address.setFullName(rs.getString("FullName"));
		address.setCustomer_Id(rs.getLong("Customer_Id"));
		return address;
	}

}
