package com.player.player.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayerPageController {

    @GetMapping("/player")
    public String getPlayerPage() {
        return "PlayerPage";
    }
}