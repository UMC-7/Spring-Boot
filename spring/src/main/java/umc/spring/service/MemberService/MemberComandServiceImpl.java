package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.config.conventer.MemberPreferConverter;
import umc.spring.conventer.MemberConverter;
import umc.spring.domain.common.FoodCategory;
import umc.spring.domain.common.Member;
import umc.spring.domain.common.Mission;
import umc.spring.domain.common.Rating;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.MemberPrefer;
import umc.spring.repository.foodCategoryRepository.FoodCategoryRepository;
import umc.spring.repository.memberMissionRepository.MemberMissionRepository;
import umc.spring.repository.memberRepository.MemberRepository;
import umc.spring.repository.missionRepository.MissionRepository;
import umc.spring.repository.ratingRepository.RatingRepository;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.RatingResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MemberComandServiceImpl implements MemberComandService{

    private final MemberRepository memberRepository;
    private final RatingRepository ratingRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Rating> getRatingList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();
        Page<Rating> allByMember = ratingRepository.findAllByMember(member, PageRequest.of(page, 10));

        return allByMember;
    }

    @Override
    public Page<MemberMission> getTryingMissionMissionList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();
        Page<MemberMission> allByMemberAndStatus = memberMissionRepository.findAllByMemberAndStatus(member, MissionStatus.TRYING, PageRequest.of(page, 10));
        return allByMemberAndStatus;

    }

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getMemberPreferList().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
