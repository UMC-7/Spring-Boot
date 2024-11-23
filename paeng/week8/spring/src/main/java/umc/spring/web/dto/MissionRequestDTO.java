package umc.spring.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    @Setter
    public static class MCreateDto {
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
        private Long storeId;
    }
}
