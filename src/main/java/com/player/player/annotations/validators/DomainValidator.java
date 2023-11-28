package com.player.player.annotations.validators;

import com.player.player.annotations.Domain;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DomainValidator implements ConstraintValidator<Domain, String> {

    private final String REGEXP = "\\.ru$";
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return email.matches(REGEXP);
    }
}