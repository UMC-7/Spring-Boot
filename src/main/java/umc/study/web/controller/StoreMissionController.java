package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreMissionConverter;
import umc.study.domain.Mission;
import umc.study.service.StoreService.StoreMissionQueryService;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreMissionController {

    private final StoreMissionQueryService storeMissionQueryService;

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션 목록을 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<StoreResponseDTO.StoreMissionListDTO> getStoreMissions(
            @ExistStore @PathVariable(name = "storeId") Long storeId,
            @CheckPage @RequestParam(name = "page", defaultValue = "0") Integer page) {

        Page<Mission> missionPage = storeMissionQueryService.getStoreMissions(storeId, page);

        return ApiResponse.onSuccess(StoreMissionConverter.toStoreMissionListDTO(missionPage));
    }
}