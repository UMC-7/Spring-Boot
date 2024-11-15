package umm.spring.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umm.spring.study.apiPayload.ApiResponse;
import umm.spring.study.converter.TempConverter;
import umm.spring.study.service.TempService.TempQueryService;
import umm.spring.study.web.dto.TempResponse;

@RestController // REST 컨트롤러임을 나타내는 것. 모든 메서드의 반환값을 JSON 형식으로 반환
@RequestMapping("/temp") // 컨트롤러의 기본 URL 경로를 /temp로 설정
@RequiredArgsConstructor // 의존성 주입이 필요한 final 필드에 대해 생성자에서 주입이 자동으로 설정됨
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test") // /temp/test 경로로 들어오는 GET 요청 처리 메서드임을 표시한 것. 클라이언트가 GET /temp/test로 요청을 보낼 때 이 메서드 호출됨
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){

        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}
