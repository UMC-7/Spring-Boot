package umc.spring.study.service.memberService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import jakarta.transaction.Transactional;

import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.FoodHandler;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.mapping.MemberFood;
import umc.spring.study.domain.Food;
import umc.spring.study.repository.MemberRepository;
import umc.spring.study.repository.FoodRepository;
import umc.spring.study.web.dto.MemberRequestDTO;
import umc.spring.study.converter.MemberConverter;
import umc.spring.study.converter.MemberFoodConverter;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;
//    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
//        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));

        List<Food> foodCategoryList = request.getMemberFood().stream()
                .map(category -> {
                    return foodRepository.findById(category).orElseThrow(() -> new FoodHandler(ErrorStatus.FOOD_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberFood> memberFoodList = MemberFoodConverter.toMemberFoodList(foodCategoryList);
        memberFoodList.forEach(memberFood -> {memberFood.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}