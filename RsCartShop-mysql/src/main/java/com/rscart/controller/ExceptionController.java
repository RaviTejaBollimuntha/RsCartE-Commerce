package com.rscart.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController { 
@ExceptionHandler(DataAccessException.class)	
public ModelAndView exception(DataAccessException e) {
		e.printStackTrace();
		ModelAndView mav = new ModelAndView("exceptionerror");
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());

		return mav;
	}
@ExceptionHandler(Exception.class)	
public ModelAndView globalException(Exception e) {
		e.printStackTrace();
	    ModelAndView mav = new ModelAndView("error");
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());
		return mav;
	}
}
