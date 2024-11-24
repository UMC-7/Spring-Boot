package umc.study.service.MissionCommandService;

import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

public interface MissionCommandService {
    MissionResponseDTO.AddMissionResultDTO addMission(Long storeId, MissionRequestDTO.AddMissionDTO request);
}