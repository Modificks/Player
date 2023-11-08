package com.player.player.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogInPageController {

    @GetMapping("/log-in")
    public String getLogInPage() {
        return "LogInPage";
    }

    @PostMapping("/log-in")
    public String getPlayerPageAfterLogIn() {
        return "redirect:/player";
    }
}