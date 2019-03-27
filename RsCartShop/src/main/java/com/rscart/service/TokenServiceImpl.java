package com.rscart.service;

import java.security.Principal;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rscart.listener.OnEmailResetRequestEvent;
import com.rscart.listener.OnPasswordForgotRequestEvent;
import com.rscart.listener.OnRegistrationCompleteEvent;
import com.rscart.model.Customer;
import com.rscart.repository.TokenRepository;
import com.rscart.util.EmailResetDTO;
import com.rscart.util.EmailResetToken;
import com.rscart.util.PasswordForgotDTO;
import com.rscart.util.VerificationToken;

@Service
public class TokenServiceImpl implements TokenService, ApplicationEventPublisherAware {
	private PasswordEncoder passwordEncoder;
	private ApplicationEventPublisher eventPublisher;
	private TokenRepository TokenRepository;

	@Autowired
	public TokenServiceImpl( PasswordEncoder passwordEncoder, TokenRepository TokenRepository) {
		this.passwordEncoder = passwordEncoder;		
		this.TokenRepository = TokenRepository;
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher = applicationEventPublisher;

	}

	@Override
	public void createEmailConfirmToken(Customer user, String requestUrl) {
		eventPublisher.publishEvent(new OnRegistrationCompleteEvent(this, user, requestUrl));
	}
	@Override
	public void validateAccount(String token) {
		VerificationToken verificationToken = TokenRepository.findByVerToken(token);
		if (verificationToken == null) {
			throw new IllegalArgumentException("Null verification token");
		}			  
		  Calendar cal = Calendar.getInstance(); 
		  if ((verificationToken.getExpiryDate().getTime() -cal.getTime().getTime()) <= 0) 
		  { 
			  throw new IllegalArgumentException("Token is expired"); 
		  }	
		  Long customerid = verificationToken.getCustomerid();		   
		  TokenRepository.deleteVerToken(verificationToken);
		  if(customerid!=null)
		  TokenRepository.updatecustomerActive(customerid);
		 
	}

	
	@Override
	public String createPasswordResetToken(String email, String requestUrl) {
		
		  Customer user = TokenRepository.findByEmail(email);
		  if (user == null) {
			  return "wrong user name/email";
		  }
		  eventPublisher.publishEvent(new OnPasswordForgotRequestEvent(this,user, requestUrl));
		  return "Sent rest link to your register email.."+user.getEmailAddress() +" successfully ";
		 
	}
	@Override
	public Long validateForgotPasswordConfirm(String token) {
		VerificationToken verificationToken = TokenRepository.findByVerToken(token);
		if (verificationToken == null) {
			throw new IllegalArgumentException("Null verification token");
		}			  
		  Calendar cal = Calendar.getInstance(); 
		  if ((verificationToken.getExpiryDate().getTime() -cal.getTime().getTime()) <= 0) 
		  { 
			  throw new IllegalArgumentException("Token is expired"); 
		  }	
		  Long customerid = verificationToken.getCustomerid();     
		  if(customerid!=null)
			 TokenRepository.deleteVerToken(verificationToken);
		  return customerid;
	}

	@Override
	public String UpdateNewPassword(PasswordForgotDTO passwordForgotDTO) {
		
		
		int result=TokenRepository.updatePwdWithID(passwordForgotDTO.getCustomerid(),passwordForgotDTO.getNewPassword());
        if(result==1)
        	return "your password successfully reseted...please login with your account";
        else
        	return "your password reset action failed!..";
        }
	
	
	@Override
	public String createEmailResetToken(Customer customer,EmailResetDTO emailResetDTO, String requestUrl) {
		eventPublisher.publishEvent(new OnEmailResetRequestEvent(this,customer,requestUrl,emailResetDTO.getNewEmail()));
		  return "Sent rest link to your register email.."+emailResetDTO.getNewEmail() +" successfully ";
	 }

	

	@Override
	public void validateEmail(String token) {
		EmailResetToken emailToken = TokenRepository.findByEmailToken(token);
		if (emailToken == null) {
			throw new IllegalArgumentException("Null verification token");
		}			  
		  Calendar cal = Calendar.getInstance(); 
		  if ((emailToken.getExpiryDate().getTime() -cal.getTime().getTime()) <= 0) 
		  { 
			  throw new IllegalArgumentException("Token is expired"); 
		  }	
		  int result=TokenRepository.updateNewEmail(emailToken.getEmail(),emailToken.getCustomerid());
		  if(result!=0)
		  TokenRepository.deleteEmailToken(emailToken);   
	}

}
	
	
	
