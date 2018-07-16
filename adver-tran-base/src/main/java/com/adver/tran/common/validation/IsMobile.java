package com.adver.tran.common.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.adver.tran.common.validation.validator.MobileValidator;

/*
 * 手机号码校验
 * @auther lgf
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MobileValidator.class)
public @interface IsMobile {

	String message() default "must_be_mobile";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
}
