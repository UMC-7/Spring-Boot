package UMC._th.service;

import UMC._th.apiPayload.code.status.ErrorStatus;
import UMC._th.apiPayload.exception.handler.FoodPreferHandler;
import UMC._th.apiPayload.exception.handler.TempHandler;
import UMC._th.converter.MemberConverter;
import UMC._th.converter.MemberPreferConverter;
import UMC._th.domain.FoodPrefer;
import UMC._th.domain.Member;
import UMC._th.domain.mapping.MemberPrefer;
import UMC._th.repository.FoodPreferRepository;
import UMC._th.repository.MemberRepository;
import UMC._th.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodPreferRepository foodPreferRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDTO request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodPrefer> foodPrefers = request.getPreferCategory().stream()
                .map(category -> {
                    return foodPreferRepository.findById(category).orElseThrow(()-> new FoodPreferHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPrefers = MemberPreferConverter.toMemberPreferList(foodPrefers);

        memberPrefers.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
