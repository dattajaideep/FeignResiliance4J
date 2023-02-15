package com.bajaj.feignResilience;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/circuit")
public class FeignController {
    @Autowired
    private MyFeign myFeign;
    private static final String STUDENT_SERVICE="student-service";
    @GetMapping(value = "/test")
    public String test(){
        return "msg from feign control";
    }

    @GetMapping(value = "/client")
    @CircuitBreaker(name = "STUDENT_SERVICE",fallbackMethod = "welcome")
    public String welcome(){
        String message = myFeign.welcomeSchool();
        System.out.println(message);
        return message;
    }
}
