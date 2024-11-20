package umc.workbook7.web.controller;

import umc.workbook7.web.dto.Member.MemberResponseDTO;
import umc.workbook7.converter.MemberConverter;
import umc.workbook7.web.dto.Member.MemberRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.workbook7.apiPayload.ApiResponse;
import umc.workbook7.apiPayload.code.status.SuccessStatus;
import umc.workbook7.domain.entity.Member;
import umc.workbook7.service.MemberService.MemberCommandService;
import umc.workbook7.service.MemberService.MemberQueryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberCommandService memberCommandService;
    //private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO>
    join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(SuccessStatus.Member_OK, MemberConverter.toJoinResultDTO(member));
    }

}