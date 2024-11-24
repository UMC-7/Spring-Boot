package umc.workbook7.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.workbook7.apiPayload.ApiResponse;
import umc.workbook7.apiPayload.code.status.SuccessStatus;
import umc.workbook7.domain.entity.Mission;
import umc.workbook7.converter.MissionConverter;
import umc.workbook7.service.MissionService.MissionCommandService;
import umc.workbook7.web.dto.Mission.MissionRequestDTO;
import umc.workbook7.web.dto.Mission.MissionResponseDTO;


@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin
@RequestMapping("/missions")
@Slf4j
public class MissionController {

    private final MissionCommandService missionCommandService;

    // 가게에 미션 추가
    @PostMapping("/")
    @Operation(summary = "미션 추가 API", description = "가게에 미션을 추가합니다.")
    public ApiResponse<MissionResponseDTO.CreateMissionResultDTO> createMission(
            @RequestParam Long storeId,
            @RequestBody MissionRequestDTO.CreateMissionRequestDTO request
    ) {
        Mission newMission = missionCommandService.createMission(storeId, request);
        return ApiResponse.onSuccess(
                SuccessStatus.Mission_OK,
                MissionConverter.toCreateMissionResultDTO(newMission)
        );
    }


}