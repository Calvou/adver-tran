package com.adver.tran.common.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.adver.tran.common.utils.CheckParam;
import com.adver.tran.common.validation.IsMobile;

/**
 * 手机号码验证
 * @author lgf
 *
 */
public class MobileValidator  implements ConstraintValidator<IsMobile, String> {

	@Override
	public void initialize(IsMobile constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 手机号码
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value!=null){
    		value = value.trim();
    	}
        return CheckParam.isMobile(value);
	}

	
	
}
