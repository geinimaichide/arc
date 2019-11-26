package com.architecture;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBootController {
    
    @RequestMapping("hello")
    public String sayHello() {
        return "Spring Boot Hello";
    }
}
