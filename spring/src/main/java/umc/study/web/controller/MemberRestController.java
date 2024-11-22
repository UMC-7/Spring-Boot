package umc.spring.study.web.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;

import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.MemberConverter;
import umc.spring.study.web.dto.MemberResponseDTO;
import umc.spring.study.web.dto.MemberRequestDTO;
import umc.spring.study.service.memberService.MemberCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        return null;
    }
}