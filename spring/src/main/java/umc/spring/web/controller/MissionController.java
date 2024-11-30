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
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.MissionDTO;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.StoreResponseDTO;

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

    @GetMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.ReviewPreViewDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId) {
        return null;
    }
}
