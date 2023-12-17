package com.player.player.annotations.validators;

import com.player.player.annotations.Nickname;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NicknameValidator implements ConstraintValidator<Nickname, String> {

    private static final String REGEXP = "^[a-zA-Z0-9'.-_₴!@#$%^&*()]{1,15}$";

    @Override
    public boolean isValid(String nickname, ConstraintValidatorContext context) {
        return nickname.matches(REGEXP);
    }
}