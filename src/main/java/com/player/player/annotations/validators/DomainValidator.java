package com.player.player.annotations.validators;

import com.player.player.annotations.Domain;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DomainValidator implements ConstraintValidator<Domain, String> {

    private static final String REGEXP = "^(?!.*\\.ru)$\n";

    @Override
    public boolean isValid(String domain, ConstraintValidatorContext context) {
        return !domain.matches(REGEXP);
    }
}
