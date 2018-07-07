package com.zqw.springboot.learn.boot.validate.web;

import com.zqw.springboot.learn.boot.validate.bean.Employee;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/employee")
@Validated
public class VController1 {

    @PutMapping("/spring/assert")
    public Employee put1(@RequestBody Employee employee){
        Assert.hasText(employee.getName(), "名称不能为空");
        return employee;
    }

    @PutMapping("/assert")
    public Employee put2(@RequestBody Employee employee){
        assert employee.getName() != null && !"".equals(employee.getName());
        return employee;
    }

    @PutMapping("/bean")
    public Employee put3(@Valid @RequestBody Employee employee){
        return employee;
    }
    @GetMapping("/param")
    public Employee get1(@Size(min=3, max=5) String name, @Min(3) @Max(5) int id ){
        return new Employee(id, name);
    }
}
