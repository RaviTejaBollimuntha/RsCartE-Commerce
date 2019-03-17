
package com.rscart.admin.config;

import javax.servlet.Filter;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.rscart.admin.security.PostAuthorizationFilter;

/**
 * @author RaviTeja Bollimuntha
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	@Value("${server.port:9443}")
	private int serverPort;

	@Autowired
	private PostAuthorizationFilter postAuthorizationFilter;

	@Autowired
	private MessageSource messageSource;

	@Bean
	public HttpSessionListener httpSessionListener() {
		return new HttpSessionListener() {
			@Override
			public void sessionCreated(HttpSessionEvent se) {
				System.out.println("Session Created with session id: " + se.getSession().getId());
				HttpSession session = se.getSession();
				session.setMaxInactiveInterval(5* 60);
			}

			@Override
			public void sessionDestroyed(HttpSessionEvent se) {
				System.out.println("Session Destroyed, Session id: " + se.getSession().getId());
			}
		};
	}

	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
		factory.setValidationMessageSource(messageSource);
		return factory;
	}

	// http://stackoverflow.com/questions/25957879/filter-order-in-spring-boot
	@Bean
	public FilterRegistrationBean securityFilterChain(
			@Qualifier(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME) Filter securityFilter) {
		FilterRegistrationBean registration = new FilterRegistrationBean(securityFilter);
		registration.setOrder(Integer.MAX_VALUE - 1);
		registration.setName(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME);
		return registration;
	}

	@Bean
	public FilterRegistrationBean PostAuthorizationFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(postAuthorizationFilter);
		registrationBean.setOrder(Integer.MAX_VALUE);
		return registrationBean;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
		registry.addViewController("/login").setViewName("public/login");
		registry.addRedirectViewController("/", "/home");

	}

	@Bean
	public SpringSecurityDialect securityDialect() {
		return new SpringSecurityDialect();
	}

	@Bean
	public ClassLoaderTemplateResolver emailTemplateResolver() {
		ClassLoaderTemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver();
		emailTemplateResolver.setPrefix("email-templates/");
		emailTemplateResolver.setSuffix(".html");
		emailTemplateResolver.setTemplateMode("HTML5");
		emailTemplateResolver.setCharacterEncoding("UTF-8");
		emailTemplateResolver.setOrder(2);

		return emailTemplateResolver;
	}

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};

		tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
		return tomcat;
	}

	private Connector initiateHttpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(9090);
		connector.setSecure(false);
		connector.setRedirectPort(serverPort);

		return connector;
	}
}
