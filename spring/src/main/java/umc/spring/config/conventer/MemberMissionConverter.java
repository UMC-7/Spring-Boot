package umc.spring.config.conventer;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.MissionDTO;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class MemberMissionConverter {

    public static MemberMission toMemberMission(MissionDTO.AddTryDTO request) {

        return MemberMission.builder().build();
    }

    public static MemberMissionResponseDTO.JoinResultDTO toJoinResultDTO(MemberMission request) {
        return MemberMissionResponseDTO.JoinResultDTO.builder()
                .memberMissionId(request.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
