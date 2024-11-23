package umc.spring.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MissionChallengeResponseDTO {

    private Long memberMissionId;  // 생성된 MemberMission의 ID
    private Long missionId;        // 도전한 Mission의 ID
    private Long memberId;         // 도전한 Member의 ID
    private String status;         // 도전 상태 (예: CHALLENGING)
}
