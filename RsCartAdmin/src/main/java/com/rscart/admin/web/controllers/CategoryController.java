package com.rscart.admin.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rscart.admin.security.SecurityUtil;
import com.rscart.admin.web.validators.CategoryValidator;
import com.rscart.catalog.CatalogService;
import com.rscart.entities.Category;
import com.rscart.entities.SubCategory;


/**
 * @author RaviTeja Bollimuntha
 *
 */
@Controller
@Secured(SecurityUtil.MANAGE_CATEGORIES)
public class CategoryController extends RsCartAdminBaseController
{
	private static final String viewPrefix = "categories/";
	
	@Autowired
	private CatalogService catalogService;
	
	@Autowired private CategoryValidator categoryValidator;
	
	@Override
	protected String getHeaderTitle()
	{
		return "Manage Categories";
	}
	
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public String listCategories(Model model) {
		List<Category> list = catalogService.getAllCategories();
		Map<Category, List<SubCategory>> categoryMap = new HashMap<>();		
		for (Category category : list) {
			List<SubCategory> subCategoryList =catalogService.getSubCategoryByCATEGORY_ID(category.getId());				
			categoryMap.put(category, subCategoryList);
		}
		model.addAttribute("categories",categoryMap);
		return viewPrefix+"categories";
	}
	
	@RequestMapping(value="/categories/new", method=RequestMethod.GET)
	public String createCategoryForm(Model model) {
		Category category = new Category();
		model.addAttribute("category",category);
		
		return viewPrefix+"create_category";
	}
	@RequestMapping(value="/subcategory/new", method=RequestMethod.GET)
	public String createSubCategoryForm(@RequestParam String id,Model model) {
		SubCategory subcategory = new SubCategory();
		subcategory.setCATEGORY_ID(Integer.parseInt(id));
		model.addAttribute("subcategory",subcategory);
		
		return viewPrefix+"create_subcategory";
	}

	@RequestMapping(value="/categories", method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result,
			Model model, RedirectAttributes redirectAttributes) {
		categoryValidator.validate(category, result);
		if(result.hasErrors()){
			return viewPrefix+"create_category";
		}
		Category persistedCategory = catalogService.createCategory(category);
		logger.debug("Created new category with id : {} and name : {}", persistedCategory.getId(), persistedCategory.getName());
		redirectAttributes.addFlashAttribute("info", "Category created successfully");
		return "redirect:/categories";
	}
	
	@RequestMapping(value="/subcategories", method=RequestMethod.POST)
	public String createSubCategory(@Valid @ModelAttribute("subcategory") SubCategory subcategory, BindingResult result,
			Model model, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()){
			return viewPrefix+"create_subcategory";
		}
		SubCategory persistedCategory = catalogService.createSubCategory(subcategory);
		logger.debug("Created new Subcategory with id : {} and name : {}", persistedCategory.getId(), persistedCategory.getName());
		redirectAttributes.addFlashAttribute("info", "SubCategory created successfully");
		return "redirect:/categories";
	}
	
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.GET)
	public String editCategoryForm(@PathVariable Integer id, Model model) {
		Category category = catalogService.getCategoryById(id);				
		List<SubCategory> subCategoryList =catalogService.getSubCategoryByCATEGORY_ID(category.getId());			
		model.addAttribute("subcategory",subCategoryList);		
		model.addAttribute("category",category);
		return viewPrefix+"edit_category";
	}
	@RequestMapping(value="/getsubcategory/", method=RequestMethod.GET)
	public void editCategory(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Category category = catalogService.getCategoryById(Integer.parseInt(request.getParameter("id")));
		List<SubCategory> subCategoryList =catalogService.getSubCategoryByCATEGORY_ID(category.getId());
		 String buffer="<select name='subcategory'>"; 
			for (SubCategory subcat : subCategoryList) {
				buffer=buffer+"<option value='"+subcat.getId()+"'>"+subcat.getName()+"</option>"; 
			}		 
			 
			 buffer=buffer+"</select>"; 
			response.getWriter().print(buffer);
	}
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.POST)
	public String updateCategory(Category category, Model model, RedirectAttributes redirectAttributes) {
		Category persistedCategory = catalogService.updateCategory(category);
		logger.debug("Updated category with id : {} and name : {}", persistedCategory.getId(), persistedCategory.getName());
		redirectAttributes.addFlashAttribute("info", "Category updated successfully");
		return "redirect:/categories";
	}
	@RequestMapping(value="/subcategories/{id}", method=RequestMethod.POST)
	public String updateSubCategory(SubCategory subcategory, Model model, RedirectAttributes redirectAttributes) {
		SubCategory persistedsubCategory = catalogService.updateSubCategory(subcategory);
		logger.debug("Updated category with id : {} and name : {}", persistedsubCategory.getId(), persistedsubCategory.getName());
		redirectAttributes.addFlashAttribute("info", "SubCategory updated successfully");
		return "redirect:/categories";
	}

}
