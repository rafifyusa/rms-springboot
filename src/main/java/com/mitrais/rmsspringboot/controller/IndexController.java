package com.mitrais.rmsspringboot.controller;

import com.mitrais.rmsspringboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String showIndexPage(){
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "views/login";
    }
    @GetMapping("/signup")
    public String showListPage(User user){
        return "views/register";
    }
}
