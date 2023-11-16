package com.player.player.controllers;

import com.player.player.entities.User;
import com.player.player.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class RegistrationFormController {

    private final PostRepository postRepository;

    @Autowired
    public RegistrationFormController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/registration")
    public String getRegistrationForm(Model model) {
        model.addAttribute("newUser", new User());
        return "RegistrationForm";
    }

    @PostMapping("/registration")
    public String getPlayerPageAfterRegistration(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "RegistrationForm";
        }

        postRepository.save(user);

        return "redirect:/player";
    }
}