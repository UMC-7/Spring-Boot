package umm.spring.study.converter;

import umm.spring.study.domain.Member;
import umm.spring.study.domain.Mission;
import umm.spring.study.domain.mapping.MemberMission;
import umm.spring.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

import static umm.spring.study.domain.enums.MissionStatus.CHALLENGING;

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
