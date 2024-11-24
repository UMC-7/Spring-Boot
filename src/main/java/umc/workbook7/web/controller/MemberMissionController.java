package umc.workbook7.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.workbook7.apiPayload.ApiResponse;
import umc.workbook7.apiPayload.code.status.SuccessStatus;
import umc.workbook7.converter.MemberMissionConverter;
import umc.workbook7.domain.entity.mapping.MemberMission;
import umc.workbook7.service.MemberMissionService.MemberMissionCommandService;
import umc.workbook7.service.MemberMissionService.MemberMissionQueryService;
import umc.workbook7.web.dto.MemberMission.MemberMissionRequestDTO;
import umc.workbook7.web.dto.MemberMission.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin
@RequestMapping("/member")
@Slf4j
public class MemberMissionController {

    private final MemberMissionCommandService memberMissionCommandService;
    //private final MemberMissionQueryService memberMissionQueryService;

    // 수행중인 미션 목록에 미션 추가
    @PostMapping("/missions")
    @Operation(summary = "도전 미션 목록에 미션 추가 API", description = "도전중인 미션 목록에 미션을 추가합니다.")
    public ApiResponse<MemberMissionResponseDTO.CreateMemberMissionResultDTO> createMemberMission(
            @RequestParam Long memberId,
            @RequestBody MemberMissionRequestDTO.CreateMemberMissionRequestDTO request
    ) {
        MemberMission newMemberMission = memberMissionCommandService.createMemberMission(memberId, request);
        return ApiResponse.onSuccess(
                SuccessStatus.Mission_OK,
                MemberMissionConverter.toCreateMemberMissionResultDTO(newMemberMission)
        );
    }

}
