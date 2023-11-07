package com.player.player.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationFormController {

    @GetMapping("/registration")
    public String getRegistrationForm() {
        return "RegistrationForm";
    }
}