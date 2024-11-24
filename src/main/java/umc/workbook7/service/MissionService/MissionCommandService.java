package umc.workbook7.service.MissionService;

import umc.workbook7.domain.entity.Mission;
import umc.workbook7.web.dto.Mission.MissionRequestDTO;

public interface MissionCommandService {
    Mission createMission(Long storeId, MissionRequestDTO.CreateMissionRequestDTO request);
}
