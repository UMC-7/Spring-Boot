package umc.study.web.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class AddMissionDTO {

        @NotBlank
        private String missionSpec;

        @NotNull
        private Integer reward;

        private LocalDate deadline;
    }
}