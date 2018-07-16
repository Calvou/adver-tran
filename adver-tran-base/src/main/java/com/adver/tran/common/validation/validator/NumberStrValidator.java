package com.adver.tran.common.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.adver.tran.common.utils.CheckParam;
import com.adver.tran.common.validation.IsNumberStr;

/**
 * 数字字符串校验实现
 * @author lgf
 *
 */
public class NumberStrValidator  implements ConstraintValidator<IsNumberStr, String>{

	@Override
	public void initialize(IsNumberStr constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value!=null){
    		value = value.trim();
    	}
        return CheckParam.isNum(value);
	}

}
