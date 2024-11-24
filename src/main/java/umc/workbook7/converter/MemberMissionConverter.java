package umc.workbook7.converter;

import umc.workbook7.domain.entity.Member;
import umc.workbook7.domain.entity.mapping.MemberMission;
import umc.workbook7.web.dto.MemberMission.MemberMissionResponseDTO;
import umc.workbook7.web.dto.MemberMission.MemberMissionRequestDTO;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(MemberMissionRequestDTO.CreateMemberMissionRequestDTO request, Member member){
        return MemberMission.builder()
//                .memberMissionId(request.getMissionId())
//                .build();
                .member(member)
                .build();
    }

    public static MemberMissionResponseDTO.CreateMemberMissionResultDTO toCreateMemberMissionResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.CreateMemberMissionResultDTO.builder()
                .memberMissionId(memberMission.getMemberMissionId())
                .memberId(memberMission.getMember().getMemberId())
                .missionId(memberMission.getMission().getMissionId())
                .createAt(memberMission.getCreatdAt())
                .build();
    }
}
