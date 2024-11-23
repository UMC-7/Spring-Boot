package umc.spring.config.conventer;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.common.Member;
import umc.spring.domain.common.Mission;
import umc.spring.domain.common.Store;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.MissionDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
public class MissionConverter {


    public static MissionResponseDTO.JoinResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDTO.JoinResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionDTO.AddDTO request) {

        return Mission.builder()
                .missionName(request.getMissionName())
                .missionCertificationNumber(request.getMissionCertificationNumber())
                .memberMisssion(new ArrayList<>())
                .build();
    }
}
