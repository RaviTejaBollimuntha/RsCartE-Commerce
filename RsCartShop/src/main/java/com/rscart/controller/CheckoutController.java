package com.rscart.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rscart.model.Customer;
import com.rscart.model.ShippingForm;
import com.rscart.service.AddressService;
import com.rscart.service.CartService;
import com.rscart.util.SessionUtils;

@Controller
public class CheckoutController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private AddressService addressService;	

	private HttpSession session;

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkOutCart(Model model, HttpServletRequest request,@RequestParam(value="page",required=false) String page,@RequestParam(value="id",required=false) String shipmentid) {
		session = SessionUtils.createSession(request);
		Customer customer = (Customer) session.getAttribute("customer");
		if (customer != null) {		  
			 @SuppressWarnings("unchecked")
			List<ShippingForm> address = (List<ShippingForm>)session.getAttribute("shipmentAddressList");
			 if(page==null&&shipmentid==null){
			    address = addressService.getShippmentAddressByCustomerId(customer.getCustomerId());
			    if(!address.isEmpty()) {
			    SessionUtils.setSessionVariables(address, request, "shipmentAddressList");
			    SessionUtils.removeSessionVariables("shippingaddress", request);
			    }
			    model.addAttribute("page", "shipmentAddressList");
			 }else {
				 if(shipmentid!=null) {
				 List<ShippingForm> shippingAddressList=address.stream().filter(s -> s.getShippingId()==Long.parseLong(shipmentid.trim())).collect(Collectors.toList());
			     ShippingForm shippingAddress=shippingAddressList.get(0);
			     SessionUtils.setSessionVariables(shippingAddress, request, "shippingaddress");
				 }
				 model.addAttribute("page", "template/address");
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
		if(shippingAddress.getShippingId().equals(address.getShippingId())) { 
		addressService.updateShippingAddress(shippingAddress, customer);
		}
		else
		addressService.saveShippingAddress(shippingAddress, customer);	
		SessionUtils.setSessionVariables(shippingAddress, request, "shippingAddress");
		return "payment";
	
	}


}
