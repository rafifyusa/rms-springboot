package com.mitrais.rmsspringboot.controller;

import com.mitrais.rmsspringboot.model.User;
import com.mitrais.rmsspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String showUserPage(Model model) {
        model.addAttribute("users", userService.findAll());
        return "views/list";
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "views/add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model){
        if (result.hasErrors()){
            return "views/add-user";
        }
        userService.insert(user);
        return "views/login";
        /*model.addAttribute("users", userService.findAll());
        return "list";*/
    }

/*
    @PostMapping("/update/{email}")
    public String editUser(@PathVariable String email, @Valid User user, BindingResult result, Model model){
        if (result.hasErrors()){
            user.setEmail(email);
            return "update-user";
        }
        userService.update(user.getName(), user.getPassword(), user.getEmail());
        model.addAttribute("users", userService.findAll());
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable long id, Model model){
        Optional<User> editedUser = userService.findById(id);
        editedUser.ifPresent(user -> model.addAttribute("user", user));
        return "update-user";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id, Model model) {
        userService.delete(id);
        model.addAttribute("users", userService.findAll());
        return "list";
    }
*/

}
