package umc.spring.service.MissionService;

import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    @Transactional
    Mission createMission(MissionRequestDTO.@Valid MCreateDto request);
}
