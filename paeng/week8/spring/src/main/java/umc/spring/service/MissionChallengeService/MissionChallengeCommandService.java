package umc.spring.service.MissionChallengeService;

import org.springframework.transaction.annotation.Transactional;
import umc.spring.web.dto.MissionChallengeRequestDTO;
import umc.spring.web.dto.MissionChallengeResponseDTO;

public interface MissionChallengeCommandService {
    @Transactional
    MissionChallengeResponseDTO challengeMission(MissionChallengeRequestDTO request);
}
