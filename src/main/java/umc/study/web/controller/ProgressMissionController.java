package umc.study.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ProgressMissionConverter;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MissionCommandService.ProgressMissionQueryService;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.annotation.ExistMember;
import umc.study.web.dto.ProgressMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class ProgressMissionController {

    private final ProgressMissionQueryService progressMissionQueryService;

    @GetMapping("/{memberId}/missions/progress")
    @Operation(summary = "내 진행 중인 미션 목록 조회 API", description = "특정 사용자가 진행 중인 미션 목록을 조회합니다. 페이징을 포함합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰 필요", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "memberId", description = "사용자 ID (Path Variable)", required = true),
            @Parameter(name = "page", description = "조회할 페이지 번호 (Query String)", required = true)
    })
    public ApiResponse<ProgressMissionResponseDTO.GetProgressMissionListDTO> getProgressMissions(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @CheckPage @RequestParam(name = "page", defaultValue = "0") Integer page) {

        Page<MemberMission> memberMissionPage = progressMissionQueryService.getProgressMissions(memberId, page);
        return ApiResponse.onSuccess(ProgressMissionConverter.toGetProgressMissionListDTO(memberMissionPage));
    }
}