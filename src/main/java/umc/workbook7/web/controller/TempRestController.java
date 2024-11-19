package umc.workbook7.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.workbook7.apiPayload.ApiResponse;
import umc.workbook7.apiPayload.code.status.SuccessStatus;
import umc.workbook7.converter.TempConverter;
import umc.workbook7.web.dto.Temp.TempResponseDTO;

@RestController
@RequestMapping("/temp") //공통 URL
@RequiredArgsConstructor
public class TempRestController {

    //private final TempQueryService tempQueryService;
    @GetMapping("/test")
    public ApiResponse<TempResponseDTO.TempTestDTO> testAPI(){

        return ApiResponse.onSuccess(
                SuccessStatus.Temp_OK,
                TempConverter.toTempTestDTO());
    }

//    @GetMapping("/exception")
//    public ApiResponse<TempResponseDTO.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
//        tempQueryService.CheckFlag(flag);
//        return ApiResponse.onSuccess(
//                SuccessStatus.Temp_OK,
//                TempConverter.toTempExceptionDTO(flag));
//    }
}

