package umm.spring.study.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umm.spring.study.apiPayload.code.status.ErrorStatus;
import umm.spring.study.repository.MissionRepository.MissionRepository;
import umm.spring.study.validation.annotation.MissionExists;

import java.util.List;
@Component
@RequiredArgsConstructor

public class MissionExistsValidator implements ConstraintValidator<MissionExists, Long>{

    private final MissionRepository missionRepository;

    @Override
    public void initialize(MissionExists constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        boolean isValid = missionRepository.existsById(missionId);

        if (!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
