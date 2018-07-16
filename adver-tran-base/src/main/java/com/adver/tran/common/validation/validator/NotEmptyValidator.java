package com.adver.tran.common.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.adver.tran.common.utils.CheckParam;
import com.adver.tran.common.validation.NotEmpty;

/**
 * 非空注解验证器
 *
 * @author lgf
 * @since 1.0.0
 */
public class NotEmptyValidator implements ConstraintValidator<NotEmpty, String> {

    @Override
    public void initialize(NotEmpty constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {    	
    	if(value!=null){
    		value=value.trim();
    	}
        //return StringUtils.isNotEmpty(value);
        return !CheckParam.isNull(value);
    }
}