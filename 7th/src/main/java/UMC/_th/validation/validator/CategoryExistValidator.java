package UMC._th.validation.validator;

import UMC._th.apiPayload.code.status.ErrorStatus;
import UMC._th.repository.FoodPreferRepository;
import UMC._th.validation.annotation.ExistCategories;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {

    private final FoodPreferRepository foodPreferRepository;

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> longs, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = longs.stream()
                .allMatch(value -> foodPreferRepository.existsById(value));

        if(!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
