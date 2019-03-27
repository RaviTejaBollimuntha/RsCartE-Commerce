package com.rscart.config;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import com.rscart.interceptor.BaseInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.rscart.controller", "com.rscart.interceptor" })
public class WebMvcAppConfig extends WebMvcConfigurerAdapter {
	@Bean
	public HttpSessionListener httpSessionListener() {
		return new HttpSessionListener() {
			@Override
			public void sessionCreated(HttpSessionEvent se) {
				System.out.println("Session Created with session id: " + se.getSession().getId());
				HttpSession session = se.getSession();
				session.setMaxInactiveInterval(1* 60);
			}

			@Override
			public void sessionDestroyed(HttpSessionEvent se) {
				System.out.println("Session Destroyed, Session id: " + se.getSession().getId());
			}
		};
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new BaseInterceptor());
	}

	@Bean
	WebMvcConfigurer configurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
			}
		};
	}

	@Bean
	@Order(1)
	public ResourceBundleViewResolver resourceBundleViewResolver() {
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		resolver.setBasename("views");
		return resolver;
	}

	@Bean
	@Order(2)
	public ViewResolver createIVR() {
		InternalResourceViewResolver ivr = null;
		ivr = new InternalResourceViewResolver();
		ivr.setPrefix("/WEB-INF/views/");
		ivr.setSuffix(".jsp");
		return ivr;
	}
}
