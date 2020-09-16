package com.example.demo.controller;

import com.example.demo.aop.TestAnnotation;
import com.example.demo.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @TestAnnotation
    @GetMapping("/hello/{name}")
    public User hello(@PathVariable(name = "name") String name) {
        User user = new User();
        user.setName(name);
        user.setEmail("xxx@163.com");
        return user;
    }

}
