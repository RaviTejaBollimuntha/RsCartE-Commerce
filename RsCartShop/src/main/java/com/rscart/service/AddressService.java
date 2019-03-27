package com.rscart.service;

import com.rscart.model.AddressForm;
import com.rscart.model.Customer;
import com.rscart.model.ShippingForm;

public interface AddressService {
	public boolean saveAddress(AddressForm address,Customer customer);
	AddressForm getPermentAddressByCustomerId(Long customerid);
	ShippingForm getAddressById(Long addressId);
	ShippingForm getAddressByCustomerId(Long customerid);
	public void saveShippingAddress(ShippingForm shippingAddress, Customer customer);
	public boolean updateAddress(AddressForm address, Customer customer);
	public void updateShippingAddress(ShippingForm shippingAddress, Customer customer);
	ShippingForm getShippmentAddressById(Long shippingId);
}
