package umc.study.spring.service.MissionService;

import umc.study.spring.domain.mapping.MemberMission;
import umc.study.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    MemberMission addMissionToChallenge(MissionRequestDTO.AddChallengeDTO request);
}
