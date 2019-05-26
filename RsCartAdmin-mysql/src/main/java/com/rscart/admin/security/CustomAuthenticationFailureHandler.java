package com.rscart.admin.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
        if(exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
        	RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
        	redirectStrategy.sendRedirect(request, response,"/login?error");
        } else if(exception.getClass().isAssignableFrom(SessionAuthenticationException.class)) {
        	RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
        	redirectStrategy.sendRedirect(request, response,"/error");
        }
		
		
	}
}