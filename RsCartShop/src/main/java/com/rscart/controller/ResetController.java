package com.rscart.controller;

import java.io.IOException;
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

import com.rscart.model.Customer;
import com.rscart.service.TokenService;
import com.rscart.util.EmailResetDTO;
import com.rscart.util.PasswordForgotDTO;
import com.rscart.util.SessionUtils;


@Controller
public class ResetController {
	
	    private final TokenService tokenService;
	    private HttpSession session;

	    @Autowired
	    public ResetController(TokenService tokenService) {
	        this.tokenService = tokenService;       
	    }
	    @RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET, params = "token")
	    public String activateAccount(@RequestParam("token") String token,Model model) {	    	
	        tokenService.validateAccount(token);
	        model.addAttribute("activated", "your Account activated successfully...Please login with your account");
	        return "login";

	    }
	    @RequestMapping(value = "resetemail", method = RequestMethod.GET)
	    public String changeEmail(HttpServletRequest request, Model model,Boolean flag) {
			session = SessionUtils.createSession(request);
	    	model.addAttribute("page", "template/emailchange");
	    	EmailResetDTO resetemail=new EmailResetDTO();
	    	model.addAttribute("resetemail",resetemail);
			if (flag != null) {
				model.addAttribute("flag", flag);
			}
	        return "account";

	    }
	    @RequestMapping(value = "resetemail", method = RequestMethod.POST)
	    public String changeemail(@ModelAttribute("resetemail") @Valid EmailResetDTO resetemail, BindingResult bindingResult, HttpServletRequest request,Model model) throws IOException {
	    	if (bindingResult.hasErrors()) {
	            return "redirect:resetemail";
	        }
	    	session = SessionUtils.createSession(request);
			Customer customer = (Customer) session.getAttribute("customer");
			String result=null;
			if(customer!=null && customer.getPassword().equals(resetemail.getPassword())) {
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
		        result=tokenService.createEmailResetToken(customer,resetemail, appUrl);
			}
			model.addAttribute("page", "template/emailchange");
			model.addAttribute("tokenresult",result);				
	        return "account";

	    }

	    @RequestMapping(value = "emailResetConfirm", method = RequestMethod.GET, params = "token")
	    public String confirmEmailChange(@RequestParam("token") String token,HttpServletRequest request,Model model) {
	        tokenService.validateEmail(token);
	        SessionUtils.removeSessionVariables("customer", request);
	        model.addAttribute("activated", "your Email Reseted successfully...Please login with your account");
	        return "login";

	    }	   

	    @RequestMapping(value = "/account-password-forgot", method = RequestMethod.GET)
	    public String forgotPasswordConfirm() {	        
	        return "pwdforgot";

	    }
	    @RequestMapping(value = "/account-password-forgot", method = RequestMethod.POST)
	    public String forgotPwdRequest(@RequestParam(value = "email", required = true) String email, HttpServletRequest request,Model model) throws IOException {
	        
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
	        String result=tokenService.createPasswordResetToken(email, appUrl);
	        model.addAttribute("sent",result );
	        return "pwdforgot";
	    }
	    
	    @RequestMapping(value = "/passwordResetConfirm", method = RequestMethod.GET, params = "token")
	    public String forgotPwdChangeconfirm(@RequestParam("token") String token,Model model) {	
	    	Long customerid=tokenService.validateForgotPasswordConfirm(token);
	    	PasswordForgotDTO pwdreset=new PasswordForgotDTO();
	    	pwdreset.setCustomerid(customerid);
	    	model.addAttribute("pwdreset", pwdreset);
	        return "pwdreset";
	    }
	    @RequestMapping(value = "/passwordResetConfirm", method = RequestMethod.POST)
	    public String forgotPwdChangeconfirm(@ModelAttribute("pwdreset") @Valid PasswordForgotDTO pwdreset, BindingResult bindingResult, HttpServletRequest request,Model model) {
	        if (bindingResult.hasErrors()) {	            
	            return "pwdreset";
	        }
	        String reseted=tokenService.UpdateNewPassword(pwdreset);
	        model.addAttribute("reseted", reseted);
	        return "login";
	    }

}
