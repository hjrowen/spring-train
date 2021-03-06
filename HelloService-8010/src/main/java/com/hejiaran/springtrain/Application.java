package com.hejiaran.springtrain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class Application {

    @RequestMapping("/hello")
    public String home() {
        return "Hello world from 8010";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);    }

}