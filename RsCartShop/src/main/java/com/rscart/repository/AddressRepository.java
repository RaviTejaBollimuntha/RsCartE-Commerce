package com.rscart.repository;

import java.util.List;

import com.rscart.model.AddressForm;
import com.rscart.model.ShippingForm;

public interface AddressRepository {

	public boolean saveAddress(AddressForm address);	

	public List<ShippingForm> readShippmentAddressByCId(Long customerid);

	//public ShippingForm readAddressByCustomerId(Long customerid);

	public void shippingAddress(ShippingForm shippingAddress);

	public AddressForm readPermentAddressByCustomerId(Long customerid);

	public boolean updateAddress(AddressForm address);

	public void upadateShippingAddress(ShippingForm shippingAddress);

	public ShippingForm readShippmentAddressBySId(Long shippingId);
}
