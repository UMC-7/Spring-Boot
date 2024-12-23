package umc.workbook7.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import umc.workbook7.service.MemberService.MemberCommandService;
import umc.workbook7.web.dto.Member.MemberRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MemberViewController {
    private final MemberCommandService memberCommandService;

    // 회원가입
    @PostMapping("/members/signup")
    public String joinMember(@ModelAttribute("memberJoinDto") MemberRequestDTO.JoinDto request, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) { return "signup";}
        try {
            memberCommandService.joinMember(request);
            return "redirect:/login";
        } catch (Exception e) { // 회원가입 과정에서 에러가 발생할 경우 에러 메시지를 보내고, signup 페이지를 유지
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("memberJoinDto", new MemberRequestDTO.JoinDto());
        return "signup";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}