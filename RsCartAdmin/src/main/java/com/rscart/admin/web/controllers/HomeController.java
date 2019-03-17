package com.rscart.admin.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rscart.catalog.CatalogService;

/**
 * @author RaviTeja Bollimuntha
 *
 */
@Controller
public class HomeController extends RsCartAdminBaseController {
	@Autowired
	private CatalogService catalogService;
	@Override
	protected String getHeaderTitle() {
		return "Home";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("orders", "1");
		model.addAttribute("sales", "1");
		model.addAttribute("users", "1");
		model.addAttribute("visitors", "2");
		model.addAttribute("products", catalogService.getAllProducts());
		model.addAttribute("reviews", "");
		model.addAttribute("ordershistory", "");
		return "home";
	}

}
