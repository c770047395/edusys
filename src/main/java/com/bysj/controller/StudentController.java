package com.bysj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class StudentController {

    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }

}
