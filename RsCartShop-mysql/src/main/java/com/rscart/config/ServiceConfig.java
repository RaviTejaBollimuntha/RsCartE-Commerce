package com.rscart.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@ComponentScan(basePackages= {"com.rscart.service","com.rscart.event.listener"})
public class ServiceConfig {
	@Bean
    public PasswordEncoder userPasswordEncoder() {
	        return new BCryptPasswordEncoder(8);
	    }
	@Bean
	public JavaMailSenderImpl javaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    Properties mailProperties = new Properties();
	    mailProperties.put("mail.smtp.auth", true);
	    mailProperties.put("mail.smtp.starttls.enable", true);
	    mailProperties.put("mail.smtp.ssl.trust","smtp.gmail.com");
	    mailSender.setJavaMailProperties(mailProperties);
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);	    
	    mailSender.setUsername("rscartsite");
	    mailSender.setPassword("2181229205101");
	    return mailSender;
	}
}
