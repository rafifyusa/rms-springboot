package com.mitrais.rmsspringboot.controller;

import com.mitrais.rmsspringboot.model.User;
import com.mitrais.rmsspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        return "views/list";
    }

    @GetMapping("/adduser")
    public String showAddUserForm(User user) {
        return "views/add-user";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result, Model model){
        if (result.hasErrors()){
            return "views/add-user";
        }
        boolean response = userService.insert(user);
        if(response){
            model.addAttribute("response", response);
            System.out.println(response);
            return "views/login";
        }
        return "views/add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model){
        if (result.hasErrors()){
            return "views/add-user";
        }
        userService.insert(user);
        model.addAttribute("users", userService.findAll());
        return "views/list";
    }

    //Controller to save the updated user
    @PostMapping("/update/{email}")
    public String editUser(@PathVariable String email, @Valid User user, BindingResult result, Model model){
        if (result.hasErrors()){
            user.setEmail(email);
            return "views/update-user";
        }
        userService.update(user.getName(), user.getPassword(), user.getEmail());
        model.addAttribute("users", userService.findAll());
        return "views/list";
    }

    //Controller to fetch user data and redirect to update page
    @GetMapping("/edit/{email}")
    public String showUpdateForm(@PathVariable String email, Model model){
        Optional<User> editedUser = userService.findByEmail(email);
        editedUser.ifPresent(user -> model.addAttribute("user", user));
        return "views/update-user";
    }

    @GetMapping("/delete/{email}")
    public String deleteUser(@PathVariable String email, Model model) {
        userService.delete(email);
        model.addAttribute("users", userService.findAll());
        return "views/list";
    }

}
