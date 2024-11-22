package umm.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umm.spring.study.apiPayload.ApiResponse;
import umm.spring.study.converter.MissionConverter;
import umm.spring.study.domain.mapping.MemberMission;
import umm.spring.study.service.MissionService.MissionCommandService;
import umm.spring.study.web.dto.MissionRequestDTO;
import umm.spring.study.web.dto.MissionResponseDTO;

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
