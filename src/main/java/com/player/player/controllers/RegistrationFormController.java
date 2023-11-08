package com.player.player.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationFormController {

    @GetMapping("/registration")
    public String getRegistrationForm() {
        return "RegistrationForm";
    }

    @PostMapping("/registration")
    public String getPlayerPageAfterRegistration() {
        return "redirect:/player";
    }
}