package com.mitrais.rmsspringboot.controller;

import com.mitrais.rmsspringboot.model.User;
import com.mitrais.rmsspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String showUserPage(Model model) {
        model.addAttribute("users", userService.findAll());
        return "list";
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model){
        if (result.hasErrors()){
            return "add-user";
        }
        userService.insert(user);
        model.addAttribute("users", userService.findAll());
        return "list";
    }

    @PutMapping("/edituser")
    public String editUser(@Valid User user, BindingResult result, Model model){
        if (result.hasErrors()){
            return "list";
        }
        userService.update(user.getName(), user.getPassword(), user.getId());
        model.addAttribute("users", userService.findAll());
        return "list";
    }

}
