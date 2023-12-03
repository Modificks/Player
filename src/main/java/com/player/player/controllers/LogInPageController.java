package com.player.player.controllers;

import com.player.player.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LogInPageController {

    @GetMapping("/login")
    public String getLogInPage(Model model) {
        model.addAttribute("checkUser", new User());
        return "LogInPage";
    }
}