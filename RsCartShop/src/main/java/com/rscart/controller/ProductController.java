package com.rscart.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rscart.constants.ControllerConstants;
import com.rscart.model.Customer;
import com.rscart.model.Product;
import com.rscart.model.ReviewForm;
import com.rscart.service.CartData;
import com.rscart.service.CartService;
import com.rscart.service.CategoryConfigService;
import com.rscart.service.CustomerService;
import com.rscart.service.ProductConfigService;
import com.rscart.service.ReviewService;
import com.rscart.util.SessionUtils;

@Controller
public class ProductController {

	@Autowired
	private CartService cartService;
	@Autowired
	private ProductConfigService productConfigurationService;
	@Autowired
    private CategoryConfigService categoryConfigurationService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private CustomerService customerService;

	/**
	 * Product Controller method which retrieves the information required in the
	 * product page
	 * 
	 * @author RaviTeja Bollimuntha
	 * 
	 * @param Model
	 * @param ProductId
	 * @return Product Page View
	 * @throws ParseException
	 */
	@RequestMapping(value = "/product", method = RequestMethod.GET, params = { "productId" })
	public String handleRequest(Model model,
			@RequestParam(value = "productId") Long productId,
			HttpServletRequest request) throws ParseException {
		Product product = productConfigurationService.getProductById(productId);
		model.addAttribute("product", product);

		CartData cartData = SessionUtils.getSessionVariables(request,ControllerConstants.CART);	
		if(cartData != null)
			model.addAttribute(ControllerConstants.NUMBER_OF_ITEMS, cartData.getNumberOfItems());

		Customer customer = SessionUtils.getSessionVariables(request,
				ControllerConstants.CUSTOMER);
		// Retrieve Reviews of a particular product
		Map<Customer, ReviewForm> reviewMap = new HashMap<Customer, ReviewForm>();
		if (customer != null) {
			List<ReviewForm> reviewsList = reviewService
					.getProductReviews(productId);
			for (ReviewForm reviewForm : reviewsList) {
				Long customerId = reviewForm.getCustomerId();
				reviewMap.put(customerService.getCustomerById(customerId),
						reviewForm);
			}
			model.addAttribute("reviewsList", reviewMap);
		}
		return "product";
	}
}
