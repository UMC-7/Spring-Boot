package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.config.conventer.MemberMissionConverter;
import umc.spring.config.conventer.MissionConverter;
import umc.spring.domain.common.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MissionService;
import umc.spring.service.MissionService.MissionServiceImpl;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.MissionDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequestMapping("/mission")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/create")
    public ApiResponse<MissionResponseDTO.JoinResultDTO> addMission(@RequestBody @Valid MissionDTO.AddDTO request) {
        Mission mission = missionService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }

    @GetMapping("/addTryingMission")
    public ApiResponse<MemberMissionResponseDTO.JoinResultDTO> addTryingMission(@RequestBody @Valid MissionDTO.AddTryDTO request) {
        MemberMission memberMission = missionService.addTryingMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toJoinResultDTO(memberMission));
    }
}
