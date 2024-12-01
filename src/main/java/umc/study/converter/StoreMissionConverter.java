package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;


public class StoreMissionConverter {

    public static StoreResponseDTO.StoreMissionDTO toStoreMissionDTO(Mission mission) {
        return StoreResponseDTO.StoreMissionDTO.builder()
                .missionId(mission.getId())
                .reward(mission.getReward())
                .missionSpec(mission.getMissionSpec())
                .deadline(mission.getDeadline())
                .build();
    }

    public static StoreResponseDTO.StoreMissionListDTO toStoreMissionListDTO(Page<Mission> missionPage) {
        List<StoreResponseDTO.StoreMissionDTO> missionDTOList = missionPage.getContent().stream()
                .map(StoreMissionConverter::toStoreMissionDTO)
                .collect(Collectors.toList());

        return StoreResponseDTO.StoreMissionListDTO.builder()
                .missions(missionDTOList)
                .totalPages(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .isLast(missionPage.isLast())
                .isFirst(missionPage.isFirst())
                .build();
    }
}