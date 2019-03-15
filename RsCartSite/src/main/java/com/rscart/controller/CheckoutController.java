package com.rscart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rscart.model.AddressForm;
import com.rscart.model.Customer;
import com.rscart.model.ShippingForm;
import com.rscart.service.AddressService;
import com.rscart.service.CartService;
import com.rscart.service.PaymentService;
import com.rscart.service.ProductConfigService;
import com.rscart.util.SessionUtils;

@Controller
public class CheckoutController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private AddressService addressService;	

	private HttpSession session;

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkOutCart(Model model, HttpServletRequest request) {
		session = SessionUtils.createSession(request);
		Customer customer = (Customer) session.getAttribute("customer");
		if (customer != null) {		  
			 ShippingForm address = (ShippingForm) session.getAttribute("shippingaddress");
			 if(address==null){
			    address = addressService.getAddressByCustomerId(customer.getCustomerId());			   
			    SessionUtils.setSessionVariables(address, request, "shippingaddress");			    
			 }
  		return "checkout";
		} else {
			SessionUtils.setSessionVariables(cartService,request,"cartInfo");			
			return "login";
		}
	}

	

	@RequestMapping(value = "/address", method = RequestMethod.POST)
	public String ShippingAddressInfo(
			@ModelAttribute("shippingAddress") ShippingForm shippingAddress, Model model,
			HttpServletRequest request) {
		session = SessionUtils.createSession(request);
		Customer customer = SessionUtils.getSessionVariables(request, "customer");
		 ShippingForm address = (ShippingForm) session.getAttribute("shippingaddress");
		if(shippingAddress.equals(address)) { 
			shippingAddress.setShippingId(address.getShippingId());
		addressService.updateShippingAddress(shippingAddress, customer);
		}
		else
		addressService.saveShippingAddress(shippingAddress, customer);	
		SessionUtils.setSessionVariables(shippingAddress, request, "shippingAddress");
		return "payment";
	
	}


}
