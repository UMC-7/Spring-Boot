package umc.study.web.controller;

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
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreReviewConverter;
import umc.study.domain.Review;
import umc.study.service.MemberService.UserReviewQueryService;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.annotation.ExistMember;
import umc.study.web.dto.StoreReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserReviewController {

    private final UserReviewQueryService userReviewQueryService;

    @GetMapping("/{userId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "특정 사용자가 작성한 리뷰 목록을 조회하는 API입니다. 페이징을 포함하며, query string으로 page 번호를 전달하세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "사용자의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "조회할 페이지 번호입니다.")
    })
    public ApiResponse<StoreReviewResponseDTO.ReviewPreviewListDTO> getUserReviews(
            @ExistMember @PathVariable(name = "userId") Long userId,
            @CheckPage @RequestParam(name = "page", defaultValue = "1") Integer page) {

        Page<Review> reviews = userReviewQueryService.getUserReviews(userId, page);
        return ApiResponse.onSuccess(StoreReviewConverter.reviewPreViewListDTO(reviews));
    }
}