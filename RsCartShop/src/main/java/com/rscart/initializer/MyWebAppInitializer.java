package com.rscart.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.rscart.config.RootAppConfig;
import com.rscart.config.WebMvcAppConfig;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public Class<?>[] getRootConfigClasses() {
		return new Class[]{RootAppConfig.class};  //for parent container
	}

	@Override
	public Class<?>[] getServletConfigClasses() {
		return new Class[]{WebMvcAppConfig.class};  //for child container
	}

	@Override
	public String[] getServletMappings() {
		return new String[]{"/"};  //for url pattern of DispatcherServlet
	}
	
	
}//class
