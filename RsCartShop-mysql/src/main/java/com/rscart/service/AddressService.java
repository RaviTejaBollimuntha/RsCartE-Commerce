package com.rscart.service;

import java.util.List;

import com.rscart.model.AddressForm;
import com.rscart.model.Customer;
import com.rscart.model.ShippingForm;

public interface AddressService {
	public boolean saveAddress(AddressForm address,Customer customer);
	public AddressForm getPermentAddressByCustomerId(Long customerid);
	public List<ShippingForm> getShippmentAddressByCustomerId(Long customerid);
	public void saveShippingAddress(ShippingForm shippingAddress, Customer customer);
	public boolean updateAddress(AddressForm address, Customer customer);
	public void updateShippingAddress(ShippingForm shippingAddress, Customer customer);
	public ShippingForm getShippmentAddressById(Long shippingId);
}
