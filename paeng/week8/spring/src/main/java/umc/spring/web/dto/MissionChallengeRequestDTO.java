package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MissionChallengeRequestDTO {
    @NotNull(message = "미션 ID는 필수입니다.")
    private Long missionId;

    @NotNull(message = "회원 ID는 필수입니다.")
    private Long memberId;
}
