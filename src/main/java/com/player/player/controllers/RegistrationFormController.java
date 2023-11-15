package com.player.player.controllers;

import com.player.player.entities.User;
import com.player.player.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
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
    public String getPlayerPageAfterRegistration(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors("email")) {
            bindingResult.addError(new FieldError("newUser", "email", "example: dimanakonechnui7@gmail.com"));
        }

        if (bindingResult.hasFieldErrors("nickname")) {
            bindingResult.addError(new FieldError("newUser", "nickname", "It should be less then 15 symbols"));
        }

        if (bindingResult.hasFieldErrors("password")){
            bindingResult.addError(new FieldError("newUser", "password", "It should contains small letters, big letters, digits and contains at least 6 symbols"));
        }

        if (bindingResult.hasErrors()) {
            return "RegistrationForm";
        }


        postRepository.save(user);

        return "redirect:/player";
    }
}