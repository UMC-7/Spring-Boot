package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.domain.Store;
import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.MCreateResultDTO toCreateResultDTO(Mission mission){
        return MissionResponseDTO.MCreateResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.MCreateDto request, Store store){

        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .store(store) // Store 객체는 외부에서 가져와 설정
                .build();
    }
}
