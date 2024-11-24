package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.foodCategoryRepository.FoodCategoryRepository;
import umc.spring.repository.memberMissionRepository.MemberMissionRepository;
import umc.spring.repository.missionRepository.MissionRepository;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.NotTryingMission;

import java.util.List;


@Component
@RequiredArgsConstructor
public class NotTryingMissionValidator implements ConstraintValidator<NotTryingMission, List<Long>> {

    private final FoodCategoryRepository foodCategoryRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(NotTryingMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {

//         MemberMission memberMission = values.stream()
//                .allMatch(value -> memberMissionRepository.findById(value).stream().anyMatch());

        boolean isValid = values.stream()
                .allMatch(value -> memberMissionRepository.findById(value).stream().allMatch(mission -> mission.getStatus().toString().equals("TRYiNG")));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}

