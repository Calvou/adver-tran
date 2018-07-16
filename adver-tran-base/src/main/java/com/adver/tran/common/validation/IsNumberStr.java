package com.adver.tran.common.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.adver.tran.common.validation.validator.NumberStrValidator;

/**
 * 校验必须是字符串的注解
 * @author  lgf
 *
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumberStrValidator.class)
public @interface IsNumberStr {
	
	String message() default "must_be_numberString";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
