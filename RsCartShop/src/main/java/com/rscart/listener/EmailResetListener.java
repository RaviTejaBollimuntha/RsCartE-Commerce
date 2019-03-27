package com.rscart.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.rscart.model.Customer;
import com.rscart.repository.TokenRepository;
import com.rscart.util.EmailResetToken;

@Component
public class EmailResetListener implements ApplicationListener<OnEmailResetRequestEvent> {

	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private JavaMailSender mailSender;
	private final String FROM_ID = "rscartsite@gmail.com";


	@Override
	public void onApplicationEvent(OnEmailResetRequestEvent event) {
		this.confirmRegistration(event);
	}

	private void confirmRegistration(OnEmailResetRequestEvent event) {
		Customer user = event.getCustomer();		
		String token = UUID.randomUUID().toString();
		EmailResetToken resettoken=new EmailResetToken();
		resettoken.setToken(token);
		resettoken.setEmail(event.getNewEmail());
		resettoken.setExpiryDate(resettoken.calculateExpiryDate(60 * 24));
		resettoken.setCustomerid(user.getCustomerId());
		tokenRepository.saveEmailToken(resettoken);

		String recipientAddress = event.getNewEmail();
		String subject = "RsCart Email Reset Confirmation";
		String confirmationUrl = event.getAppUrl() + "/emailResetConfirm?token=" +token;
		String message = "Hi ,\n\nPlease confirm your new e-mail with this link.";

		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom(FROM_ID);
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message + "\n\n" +"http://"+ confirmationUrl + "\n\nThanks,\n RsCart Team");
		mailSender.send(email);
 }
}
