package com.github.anderson.vendas.validation.constraintvalidation;

import com.github.anderson.vendas.validation.NotEmptyList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

// ConstraintValidator<NotEmptyList, List> -> NotEmptyList é a anotação e List é o tipo do atributo
public class NotEmptyListValidator implements ConstraintValidator<NotEmptyList, List> {
    // método que valida a anotação
    @Override
    public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
        return list != null && !list.isEmpty();
    }

    // método que inicializa a anotação
    @Override
    public void initialize(NotEmptyList constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
