package umc.study.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.spring.apiPayload.ApiResponse;
import umc.study.spring.converter.MissionConverter;
import umc.study.spring.domain.mapping.MemberMission;
import umc.study.spring.service.MissionService.MissionCommandService;
import umc.study.spring.web.dto.MissionRequestDTO;
import umc.study.spring.web.dto.MissionResponseDTO;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/addChallenge")
    public ApiResponse<MissionResponseDTO.AddChallengeResultDTO> addMissionChallenge(@RequestBody @Valid MissionRequestDTO.AddChallengeDTO request) {
        MemberMission memberMission = missionCommandService.addMissionToChallenge(request);
        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(memberMission));
    }

}
