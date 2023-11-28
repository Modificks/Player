package com.player.player.controllers;

import com.player.player.entities.User;
import com.player.player.services.servicesImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogInPageController {

    private final UserServiceImp userServiceImp;

    @Autowired
    public LogInPageController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/login")
    public String getLogInPage(Model model) {
        model.addAttribute("checkUser", new User());
        return "LogInPage";
    }

    @PostMapping("/login")
    public String getPlayerPageAfterLogIn(@ModelAttribute("checkUser") User user, BindingResult bindingResult) {

        if (userServiceImp.findByEmailAndPassword(user.getEmail(), user.getPassword()) != null) {
            return "redirect:/player";
        } else {
            bindingResult.addError(new FieldError("checkUser", "email", "Invalid email or password"));
            return "LogInPage";
        }
    }
}