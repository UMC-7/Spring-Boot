package umc.spring.service.RatingService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.config.conventer.RatingConverter;
import umc.spring.domain.common.Member;
import umc.spring.domain.common.Rating;
import umc.spring.domain.common.Store;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.memberRepository.MemberRepository;
import umc.spring.repository.missionRepository.MissionRepository;
import umc.spring.repository.ratingRepository.RatingRepository;
import umc.spring.service.MemberService.MemberComandService;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.web.dto.RatingDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService{

    private final StoreQueryService storeQueryService;
    private final MemberComandService memberComandService;

    @Override
    @Transactional
    public Rating createRating(RatingDTO.CreateRating request) {

        Rating newRating = RatingConverter.toRating(request);

        Optional<Store> store = storeQueryService.findStore(request.getStoreId());
        Store storeValue = store.orElseThrow(() -> new IllegalArgumentException("Store 값이 없습니다."));

        Optional<Member> member = memberComandService.findById(request.getMemberId());
        Member memberValue = member.orElseThrow(() -> new IllegalArgumentException("Member 값이 없습니다."));

        newRating.setStore(storeValue);
        newRating.setMember(memberValue);

        return newRating;
    }
}
