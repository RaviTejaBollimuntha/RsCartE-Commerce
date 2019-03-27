package com.rscart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rscart.model.AddressForm;
import com.rscart.model.Customer;
import com.rscart.model.ShippingForm;
import com.rscart.service.AddressService;
import com.rscart.util.SessionUtils;

@Controller
public class AddressController {
	
	@Autowired
	private AddressService addressService;	

	private HttpSession session;

	private static String changeAddressPage = "template/changeAddress";

	@RequestMapping(value = "/addressDetails", method = RequestMethod.GET)
	public String getAddressDetailsPage(HttpServletRequest request, Model model,Boolean flag) {		
		
		session = SessionUtils.createSession(request);
		Customer customer = (Customer) session.getAttribute("customer");
		if (customer != null) {		  
			 AddressForm address = (AddressForm) session.getAttribute("address");
			 if(address==null){
			    address = addressService.getPermentAddressByCustomerId(customer.getCustomerId());
			   
			    SessionUtils.setSessionVariables(address, request, "address");
			 }
			 model.addAttribute("page", changeAddressPage);
			 if (flag != null) {
					model.addAttribute("flag", flag);
				}
  		     return "account";
		} 
		
		
		model.addAttribute("page", changeAddressPage);
		return "account";
		
		
		
	}
	
	@RequestMapping(value = "/saveaddress", method = RequestMethod.POST)
	public String validateAddressInformation(
			@ModelAttribute("addressForm") AddressForm address, Model model,
			HttpServletRequest request,RedirectAttributes redirectAttributes) {		
		session = SessionUtils.createSession(request);
		Customer customer = SessionUtils.getSessionVariables(request, "customer");
		AddressForm DBaddress = (AddressForm) session.getAttribute("address");
		if(DBaddress==null) {
			boolean flag=addressService.saveAddress(address, customer);
			SessionUtils.setSessionVariables(address, request, "address");
			redirectAttributes.addFlashAttribute("flag", flag);
			return "redirect:addressDetails";
		}
		boolean flag=addressService.updateAddress(address, customer);
		SessionUtils.setSessionVariables(address, request, "address");
		redirectAttributes.addFlashAttribute("flag", flag);
		return "redirect:addressDetails";
	}
}
