package com.rscart.validator;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.rscart.model.Customer;
import com.rscart.util.PasswordForgotDTO;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {    	
        if (obj instanceof Customer) {
        	Customer user = (Customer) obj;
            return user.getPassword().equals(user.getConfirmPassword());
        } else if (obj instanceof PasswordForgotDTO) {
            PasswordForgotDTO passwordForgotDTO = (PasswordForgotDTO) obj;
            return passwordForgotDTO.getNewPassword().equals(passwordForgotDTO.getNewPasswordConfirm());
        }

        return false;

    }
}