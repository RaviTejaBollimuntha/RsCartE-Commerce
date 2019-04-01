package com.rscart.config;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.StandardTemplateModeHandlers;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.rscart.interceptor.BaseInterceptor;
import com.rscart.repository.CustomerRepository;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.rscart.controller", "com.rscart.interceptor" })
public class WebMvcAppConfig extends WebMvcConfigurerAdapter {
	@Autowired
	private CustomerRepository cr;
	private Map<String,String> sessionip=new HashMap<>();
	private static final Logger LOGGE = LoggerFactory.getLogger(WebMvcAppConfig.class);
	@Autowired
	private HttpServletRequest request;
	@Bean
	public HttpSessionListener httpSessionListener() {
		return new HttpSessionListener() {
			@Override
			public void sessionCreated(HttpSessionEvent se) {
				LOGGE.info("Session Created with session id: "+se.getSession().getId());				
				InetAddress inetAddress=null;
				try {
					 inetAddress = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {					
					e.printStackTrace();
				}
				String appUrl = inetAddress.getHostAddress()+request.getHeader("user-agent");
				
				if(!sessionip.containsKey(appUrl)) {
				cr.updateHitCount();
				sessionip.put(appUrl,se.getSession().getId());
				}
				HttpSession session = se.getSession();
				session.setMaxInactiveInterval(5* 60);
			}

			@Override
			public void sessionDestroyed(HttpSessionEvent se) {
				LOGGE.info("Session Destroyed, Session id: "+se.getSession().getId());
				while (sessionip.values().remove(se.getSession().getId()));
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
	@Order(1000)
	public ViewResolver createIVR() {
		InternalResourceViewResolver ivr = null;
		ivr = new InternalResourceViewResolver();
		ivr.setPrefix("/WEB-INF/views/");
		ivr.setSuffix(".jsp");
		return ivr;
	}
	@Bean
    public ViewResolver thymeleafViewResolver() {
 
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
 
        viewResolver.setTemplateEngine(thymeleafTemplateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setOrder(0);
 
        // Important!!
        viewResolver.setViewNames(new String[] { "email-*" });
 
        return viewResolver;
    }
 
    // Thymeleaf template engine with Spring integration
    @Bean
    public SpringTemplateEngine thymeleafTemplateEngine() {
 
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
 
        return templateEngine;
    }
 
    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver() {
        return new SpringResourceTemplateResolver();
    }
 
    // Thymeleaf template resolver serving HTML 5
    @Bean
    public ITemplateResolver thymeleafTemplateResolver() {
 
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
 
        templateResolver.setPrefix("templates/");
        templateResolver.setCacheable(false);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(StandardTemplateModeHandlers.HTML5.getTemplateModeName());
        templateResolver.setCharacterEncoding("UTF-8"); 
        return templateResolver;
    }
  

}
