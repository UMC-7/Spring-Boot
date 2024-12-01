package umc.study.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.spring.converter.ReviewConverter;
import umc.study.spring.domain.Member;
import umc.study.spring.domain.Review;
import umc.study.spring.domain.Store;
import umc.study.spring.repository.MemberRepository;
import umc.study.spring.repository.ReviewRepository.ReviewRepository;
import umc.study.spring.repository.StoreRepository.StoreRepository;
import umc.study.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Review addReview(ReviewRequestDTO.AddDTO request){
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new RuntimeException("Store not found"));

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        // Review 생성
        Review newReview = ReviewConverter.toReview(request, store, member);

        // Review 저장
        return reviewRepository.save(newReview);
    }

}