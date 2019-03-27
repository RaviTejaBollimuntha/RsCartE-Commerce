package com.rscart.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.rscart.model.Customer;
import com.rscart.repository.TokenRepository;
import com.rscart.util.VerificationToken;

@Component
public class PasswordForgotListener implements ApplicationListener<OnPasswordForgotRequestEvent> {
	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private JavaMailSender mailSender;
	private final String FROM_ID = "rscartsite@gmail.com";

	@Override
	public void onApplicationEvent(OnPasswordForgotRequestEvent event) {
		this.confirmRegistration(event);
	}

	private void confirmRegistration(OnPasswordForgotRequestEvent event) {
		Customer user = event.getUser();
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setCustomerid(user.getCustomerId());
		verificationToken.setExpiryDate(verificationToken.calculateExpiryDate(60 * 24));
	    tokenRepository.saveVCToken(verificationToken);

	    String recipientAddress = user.getEmailAddress();
		String subject = "RsCart Password Reset Confirmation";
		String confirmationUrl = event.getAppUrl() + "/passwordResetConfirm?token=" + token;
		String message = "Hi ,\n\nPlease reset your password with this link.";

		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom(FROM_ID);
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message + "\n\n" +"http://"+ confirmationUrl + "\n\nThanks,\n RsCart Team");
		mailSender.send(email);
	}
}
