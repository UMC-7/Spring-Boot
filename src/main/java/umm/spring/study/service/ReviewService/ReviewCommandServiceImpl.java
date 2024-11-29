package umm.spring.study.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umm.spring.study.converter.ReviewConverter;
import umm.spring.study.domain.Member;
import umm.spring.study.domain.Review;
import umm.spring.study.domain.Store;
import umm.spring.study.repository.MemberRepository;
import umm.spring.study.repository.ReviewRepository.ReviewRepository;
import umm.spring.study.repository.StoreRepository.StoreRepository;
import umm.spring.study.repository.StoreRepository.StoreRepositoryImpl;
import umm.spring.study.web.dto.ReviewRequestDTO;
import umm.spring.study.web.dto.ReviewResponseDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Review addReview(ReviewRequestDTO.AddReviewDTO request){
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
