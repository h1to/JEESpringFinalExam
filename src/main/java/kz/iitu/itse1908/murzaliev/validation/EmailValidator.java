package kz.iitu.itse1908.murzaliev.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraintValidator, String> {

    @Override
    public void initialize(EmailConstraintValidator constraintAnnotation) {
    }

    @AssertTrue
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email != null && !email.contains("@");
    }
}
