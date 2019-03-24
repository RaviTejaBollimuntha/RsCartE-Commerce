package com.rscart.admin.web.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author RaviTeja Bollimuntha
 *
 */
public class WebUtils
{
	private WebUtils()
	{
	}
	public static final String IMAGES_PREFIX = "/products/images/";
	public static final String IMAGES_DIR =System.getProperty("user.dir")+ "/src/main/resources/static/assets/img/products/";
	public static final String IMAGES_COPY =System.getProperty("user.dir").replace("RsCartAdmin", "RsCartSite")+ "\\src\\main\\webapp\\resources\\images\\";
	
	public static String getURLWithContextPath(HttpServletRequest request)
	{
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
	}
	
	
}
