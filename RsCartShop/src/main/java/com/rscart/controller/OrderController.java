package com.rscart.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rscart.constants.ControllerConstants;
import com.rscart.model.AddressForm;
import com.rscart.model.CreditCardForm;
import com.rscart.model.Customer;
import com.rscart.model.Order;
import com.rscart.model.Product;
import com.rscart.model.ShippingForm;
import com.rscart.service.CartData;
import com.rscart.service.CartService;
import com.rscart.service.MailSenderService;
import com.rscart.service.OrderService;
import com.rscart.service.PaymentService;
import com.rscart.service.ProductConfigService;
import com.rscart.util.SessionUtils;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductConfigService productConfigService;
	@Autowired
	private MailSenderService mailSenderService;
	@SuppressWarnings("unused")
	private HttpSession session;

	@RequestMapping(value = "/createOrderByCC", method = RequestMethod.POST)
	public String createOrder(Model model,
			@ModelAttribute("paymentForm") CreditCardForm creditCardForm,
			HttpServletRequest request, HttpServletResponse response) throws ParseException,
			IOException {

		session = SessionUtils.createSession(request);
		// Retrieve Details about the Cart,Customer and Address Details
		// used to create detailed Order
		Customer customer = SessionUtils.getSessionVariables(request,
				"customer");
		ShippingForm shippingAddress = SessionUtils.getSessionVariables(request,
				"shippingAddress");

		Order order = orderService.createOrder(cartService, customer, shippingAddress,request);
		payAmountByCreditCard(creditCardForm, request);

		SessionUtils.setSessionVariables(order, request, "orderDetails");
		List<Product> productsList = orderService.getAllOrderItems(order);
		StringBuffer sb = new StringBuffer();
		sb.append("Hello " + customer.getUserName() + "\n");
		sb.append("Thank you for shopping at RS-Shopper.Happy Shopping!!\n");
		sb.append("OrderId-" + order.getOrderId() + "/n");
		sb.append("Products-/n");
		for (Product p : productsList) {
			sb.append(p.getName() + "  Rs." + p.getPrice() + "\n");
		}
		sb.append("Your Order Status is: " + order.getOrderStatus());
		sb.append("You will get further notification.Once your order is processed");
		mailSenderService.sendEmail(customer.getEmailAddress(),
				customer.getUserName(), sb.toString(),
				"Order Confirmation for " + customer.getUserName());
		return "redirect:order";
	}

	public void payAmountByCreditCard(CreditCardForm creditCardForm,
			HttpServletRequest request) throws IOException {

		creditCardForm = paymentService.gatherCardDetails(creditCardForm,
				request);
		paymentService.transferMoney(creditCardForm.getAccountNumber(), creditCardForm.getAmount());
		paymentService.payByCreditCard(creditCardForm);
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String getOrderConfirmPage(Model model, HttpServletRequest request) {
		Order order = SessionUtils.getSessionVariables(request, "orderDetails");
		model.addAttribute("orderDetails", order);
		List<Product> productsList = orderService.getAllOrderItems(order);
		model.addAttribute("prodList", productsList);
		CartData cartData = SessionUtils.getSessionVariables(request, ControllerConstants.CART);		
		cartService.clearCart(cartData);
		return "order";
	}
}
