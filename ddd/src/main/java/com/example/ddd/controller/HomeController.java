package com.example.ddd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "Welcome to the Home Page!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}