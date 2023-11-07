package com.player.player.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/log-in", "/registration"})
@Controller
public class PlayerPageController {

    @GetMapping("/player")
    public String getPlayerPage() {
        return "PlayerPage";
    }
}