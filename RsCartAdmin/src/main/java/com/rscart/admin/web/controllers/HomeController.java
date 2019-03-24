package com.rscart.admin.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rscart.catalog.CatalogService;
import com.rscart.customers.CustomerService;
import com.rscart.entities.Customer;
import com.rscart.entities.Product;

/**
 * @author RaviTeja Bollimuntha
 *
 */
@Controller
public class HomeController extends RsCartAdminBaseController {
	@Autowired
	private CatalogService catalogService;
	@Autowired 
	private CustomerService customerService;
	
	@Override
	protected String getHeaderTitle() {
		return "Home";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		List<Customer> list = customerService.getAllCustomers();
		model.addAttribute("orders", "1");
		model.addAttribute("sales", "1");
		model.addAttribute("users", list.size());
		model.addAttribute("visitors", "2");
		model.addAttribute("products", catalogService.getLastestedProducts());
		model.addAttribute("reviews", "");
		model.addAttribute("ordershistory", "");
		return "home";
	}

}
