package com.zqw.springboot.learn.boot.validate.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR,
        ElementType.ANNOTATION_TYPE,ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {SexValidator.class})
public @interface SexConstraint {
    String message() default "{sex.constraint.message}";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
