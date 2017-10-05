package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zemoso on 4/10/17.
 */
@RestController
public class HelloController{

    @RequestMapping("/hello")
    public String hello(){
        return "Hello world";
    }
}
