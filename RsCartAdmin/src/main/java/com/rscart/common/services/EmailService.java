/**
 * 
 */
package com.rscart.common.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.rscart.exception.RsCartException;


/**
 * @author Siva
 *
 */
@Component
public class EmailService 
{
	private static final RsCLogger logger = RsCLogger.getLogger(EmailService.class);
	
	@Autowired JavaMailSender javaMailSender;
	
	@Value("${support.email}") String supportEmail;
	
    public void sendEmail(String to, String subject, String content)
	{
        try
		{
        	// Prepare message using a Spring helper
            final MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
            message.setSubject(subject);
            message.setFrom(supportEmail);
            message.setTo(to);
            message.setText(content, true /* isHtml */);
            
			javaMailSender.send(message.getMimeMessage());
		} 
        catch (MailException | MessagingException e)
		{
        	logger.error(e);
			throw new RsCartException("Unable to send email");
		}
	}
	
	
}
