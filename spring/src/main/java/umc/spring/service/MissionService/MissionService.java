package umc.spring.service.MissionService;

import umc.spring.domain.common.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionDTO;

import java.util.Optional;

public interface MissionService {

    public Mission addMission(MissionDTO.AddDTO request );

    public MemberMission addTryingMission(MissionDTO.AddTryDTO request);

    public Optional<Mission> findById(Long id);
}
