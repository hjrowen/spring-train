package com.hejiaran.springtrain;

import com.hejiaran.springtrain.api.IHelloApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.hejiaran")
public class IvokeApp {

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    IHelloApi iHelloApi;

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/hello")
    public String home() {
//        List<ServiceInstance> serviceInstances
//                =  discoveryClient.getInstances("HelloApplication");
//        String url = serviceInstances.get(0).getUri() + "/hello";
//        return restTemplate.getForObject("http://HelloApplication/hello", String.class);
//        return restTemplate.getForObject(url, String.class);
        System.out.println("--------------hello------------------------");
        return iHelloApi.hello();
    }

    public static void main(String[] args) {
        SpringApplication.run(IvokeApp.class, args);    }

}