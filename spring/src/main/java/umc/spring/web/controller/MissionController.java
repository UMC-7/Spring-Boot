package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.config.conventer.MissionConverter;
import umc.spring.domain.common.Mission;
import umc.spring.service.MissionService.MissionService;
import umc.spring.service.MissionService.MissionServiceImpl;
import umc.spring.web.dto.MissionDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequestMapping("/mission")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/add")
    public ApiResponse<MissionResponseDTO.JoinResultDTO> addMission(@RequestBody @Valid MissionDTO.AddDTO request) {
        Mission mission = missionService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }
}
