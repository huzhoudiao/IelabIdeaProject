package com.example.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
//@RestController
public class EurekaApplication8763 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication8763.class, args);
    }

//    @RequestMapping("/test8762")
//    public String test(){
//        return "this is test8762";
//    }

}
