package org.vmdevel.ejercicio.domain.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordValidation implements ConstraintValidator<PasswordConstraint, String> {

    private final Pattern pattern = Pattern.compile("([A-Z]{1}[a-z]{1,}\\d{2})");
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return pattern.matcher(value).matches();
    }
}
