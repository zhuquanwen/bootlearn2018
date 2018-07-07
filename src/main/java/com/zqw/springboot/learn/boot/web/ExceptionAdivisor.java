package com.zqw.springboot.learn.boot.web;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class ExceptionAdivisor {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String to400(MethodArgumentNotValidException e){
        StringBuilder result = new StringBuilder();
        result.append("error 400 :");
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> errors = bindingResult.getFieldErrors();
        if(errors != null){
            for (FieldError error: errors) {
                String field = error.getField();
                String msg = error.getDefaultMessage();
                //TODO 这里可以使用field 和msg 组合成返回的内容，这里就是做一个拼接
                result.append(field).append(",").append(msg).append(";");
            }
        }
        return result.toString();
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String to400(ConstraintViolationException e){
        StringBuilder result = new StringBuilder();
        result.append("error 400 :");
        Set<ConstraintViolation<?>> cvs = e.getConstraintViolations();
        if(cvs != null){
            for (ConstraintViolation cv: cvs) {
                Path path = cv.getPropertyPath();
                String msg = cv.getMessage();
                result.append(path).append(",").append(msg).append(";");
                //TODO 这里可以使用path 和msg 组合成返回的内容，这里就是做一个拼接
            }
        }

        return result.toString();
    }

    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String to500(Throwable throwable){
        return throwable.getMessage();
    }
}
