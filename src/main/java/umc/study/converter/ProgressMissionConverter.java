package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.ProgressMissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ProgressMissionConverter {

    public static ProgressMissionResponseDTO.GetProgressMissionDTO toGetProgressMissionDTO(MemberMission memberMission) {
        return ProgressMissionResponseDTO.GetProgressMissionDTO.builder()
                .missionId(memberMission.getMission().getId())
                .reward(memberMission.getMission().getReward())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .status(memberMission.getStatus().name())
                .build();
    }

    public static ProgressMissionResponseDTO.GetProgressMissionListDTO toGetProgressMissionListDTO(Page<MemberMission> memberMissionPage) {
        List<ProgressMissionResponseDTO.GetProgressMissionDTO> missionDTOList = memberMissionPage.getContent().stream()
                .map(ProgressMissionConverter::toGetProgressMissionDTO)
                .collect(Collectors.toList());

        return ProgressMissionResponseDTO.GetProgressMissionListDTO.builder()
                .missions(missionDTOList)
                .totalPages(memberMissionPage.getTotalPages())
                .totalElements(memberMissionPage.getTotalElements())
                .isLast(memberMissionPage.isLast())
                .isFirst(memberMissionPage.isFirst())
                .build();
    }
}