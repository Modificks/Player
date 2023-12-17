package com.player.player.controllers;

import com.player.player.config.security.auth.UserAuthRequest;
import com.player.player.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LogInPageController {

    private final AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String getLogInPage(Model model) {
        model.addAttribute("authUser", new User());
        return "LogInPage";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("authUser") UserAuthRequest userAuthRequest) {

        UsernamePasswordAuthenticationToken authReq =
                new UsernamePasswordAuthenticationToken(userAuthRequest.getUsername(), userAuthRequest.getPassword());

        Authentication auth = authenticationManager.authenticate(authReq);
        SecurityContextHolder.getContext().setAuthentication(auth);

        return "redirect:/player";
    }
}