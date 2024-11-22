package umm.spring.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umm.spring.study.validation.annotation.MissionExists;

public class MissionRequestDTO {
    @Getter
    public static class AddChallengeDTO {
        @NotNull
        private Long memberId;

        @NotNull
        @MissionExists
        private Long missionId;
    }
}
