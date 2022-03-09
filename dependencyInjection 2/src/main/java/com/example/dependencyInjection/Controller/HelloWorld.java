package com.example.dependencyInjection.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("/greet")
    public String greet(){
        return "hello";
    }
}
