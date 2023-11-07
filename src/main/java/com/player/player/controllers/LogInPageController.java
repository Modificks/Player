package com.player.player.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInPageController {

    @GetMapping("/log-in")
    public String getLogInPage() {
        return "LogInPage";
    }
}