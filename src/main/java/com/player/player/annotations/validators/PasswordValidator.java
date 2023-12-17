package com.player.player.annotations.validators;

import com.player.player.annotations.Password;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    private static final String REGEXP = "(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}";

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return password.matches(REGEXP);
    }
}