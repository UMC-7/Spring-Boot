package umm.spring.study.service.MissionService;

import umm.spring.study.domain.mapping.MemberMission;
import umm.spring.study.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    MemberMission addMissionToChallenge(MissionRequestDTO.AddChallengeDTO request);
}
