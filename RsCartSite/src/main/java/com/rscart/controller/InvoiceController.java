package com.rscart.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rscart.invoice.InvoiceUtil;
import com.rscart.model.AddressForm;
import com.rscart.model.Customer;
import com.rscart.model.InvoiceOrderItem;
import com.rscart.model.Order;
import com.rscart.model.ShippingForm;
import com.rscart.service.AddressService;
import com.rscart.service.MailSenderService;
import com.rscart.service.OrderService;
import com.rscart.util.SessionUtils;

@Controller
public class InvoiceController {

	private static String orderHistoryPage = "template/ordersList";
	private static String orderDetailsPage = "template/orderDetails";
	@SuppressWarnings("unused")
	private HttpSession session;
	@Autowired
	private OrderService orderService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private JavaMailSender  mailSenderService;

	@RequestMapping(value = "/invoicetoemail", method = RequestMethod.GET)
	public String getOrderHistoryPage(HttpServletRequest request, Model model,Map<String, Object> map,@RequestParam(value = "id") Long id,HttpServletResponse response) {
		model.addAttribute("page", orderHistoryPage);
		session = SessionUtils.createSession(request);
		Customer customer = SessionUtils.getSessionVariables(request, "customer");
		Order order = orderService.getOrderById(id);
		ShippingForm address = addressService.getShippmentAddressById(order
				.getShippingId());
		List<InvoiceOrderItem> orderItemsList = orderService.getOrderItems(order);
		AddressForm customeraddress=addressService.getPermentAddressByCustomerId(order.getCustomerId());
		map.put("order", order);
		map.put("customeraddresss", customeraddress);
		map.put("addressDetails", address);
		map.put("orderItemsList", orderItemsList);		
		InvoiceUtil.emailInvoice(map,mailSenderService,request,customer.getEmailAddress());
		model.addAttribute("sentemail","requeried Invoice sent to your Email successfully!..");
		return "account";
	}

	@RequestMapping(value = "/invoice", method = RequestMethod.GET)
	public String getOrderDetails(HttpServletRequest request, Model model,
			@RequestParam(value = "id") Long id) {
		
		Order order = orderService.getOrderById(id);
		ShippingForm address = addressService.getShippmentAddressById(order
				.getShippingId());
		List<InvoiceOrderItem> orderItemsList = orderService.getOrderItems(order);
		AddressForm customeraddress=addressService.getPermentAddressByCustomerId(order.getCustomerId());
		model.addAttribute("order", order);
		model.addAttribute("customeraddresss", customeraddress);
		model.addAttribute("addressDetails", address);
		model.addAttribute("orderItemsList", orderItemsList);		
		return "invoiceView";
	}

}