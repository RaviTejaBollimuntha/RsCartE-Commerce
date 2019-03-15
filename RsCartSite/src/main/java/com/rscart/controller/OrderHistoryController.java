package com.rscart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rscart.model.AddressForm;
import com.rscart.model.Customer;
import com.rscart.model.Order;
import com.rscart.model.Product;
import com.rscart.model.ShippingForm;
import com.rscart.service.AddressService;
import com.rscart.service.OrderService;
import com.rscart.util.SessionUtils;

@Controller
public class OrderHistoryController {

	private static String orderHistoryPage = "template/ordersList";
	private static String orderDetailsPage = "template/orderDetails";
	@SuppressWarnings("unused")
	private HttpSession session;
	@Autowired
	private OrderService orderService;
	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/orderHistory", method = RequestMethod.GET)
	public String getOrderHistoryPage(HttpServletRequest request, Model model) {
		model.addAttribute("page", orderHistoryPage);
		session = SessionUtils.createSession(request);
		Customer customer = SessionUtils.getSessionVariables(request, "customer");
		if (customer != null) {
			List<Order> orderList = orderService
					.getAllOrdersForCustomer(customer);
			Map<List<Order>, List<Product>> orderMap = new HashMap<List<Order>, List<Product>>();
			for (Order o : orderList) {
				List<Product> orderItemsList = orderService.getAllOrderItems(o);
				orderMap.put(orderList, orderItemsList);
			}
			model.addAttribute(orderList);
		}
		return "account";
	}

	@RequestMapping(value = "/orderDetail", method = RequestMethod.GET)
	public String getOrderDetails(HttpServletRequest request, Model model,
			@RequestParam(value = "id") Long id) {
		
		Order order = orderService.getOrderById(id);
		ShippingForm address = addressService.getShippmentAddressById(order
				.getShippingId());
		List<Product> orderItemsList = orderService.getAllOrderItems(order);
		model.addAttribute("order", order);
		model.addAttribute("addressDetails", address);
		model.addAttribute("orderItemsList", orderItemsList);
		model.addAttribute("page", orderDetailsPage);
		return "account";
	}

}