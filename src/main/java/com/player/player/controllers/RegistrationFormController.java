package com.player.player.controllers;

import com.player.player.entities.User;
import com.player.player.services.servicesImp.PlayListRepositoryImp;
import com.player.player.services.servicesImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class RegistrationFormController {

    private final UserServiceImp userServiceImp;

    private final PlayListRepositoryImp playListRepositoryImp;

    @Autowired
    public RegistrationFormController(UserServiceImp userServiceImp, PlayListRepositoryImp playListRepositoryImp) {
        this.userServiceImp = userServiceImp;
        this.playListRepositoryImp = playListRepositoryImp;
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

        User entity = userServiceImp.findByEmail(user.getEmail());

        if (entity != null) {
            bindingResult.addError(new FieldError("newUser", "email", "This email already exists"));
            return "RegistrationForm";

        } else if (userServiceImp.findByNickname(user.getNickname()) != null) {
            bindingResult.addError(new FieldError("newUser", "nickname", "This nickname already exists"));
            return "RegistrationForm";
        }

        userServiceImp.register(user);
        playListRepositoryImp.createDefaultPlayListsForUser(user);

        return "redirect:/player?userId=" + user.getId();
    }
}