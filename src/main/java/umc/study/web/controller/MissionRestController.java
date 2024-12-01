package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.MissionCommandService.MissionCommandService;
import umc.study.service.StoreService.StoreQueryService;

import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores/{storeId}/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;


    @PostMapping
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> addMission(
            @PathVariable("storeId") Long storeId,
            @RequestBody @Valid MissionRequestDTO.AddMissionDTO request) {
        return ApiResponse.onSuccess(missionCommandService.addMission(storeId, request));
    }

}