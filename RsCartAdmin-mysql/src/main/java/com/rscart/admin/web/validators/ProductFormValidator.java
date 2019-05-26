package com.rscart.admin.web.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rscart.admin.web.models.ProductForm;
import com.rscart.catalog.CatalogService;
import com.rscart.entities.Product;

/**
 * @author ravviteja bollimuntha
 *
 */
@Component
public class ProductFormValidator implements Validator
{
	@Autowired protected MessageSource messageSource;
	@Autowired protected CatalogService catalogService;
	
	@Override
	public boolean supports(Class<?> clazz)
	{
		return Product.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors)
	{
		ProductForm product = (ProductForm) target;
		Integer id = product.getId();
		Product p = catalogService.getProductById(id);
		if(p == null){
			errors.rejectValue("product", "error.exists", new Object[]{id}, "Product  "+id+" already exists");
		}
	}
	
	
}
