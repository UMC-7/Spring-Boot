package umc.workbook7.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.workbook7.apiPayload.ApiResponse;
import umc.workbook7.apiPayload.code.status.SuccessStatus;
import umc.workbook7.domain.entity.Store;
import umc.workbook7.service.StoreService.StoreCommandService;
import umc.workbook7.service.StoreService.StoreQueryService;
import umc.workbook7.converter.StoreConverter;
import umc.workbook7.web.dto.Store.StoreRequestDTO;
import umc.workbook7.web.dto.Store.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin
@RequestMapping("/stores")
@Slf4j
public class StoreController {

    private final StoreCommandService storeCommandService;
    //private final StoreQueryService storeQueryService;

    // 특정 지역에 가게 추가
    @PostMapping("/")
    @Operation(summary = "가게 추가", description = "특정 지역에 가게를 추가합니다.")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDTO> storeCreate(
            @RequestParam Long regionId,
            @RequestBody StoreRequestDTO.CreateStoreRequestDTO request
    ) {
        Store newStore = storeCommandService.createStore(regionId, request);
        return ApiResponse.onSuccess(
                SuccessStatus.Store_OK,
                StoreConverter.toCreateResultDTO(newStore)
        );
    }

}
