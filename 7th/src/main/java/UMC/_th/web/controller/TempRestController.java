package UMC._th.web.controller;

import UMC._th.apiPayload.ApiResponse;
import UMC._th.web.dto.TempResoponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    @GetMapping("/test")
    public ApiResponse<TempResoponse.TempTestDTO> testAPI(){

        return ApiResponse.onSuccess(
                TempResoponse.TempTestDTO.builder()
                .testString("This is Test!")
                .build());
    }
}
