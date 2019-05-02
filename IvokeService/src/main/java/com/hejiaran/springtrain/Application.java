package com.hejiaran.springtrain;

import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class Application {

    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplateBuilder().build();

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/hello")
    public String home() {
        List<ServiceInstance> serviceInstances
                =  discoveryClient.getInstances("HelloApplication");
        String url = serviceInstances.get(0).getUri() + "/hello";
        return restTemplate.getForObject(url, String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);    }

}