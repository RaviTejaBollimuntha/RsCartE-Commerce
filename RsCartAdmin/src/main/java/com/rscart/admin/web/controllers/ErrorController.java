package com.rscart.admin.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author RaviTeja Bollimuntha
 */
@Controller
public class ErrorController
{
	private static final String viewPrefix = "error/";
	
	@RequestMapping("/403")
	public String accessDenied()
	{
		return viewPrefix+"accessDenied";
	}
	
}
