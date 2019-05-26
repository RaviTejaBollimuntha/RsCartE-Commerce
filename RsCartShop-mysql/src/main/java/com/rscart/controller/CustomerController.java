package com.rscart.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rscart.constants.ControllerConstants;
import com.rscart.model.Customer;
import com.rscart.service.CartData;
import com.rscart.service.CartService;
import com.rscart.service.CustomerService;
import com.rscart.service.TokenService;
import com.rscart.util.SessionUtils;


@Controller
public class CustomerController {

	private HttpSession session;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private TokenService tokenService;
	private String changeAccDetailsPage = "template/accountInformation";
	/**
	 * This method used to Validate the customer and login to the application
	 * 
	 * If the user wants to login after adding items into the shopping cart, by
	 * clicking on Checkout Link, the user will be redirected to checkout page
	 * else the user will be redirected to home page.
	 * 
	 * @param model
	 * @param request
	 * @return checkout/home page
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkForUserLogin(
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "password", required = true) String password,
			Model model, HttpServletRequest request,RedirectAttributes redir) {
		Customer customer = validateCustomer(userName, password);
		session = SessionUtils.createSession(request);
		CartService cartService = SessionUtils.getSessionVariables(request,
				"cartInfo");
		if(customer!=null){
			if(customer.getLogStatus()==1){
				SessionUtils.setSessionVariables(customer, request, "customer");
		    }
		}
		if (cartService != null && customer != null) {
			if(customer.getLogStatus()==1){
			CartData cartData = SessionUtils.getSessionVariables(request, ControllerConstants.CART);
			int numberOfItems = cartService.getNumberOfItems(cartData);
			model.addAttribute("numberOfItems", numberOfItems);
			return "redirect:checkout";
			}else {
				redir.addFlashAttribute("loginStatus", "your not terminated session properly.. please wait some time or login later..!");
				return "redirect:login";
			}
			
		} else if (customer != null) {
			if(customer.getLogStatus()==1){
			model.addAttribute("status", "home");
			return "redirect:home";
			}else {
				redir.addFlashAttribute("loginStatus", "your not terminated session properly.. please wait some time or login later..!");
				return "redirect:login";
			}
		} else {
			redir.addFlashAttribute("loginStatus", "Please provide valid UserName and Password..!");
		}
		return "redirect:login";

	}

	private Customer validateCustomer(String userName, String password) {
		Customer customer = customerService.validateUsers(userName, password);
		return customer;
	}

	/**
	 * This method used to Register the Customer in Application On successfully
	 * registration, a unique key will be generated and stored in the database.
	 * 
	 * An Activation email is sent to the customer's emailID and if the user
	 * clicks on the link which contains the activation key, the customer will
	 * be activated.
	 * 
	 * @param customer
	 * @param model
	 * @param request
	 * @return login
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String registerUser() {
		return "signup";
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("customerForm") @Valid Customer customer,BindingResult error, Model model,
			RedirectAttributes redir, HttpServletRequest request) {
		if (error.hasErrors()){
			//System.out.println(error.getErrorCount());
            return "signup";
        }
		if (validateCustomer(customer.getUserName(), customer.getPassword()) == null) {
			long result = customerService.registerUser(customer);
			if (result > 0) {
				
				customer.setCustomerId(result);
				//String appUrl = request.getRemoteHost();
				InetAddress inetAddress=null;
				try {
					 inetAddress = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {					
					e.printStackTrace();
				}
				String appUrl = inetAddress.getHostAddress();
		        String appPort = String.valueOf(request.getServerPort());
		        if (!appPort.trim().equals("")) {
		            appUrl = appUrl + ":" + appPort+"/"+request.getContextPath();
		        }                 
		        tokenService.createEmailConfirmToken(customer, appUrl);
			}
			redir.addFlashAttribute("result", result);
		} else {
			redir.addFlashAttribute("regStatus", "FAIL");
		}
		redir.addFlashAttribute("registerFlag", true);
		return "redirect:login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(HttpServletRequest request, Model model) {
		Boolean registerFlag = (Boolean) model.asMap().get("registerFlag");
		Long result = (Long) model.asMap().get("result");
		if (registerFlag != null && registerFlag != false) {
			// String regStatus = (String) model.asMap().get("regStatus");
			if (result != null && result != 0) {
				return "redirect:successSignUp";
			} else {
				return "redirect:failureSignUp";
			}
		} else {
			model.addAttribute("loginStatus",  model.asMap().get("loginStatus"));
			return "login";
		}
	}
	@RequestMapping(value = "/change-account", method = RequestMethod.GET)
	public String getChangePasswordPage(HttpServletRequest request,
			Model model, Boolean flag) {
		model.addAttribute("page", changeAccDetailsPage);
		if (flag != null) {
			model.addAttribute("flag", flag);
		}
		return "account";
	}


	@RequestMapping(value = "/updatecustdetails", method = RequestMethod.POST)
	public String updateCustomerDetails(HttpServletRequest request,
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "firstName", required = true) String firstName,
			@RequestParam(value = "lastName", required = true) String lastName,
			@RequestParam(value = "phoneNumber", required = true) String phone,
			Model model,RedirectAttributes redirectAttributes) {
		     session = SessionUtils.createSession(request);
	         Customer customer = SessionUtils.getSessionVariables(request,"customer");
	         customer.setUserName(userName);
	         customer.setFirstName(firstName);
	         customer.setLastName(lastName);
	         customer.setPhoneNumber(phone);
	         int value=customerService.upadateUser(customer);
	         redirectAttributes.addFlashAttribute("flag", value);
	 		 return "redirect:/change-account";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) {
		session = SessionUtils.createSession(request);
		Customer customer = SessionUtils.getSessionVariables(request, "customer");
		if(customer!=null){
		customerService.updateLogStatus(customer);
		}
		SessionUtils.removeSessionVariables("customer", request);
		session.invalidate();
		return "redirect:home";
	}

	@RequestMapping(value = "/successSignUp", method = RequestMethod.GET)
	public String signupSuccess(Model model) {
		model.addAttribute("result", 1);
		return "login";
	}

	@RequestMapping(value = "/failureSignUp", method = RequestMethod.GET)
	public String signupFailure(Model model) {
		model.addAttribute("result", 0);
		return "login";
	}

}
