package com.bajaj.feignResilience;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "feign",url="http://localhost:8082")
public interface MyFeign {
    @RequestMapping(method = RequestMethod.GET,value = "/actuator/info/home")
    public String welcomeSchool();
}
