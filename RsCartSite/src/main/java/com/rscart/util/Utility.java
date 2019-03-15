package com.rscart.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.rscart.model.AddressForm;
import com.rscart.model.Customer;
import com.rscart.model.ShippingForm;

public class Utility {

	public static Long generateOrderNumber(Date date, Customer customer) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		String formattedDate = dateFormat.format(date);
		Long orderId = Long.parseLong(formattedDate)
				* (customer.getCustomerId());
		return orderId;
	}

	public static Long generateAddressNumber(AddressForm address,
			Customer customer) {
		return (long) (Long.parseLong(address.getZipCode())
				* customer.getCustomerId() * Math.random());
	}

	public static Long generateShippingNumber(ShippingForm shippingAddress, Customer customer) {
		return(long) (Long.parseLong(shippingAddress.getZipCode())
				* customer.getCustomerId() * Math.random());
	}
}