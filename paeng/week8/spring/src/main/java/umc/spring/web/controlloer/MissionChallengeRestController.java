package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.MissionChallengeService.MissionChallengeCommandService;
import umc.spring.web.dto.MissionChallengeRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions/challenges")
public class MissionChallengeRestController {

    private final MissionChallengeCommandService missionChallengeCommandService;

    @PostMapping("/")
    public ApiResponse<String> challengeMission(@RequestBody @Valid MissionChallengeRequestDTO request) {
        missionChallengeCommandService.challengeMission(request);
        return ApiResponse.onSuccess("미션 도전에 성공하였습니다.");
    }
}
