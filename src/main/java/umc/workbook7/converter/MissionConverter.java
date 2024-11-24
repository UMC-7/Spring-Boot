package umc.workbook7.converter;

import umc.workbook7.domain.entity.Mission;
import umc.workbook7.web.dto.Mission.MissionResponseDTO;
import umc.workbook7.web.dto.Mission.MissionRequestDTO;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.CreateMissionRequestDTO request){
        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .deadLine(request.getDeadLine())
                .reward(request.getReward())
                .build();
    }

    public static MissionResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission){
        return MissionResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getMissionId())
                .createdAt(mission.getCreatdAt())
                .build();
    }
}
