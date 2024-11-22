package umc.spring.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.study.validation.validator.FoodsExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FoodsExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistFoods {

    String message() default "해당 음식이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}