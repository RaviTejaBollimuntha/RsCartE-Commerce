package com.rscart.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.rscart.constants.ControllerConstants;
import com.rscart.model.AddressForm;
import com.rscart.model.CreditCardForm;
import com.rscart.model.Customer;
import com.rscart.model.Order;
import com.rscart.model.Product;
import com.rscart.model.ShippingForm;
import com.rscart.service.AddressService;
import com.rscart.service.CartData;
import com.rscart.service.CartService;
import com.rscart.service.OrderService;
import com.rscart.service.PaymentService;
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
    private JavaMailSender emailSender;
	@Autowired
    private AddressService addressService;

    @Autowired
    private SpringTemplateEngine templateEngine;
	@SuppressWarnings("unused")
	private HttpSession session;

	@RequestMapping(value = "/createOrderByCC", method = RequestMethod.POST)
	public String createOrder(Model model,
			@ModelAttribute("paymentForm") CreditCardForm creditCardForm,
			HttpServletRequest request, HttpServletResponse response) throws ParseException,
			IOException, MessagingException {

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
		AddressForm billingaddress=addressService.getPermentAddressByCustomerId(customer.getCustomerId());
		CartData customerCartData = SessionUtils.getSessionVariables(request,ControllerConstants.CART);
		 Map<String, Object> emodel = new HashMap<String, Object>();
	        emodel.put("name", customer.getFirstName()+" "+customer.getLastName());
	        emodel.put("email", customer.getEmailAddress());
	        emodel.put("shippingaddress",shippingAddress);
	        emodel.put("billingaddress",billingaddress);
	        emodel.put("order",order);
	        emodel.put("cartdata",customerCartData);
	        sendConfirmationEmailMessage(emodel,customerCartData);
		return "redirect:order";
	}

	public void payAmountByCreditCard(CreditCardForm creditCardForm,
			HttpServletRequest request) throws IOException {

		creditCardForm = paymentService.gatherCardDetails(creditCardForm,
				request);
		paymentService.transferMoney(creditCardForm.getAccountNumber(), creditCardForm.getAmount());
		paymentService.payByCreditCard(creditCardForm);
	}

    public void sendConfirmationEmailMessage(Map<String,Object> model,CartData CartData) throws MessagingException, IOException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        //helper.addAttachment("logo.png", new ClassPathResource("logo.png"));
        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("email-template", context);

        helper.setTo(model.get("email").toString());
        helper.setText(html, true);
        FileSystemResource rs=null;
        rs=new FileSystemResource(new File(System.getProperty("user.dir")+"\\src\\main\\webapp\\resources\\images\\logo.png"));
        helper.addInline("logo", rs);
        List<Product> plist=CartData.getProductsList();
        for(Product p:plist) {
        		rs=new FileSystemResource(new File(System.getProperty("user.dir")+"\\src\\main\\webapp\\resources\\images\\"+p.getProductId()+".jpg"));
        		helper.addInline(p.getProductId().toString(), rs);
        }
        helper.setSubject("RsCart Shopping order Confirmation Status");
        helper.setFrom("rscartsite@gmail.com");

        emailSender.send(message);
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
