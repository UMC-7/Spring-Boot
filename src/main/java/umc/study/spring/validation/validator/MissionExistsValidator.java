package umc.study.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.spring.apiPayload.code.status.ErrorStatus;
import umc.study.spring.repository.MissionRepository.MissionRepository;
import umc.study.spring.validation.annotation.MissionExists;

@Component
@RequiredArgsConstructor
public class MissionExistsValidator implements ConstraintValidator<MissionExists, Long> {

    private final MissionRepository missionRepository;

    @Override
    public void initialize(MissionExists constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        //boolean isValid = missionRepository.findById(missionId);
        boolean isValid=true;
        if (!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
