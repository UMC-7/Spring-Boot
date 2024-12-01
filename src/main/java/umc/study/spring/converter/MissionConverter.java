package umc.study.spring.converter;

import umc.study.spring.domain.Member;
import umc.study.spring.domain.Mission;
import umc.study.spring.domain.mapping.MemberMission;
import umc.study.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

import static umc.study.spring.domain.enums.MissionStatus.CHALLENGING;

public class MissionConverter {
    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(CHALLENGING)
                .build();
    }

    public static MissionResponseDTO.AddChallengeResultDTO toAddResultDTO(MemberMission memberMission){
        return MissionResponseDTO.AddChallengeResultDTO.builder()
                .missionId(memberMission.getMission().getId())
                .memberId(memberMission.getMember().getId())
                .addAt(LocalDateTime.now())
                .build();
    }

}
