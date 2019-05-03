package com.hejiaran.springtrain.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "HelloApplication")
public interface IHelloApi {
    @RequestMapping(value = "/hello")
    String hello();
}
