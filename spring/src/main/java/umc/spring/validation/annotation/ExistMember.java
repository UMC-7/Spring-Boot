package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.CategoriesExistValidator;
import umc.spring.validation.validator.MemberExistValidator;

import java.lang.annotation.*;

@Documented     //사용자 정의 어노테이션
@Constraint(validatedBy = MemberExistValidator.class)   //지정된 클래스를 통해 ExistCategories가 붙은 대상을 검증한다.
@Target( {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER} )    //어노테이션의 적용 범위.
@Retention(RetentionPolicy.RUNTIME)     //어노테이션의 생명 주기. runtime인 경우에만 작용된다.
public @interface ExistMember {

    String message() default "존재하지 않는 맴버입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
