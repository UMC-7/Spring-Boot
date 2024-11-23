package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class MissionResponseDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MCreateResultDTO {
        private Long missionId;
        private LocalDateTime createdAt;
    }
}
