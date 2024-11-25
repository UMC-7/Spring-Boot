package umc.spring.study.service.reviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.MemberHandler;
import umc.spring.study.apiPayload.exception.handler.StoreHandler;
import umc.spring.study.converter.ReviewConverter;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.repository.MemberRepository;
import umc.spring.study.repository.ReviewRepository;
import umc.spring.study.repository.StoreRepository;
import umc.spring.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;


    @Override
    public Review addReview(Long memberId, Long storeId, ReviewRequestDTO.AddReviewDTO request) {
        // 1. Member 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        // 2. Store 조회
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        // 3. Review 객체 생성
        Review review = ReviewConverter.toReview(request);

        // 4. 연관 관계 설정
        review.setMember(member);
        review.setStore(store);

        // 5. Review 저장
        return reviewRepository.save(review);
    }
}
