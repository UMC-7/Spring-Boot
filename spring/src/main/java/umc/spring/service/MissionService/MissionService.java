package umc.spring.service.MissionService;

import umc.spring.domain.common.Mission;
import umc.spring.web.dto.MissionDTO;

public interface MissionService {

    public Mission addMission(MissionDTO.AddDTO request );
}
