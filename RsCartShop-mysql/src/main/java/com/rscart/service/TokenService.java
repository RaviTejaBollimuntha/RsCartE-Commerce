package com.rscart.service;


import com.rscart.model.Customer;
import com.rscart.util.EmailResetDTO;
import com.rscart.util.PasswordForgotDTO;

public interface TokenService {	
	public void createEmailConfirmToken(Customer user, String requestUrl);
	public String createPasswordResetToken(String email, String requestUrl);
	public void validateEmail(String token);	
	public Long validateForgotPasswordConfirm(String token);
	public String UpdateNewPassword(PasswordForgotDTO passwordForgotDTO);	
	public void validateAccount(String token);
	public String createEmailResetToken(Customer customer, EmailResetDTO emailResetDTO, String requestUrl);
}
