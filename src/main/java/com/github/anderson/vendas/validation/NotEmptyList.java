package com.github.anderson.vendas.validation;

import com.github.anderson.vendas.validation.constraintvalidation.NotEmptyListValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME) // anotação para ser verificada no  tempo de execução
@Target(ElementType.FIELD) // anotação para ser verificada em um atributo
@Constraint(validatedBy = {NotEmptyListValidator.class}) // anotação para ser verificada por uma classe
public @interface NotEmptyList {

        String message() default "A lista não pode ser vazia";

        Class<?>[] groups() default {};

        Class<? extends javax.validation.Payload>[] payload() default {};
}
