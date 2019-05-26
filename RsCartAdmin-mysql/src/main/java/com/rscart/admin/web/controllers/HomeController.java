package com.rscart.admin.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rscart.catalog.CatalogService;
import com.rscart.customers.CustomerService;
import com.rscart.entities.Customer;
import com.rscart.entities.Order;
import com.rscart.entities.Product;
import com.rscart.orders.OrderService;
import com.rscart.review.ReviewService;

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
	@Autowired
	protected OrderService orderService;
	@Autowired
	protected ReviewService reviewService;
	
	@Override
	protected String getHeaderTitle() {
		return "Home";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		List<Customer> list = customerService.getAllCustomers();
		List<Order> orders = orderService.getAllOrders();
		List<Order> Recentorders = orderService.getLastestedOrders();
		Long totalamount=0L;
		for(Order order:orders)
		{
		  totalamount+=order.getSalecost();	
		}
		model.addAttribute("orders", orders.size());
		model.addAttribute("sales", totalamount);
		model.addAttribute("users", list.size());
		model.addAttribute("visitors", catalogService.getHitCount());
		model.addAttribute("products", catalogService.getLastestedProducts());
		model.addAttribute("reviews", reviewService.getLastestedReviews());
		model.addAttribute("ordershistory",Recentorders);
		return "home";
	}

}
