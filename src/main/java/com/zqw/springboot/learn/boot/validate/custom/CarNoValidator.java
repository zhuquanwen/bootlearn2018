package com.zqw.springboot.learn.boot.validate.custom;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CarNoValidator implements ConstraintValidator<CarNoConstraint, String> {
    public void initialize(SexConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(StringUtils.isBlank(value)) return false;
        if(value.length() != 18) return false;
        if(!StringUtils.isNumeric(value)) return false;//身份证号可能最后为X，先不管他，暂时认为都是数字

        return true;
    }
}
