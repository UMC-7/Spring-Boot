package umc.workbook7.service.MemberService;

import org.springframework.security.crypto.password.PasswordEncoder;
import umc.workbook7.apiPayload.code.status.ErrorStatus;
import umc.workbook7.apiPayload.exception.handler.FoodCategoryHandler;
import umc.workbook7.converter.MemberConverter;
import umc.workbook7.converter.MemberPreferConverter;
import umc.workbook7.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.workbook7.domain.entity.FoodCategory;
import umc.workbook7.domain.entity.Member;
import umc.workbook7.domain.entity.mapping.MemberPrefer;
import umc.workbook7.repository.FoodCategoryRepository;
import umc.workbook7.web.dto.Member.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        // 비밀번호 검증 및 암호화
        String rawPassword = request.getPassword();
        if (rawPassword == null || rawPassword.isBlank()) {
            throw new IllegalArgumentException("비밀번호는 필수 항목입니다.");
        }

        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("비밀번호 암호화 완료: " + encodedPassword);

        Member newMember = MemberConverter.toMember(request);
        newMember.encodePassword(encodedPassword);

        // 선호 카테고리 검증 및 조회
        List<Long> preferCategoryIds = request.getPreferCategory();
        if (preferCategoryIds == null || preferCategoryIds.isEmpty()) {
            throw new IllegalArgumentException("선호 카테고리를 하나 이상 선택해야 합니다.");
        }

        List<FoodCategory> foodCategoryList = foodCategoryRepository.findAllById(preferCategoryIds);
        if (foodCategoryList.size() != preferCategoryIds.size()) {
            throw new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND);
        }

        System.out.println("선호 카테고리 조회 완료: " + foodCategoryList);

        // MemberPrefer 매핑
        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        memberPreferList.forEach(memberPrefer -> memberPrefer.setMember(newMember));
        System.out.println("MemberPrefer 매핑 완료: " + memberPreferList);

        // 회원 저장
        return memberRepository.save(newMember);
    }


}
