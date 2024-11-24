package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class MissionResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMissionResultDTO {
        private Long missionId;
        private Long storeId;
        private String missionSpec;
        private Integer reward;
        private LocalDate deadline;
    }
}