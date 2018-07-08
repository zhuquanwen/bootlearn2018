package com.zqw.springboot.learn.boot.validate.custom;

import org.hibernate.validator.internal.constraintvalidators.bv.NotNullValidator;
import org.hibernate.validator.internal.constraintvalidators.bv.number.bound.MaxValidatorForDouble;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SexValidator implements ConstraintValidator<SexConstraint, Enum<Sex>> {
    public void initialize(SexConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(Enum<Sex> value, ConstraintValidatorContext context) {

        if(value instanceof Sex){
            return true;
        }
        return false;
    }
}
