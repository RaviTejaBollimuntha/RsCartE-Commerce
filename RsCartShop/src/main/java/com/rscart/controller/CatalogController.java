package com.rscart.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rscart.model.Category;
import com.rscart.model.Product;
import com.rscart.model.SubCategory;
import com.rscart.service.CategoryConfigService;
import com.rscart.service.ProductConfigService;

/**
 * @author RaviTeja Bollimuntha Handles requests for the application home page.
 */
@Controller
public class CatalogController {

	@Autowired
	private CategoryConfigService categoryConfigurationService;
	@Autowired
	private ProductConfigService productConfigurationService;
	@Autowired
	private ServletContext context;

	private String accountsTemplatePage = "template/accountInformation";

	private String homePage = "home";

	private String categoryPage = "category";

	private String accountsPage = "account";

	private   Logger logger = LoggerFactory.getLogger(CatalogController.class);

	/**
	 * Catalog Controller method which retrieves the information required in the
	 * application home page(Categories,SubCategories,Featured Items)
	 * 
	 * @author RaviTeja Bollimuntha
	 * 
	 * @param Model
	 * @return Home Page View
	 */
	@RequestMapping(value = {"/home","/"}, method = RequestMethod.GET)
	public String returnHomePage(Model model,@RequestParam(value="page",required = false) String page, HttpServletRequest request) {
		Map<Category, List<SubCategory>> categoryMap = new HashMap<Category, List<SubCategory>>();
		logger.info("Processing information for home page");
		if (categoryMap.isEmpty()) {
			categoryMap = categoryConfigurationService.getCategoriesMap();
		}
		if (context.getAttribute("categoryMap") == null) {
			context.setAttribute("categoryMap", categoryMap);
		}
		List<Product> featProdList = new ArrayList<Product>();
		if (featProdList.isEmpty()) {	
			featProdList=productConfigurationService.getFeaturedProducts();
			if(featProdList.size()%6==0)
			    model.addAttribute("pagecount", featProdList.size()/6);
			else
				model.addAttribute("pagecount", (featProdList.size()/6)+1);
			int total = 6,page_id=0,pageno=0;
			if(page == null) {
				page_id=1;
				pageno=1;
	        } else { 
	        	page_id=Integer.parseInt(page);
	        	pageno=page_id;
	            page_id= (page_id-1)*total+1;  
	        }
			featProdList=productConfigurationService.getPagenumberByProducts(page_id,total+page_id);
			model.addAttribute("featProd",featProdList);
			model.addAttribute("pageno", pageno);
		}
		
		return getHomePage();
	}

	@RequestMapping(value = "/cateogry", method = RequestMethod.GET)
	public String fetchProductsByCategory(Model model,
			@RequestParam("category") String categoryName,
			HttpServletRequest request) {
		List<Product> categoryProducts = categoryConfigurationService
				.getProductsByCategory(categoryName);
		model.addAttribute("catProds", categoryProducts);
		return getCategoryPage();
	}

	@RequestMapping(value = "/subcateogry", method = RequestMethod.GET)
	public String fetchProductsBySubCategory(Model model,
			@RequestParam("subcategory") String subCategoryName,
			HttpServletRequest request) {
		List<Product> subCategoryProducts = categoryConfigurationService
				.getProductsBySubCategory(subCategoryName);
		model.addAttribute("subCatProds", subCategoryProducts);
		return getCategoryPage();
	}

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String getAccountsPage(Model model, HttpServletRequest request) {
		model.addAttribute("page", accountsTemplatePage);
		return getAccountPage();
	}

	public String getAccountPage() {
		return accountsPage;
	}

	public String getCategoryPage() {
		return categoryPage;
	}

	public String getHomePage() {
		return homePage;
	}
}
