package com.rscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rscart.model.AddressForm;
import com.rscart.model.Customer;
import com.rscart.model.ShippingForm;
import com.rscart.repository.AddressRepository;
import com.rscart.util.Utility;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;

	public boolean saveAddress(AddressForm address, Customer customer) {
		Long addressId = Utility.generateAddressNumber(address, customer);
		address.setAddressId(addressId);
		address.setCustomer_Id(customer.getCustomerId());
		boolean b=addressRepository.saveAddress(address);
		return b;
	}
	@Override
	public ShippingForm getShippmentAddressById(Long shippingId) {
		ShippingForm orderShipmentAddress = addressRepository.readShippmentAddressBySId(shippingId);
		return orderShipmentAddress;
	}
	@Override
	public AddressForm getPermentAddressByCustomerId(Long customerid) {
		return addressRepository.readPermentAddressByCustomerId(customerid);
	}

	@Override
	public List<ShippingForm> getShippmentAddressByCustomerId(Long customerid) {
		return addressRepository.readShippmentAddressByCId(customerid);
	}

	@Override
	public void saveShippingAddress(ShippingForm shippingAddress, Customer customer) {
		Long shippingId = Utility.generateShippingNumber(shippingAddress, customer);
		shippingAddress.setShippingId(shippingId);
		shippingAddress.setCustomer_Id(customer.getCustomerId());
		addressRepository.shippingAddress(shippingAddress);
		
	}

	@Override
	public boolean updateAddress(AddressForm address, Customer customer) {	
		address.setCustomer_Id(customer.getCustomerId());
		return addressRepository.updateAddress(address);
	}

	@Override
	public void updateShippingAddress(ShippingForm shippingAddress, Customer customer) {
		addressRepository.upadateShippingAddress(shippingAddress);
		
	}

}