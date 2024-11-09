package com.saiteja.spring_jwt.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String getHello(HttpServletRequest request) {
        return "Welcome to Spring Security " + request.getSession().getId();
    }
}
