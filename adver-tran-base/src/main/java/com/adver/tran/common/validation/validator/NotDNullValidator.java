package com.adver.tran.common.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.adver.tran.common.utils.CheckParam;
import com.adver.tran.common.validation.NotDNull;

/**
 * 非空注解验证器
 *
 * @author lgf
 * @since 1.0.0
 */
public class NotDNullValidator implements ConstraintValidator<NotDNull, Object> {

    @Override
    public void initialize(NotDNull constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value , ConstraintValidatorContext context) {    	
        return !CheckParam.isNull(value);
    }
}