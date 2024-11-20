package umc.workbook7.service.MemberService;

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

    @Override
    @Transactional // Transactional:
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
