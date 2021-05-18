package com.ielab.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/test1")
    @ResponseBody
    public String test1(){
        System.out.println("test1");
        return "this is a test1";
    }



    @RequestMapping("/test2")
    @ResponseBody
    public String test2(){
        System.out.println("test2");
        return "this is a test2";
    }
}
