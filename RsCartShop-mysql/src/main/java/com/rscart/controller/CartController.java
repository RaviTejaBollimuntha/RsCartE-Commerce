package com.rscart.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rscart.constants.ControllerConstants;
import com.rscart.model.Customer;
import com.rscart.service.CartData;
import com.rscart.service.CartService;
import com.rscart.service.CouponSevice;
import com.rscart.service.LocationData;
import com.rscart.util.CitiList;
import com.rscart.util.CountryList;
import com.rscart.util.SessionUtils;
import com.rscart.util.StateList;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private LocationData locdata;
	@Autowired
	private CouponSevice couponservice;
	private Logger logger=LoggerFactory.getLogger(CartController.class);
	private final static String cartPage = "cart";
	private final static String redirectView = "redirect:/cart";

	/**
	 * Method to Add Products to the Shopping Cart First Check if the Product is
	 * available in the Wishlist, if available, remove the product from Wishlist
	 * 
	 * @author RaviTeja Bollimuntha
	 * 
	 * @param ProductID
	 * @param HttpServletRequest
	 * @return Product Page View
	 */
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String addProducts(Model model,
			@RequestParam(value = "productId") Long productId,
			HttpServletRequest request) {
		logger.info("add products into cart");
		// When a customer adds a product to the cart, we have to check
		// if he is a registered or an anonymous customer.
		Customer customer = SessionUtils.getSessionVariables(request,
				ControllerConstants.CUSTOMER);
		
		if (customer != null) {
			// Customer is anonymous, so create a shared cart and add it to
			// session
			// Creates a new cart for the anonymous customer
			
			CartData anonymousCartData = cartService.getShoppingCart();
			SessionUtils.setSessionVariables(anonymousCartData, request,
					ControllerConstants.CART);
			cartService.addProduct(anonymousCartData, productId);
		} else {

			CartData customerCartData = null;
			customerCartData = SessionUtils.getSessionVariables(request,
					ControllerConstants.CART);
			if (customerCartData == null) {
				customerCartData = cartService.getShoppingCart();
				SessionUtils.setSessionVariables(customerCartData, request,
						ControllerConstants.CART);
				cartService.addProduct(customerCartData, productId);
			} else {
				cartService.addProduct(customerCartData, productId);
			}
			// TODO: Extend the add to cart functionality

			// When the customer is registered, cart contents must be
			// stored in the database, and stored in the session.
		}
		return getRedirectview();

	}

	/**
	 * Method to View the Items of Shopping Cart Retrieves the items to display
	 * in the shopping cart page
	 * 
	 * @author RaviTeja Bollimuntha
	 * 
	 * @param Model
	 * @param ProductID
	 * @param HttpServletRequest
	 * @return Shopping Cart View
	 */
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String viewCart(Model model, HttpServletRequest request) {
		CartData cartData = SessionUtils.getSessionVariables(request,
				ControllerConstants.CART);
		if(cartData!=null)
		cartData.setCouponvalue(0);
		return getCartpage();
	}

	/**
	 * Method to Update the shopping cart page
	 * 
	 * @author RaviTeja Bollimuntha
	 * 
	 * @param Model
	 * @param ProductID
	 * @param HttpServletRequest
	 * @return Shopping Cart View
	 */

	// TODO- Implement BindingResult and FormValidations
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCart(Model model, HttpServletRequest request) {
		Long productId = Long.parseLong(request.getParameter("productid"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		CartData cartData = SessionUtils.getSessionVariables(request,
				ControllerConstants.CART);
		cartService.updateProduct(cartData, productId, quantity);
		return "redirect:/cart";
	}

	/**
	 * Method to Remove the Products from shopping cart
	 * 
	 * @author RaviTeja Bollimuntha
	 * 
	 * @param Model
	 * @param ProductID
	 * @param HttpServletRequest
	 * @return Shopping Cart View
	 */
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String removeProduct(
			@RequestParam(value = "productId") Long productId, Model model,
			HttpServletRequest request) {
		CartData cartData = SessionUtils.getSessionVariables(request,
				ControllerConstants.CART);
		cartService.removeProduct(cartData, productId);
		return getRedirectview();
	}

	/**
	 * Method to Clear the Products from shopping cart
	 * 
	 * @author RaviTeja Bollimuntha
	 * 
	 * @param Model
	 * @param ProductID
	 * @param HttpServletRequest
	 * @return Shopping Cart View
	 */
	@RequestMapping(value = "/clear", method = RequestMethod.GET)
	public String clearCart(Model model, HttpServletRequest request) {
		CartData cartData = SessionUtils.getSessionVariables(request,
				ControllerConstants.CART);
		cartService.clearCart(cartData);
		return getRedirectview();
	}
	@RequestMapping(value = "/coupon", method = RequestMethod.POST)
	public ModelAndView getCoupon(ModelAndView model, HttpServletRequest request,@RequestParam("coupon") String coupon) {
		boolean cvalue=couponservice.checkCoupon(coupon);
		CartData cartData = SessionUtils.getSessionVariables(request,
				ControllerConstants.CART);
		if(cvalue==true) {			
			cartData.setCouponvalue(Integer.parseInt(coupon.substring(coupon.length()-3, coupon.length()-1)));
			model.addObject("check", "1");
		    model.addObject("paid", "Coupon applied successfully");
		}
		else
		{
			cartData.setCouponvalue(0);
	        model.addObject("paid", "Invalid Coupon Entered...");
		}
		model.setViewName("cart");
		return model;
	}
	@RequestMapping(value = "/getciti", method = RequestMethod.GET)
	public @ResponseBody CitiList getCiti(Model model, HttpServletRequest request,@RequestParam("stateId") String state) {
		String number = "";         
        for (int i = 0; i < state.length(); i++) {
               char a = state.charAt(i);
               if (Character.isDigit(a)) {
                     number = number + a;
               } 
        }
		CitiList ct=new CitiList();
	    ct.setCtlist(locdata.getCities(Integer.parseInt(number)));
		return ct;
	}
	@RequestMapping(value = "/getstate", method = RequestMethod.GET)
	public @ResponseBody StateList getState(Model model, HttpServletRequest request,@RequestParam("countryId") String country) {
		
		 String number = "";         
         for (int i = 0; i < country.length(); i++) {
                char a = country.charAt(i);
                if (Character.isDigit(a)) {
                      number = number + a;
                } 
         }
	   StateList st=new StateList();
	    st.setStlist(locdata.getStates(Integer.parseInt(number)));
		return st;
	}
	@RequestMapping(value = "/getcountry", method = RequestMethod.GET)
	
	public @ResponseBody CountryList getCountry(Model model, HttpServletRequest request) {
		CountryList cl=new CountryList();
	    cl.setConlist(locdata.getCountries());		
		return cl;
	}
	public static String getRedirectview() {
		return redirectView;
	}

	public static String getCartpage() {
		return cartPage;
	}
}