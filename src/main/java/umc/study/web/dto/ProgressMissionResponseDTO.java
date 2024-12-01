package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.enums.MissionStatus;

import java.util.List;

public class ProgressMissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetProgressMissionDTO {
        Long missionId;
        Integer reward;
        String missionSpec;
        String status;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetProgressMissionListDTO {
        List<GetProgressMissionDTO> missions;
        Integer totalPages;
        Long totalElements;
        Boolean isLast;
        Boolean isFirst;
    }
}
