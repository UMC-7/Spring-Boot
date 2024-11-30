package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.config.conventer.MemberConverter;
import umc.spring.domain.common.Member;
import umc.spring.domain.common.Rating;
import umc.spring.service.MemberService.MemberComandService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.web.dto.RatingRequestDTO;
import umc.spring.web.dto.RatingResponseDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberComandService memberComandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberComandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{memberId}/rating")
    @Operation(summary = "특정 맴버의 리뷰 목록 조회 API", description = "특정 맴버의 리뷰를 조회합니다. paging 포함")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "member 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberResponseDTO.myRatingListResultDTO> getMyRatingListDTO(@PathVariable(name = "memberId") Long memberId, @CheckPage @RequestParam("page") Integer page) {
        Page<Rating> ratingList = memberComandService.getRatingList(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.toMyRatingListResultDTO(ratingList));
    }
}
