package com.example.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class CustomerApplication {

    @Autowired
    RestTemplate restTemplate;
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @RequestMapping("custome")
    public String custome(){
        System.out.println("success");
        return restTemplate.getForEntity("http://provider/provide",String.class).getBody();
    }

}
