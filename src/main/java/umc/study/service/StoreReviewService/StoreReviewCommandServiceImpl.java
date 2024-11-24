package umc.study.service.StoreReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.StoreReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository;
import umc.study.repository.StoreReviewRepository.StoreReviewRepository;
import umc.study.repository.storeRepository.StoreRepository;
import umc.study.web.dto.StoreReviewRequestDTO;
import umc.study.web.dto.StoreReviewResponseDTO;

@Service
@RequiredArgsConstructor
public class StoreReviewCommandServiceImpl implements StoreReviewCommandService {

    private final StoreReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public StoreReviewResponseDTO.AddReviewResultDTO addReview(Long storeId, Long memberId, StoreReviewRequestDTO.AddReviewDTO request) {

        // Store 조회
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found with id: " + storeId));

        // Member 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + memberId));

        // Review 엔티티 생성
        Review newReview = StoreReviewConverter.toReviewEntity(request, member, store);

        // 저장
        Review savedReview = reviewRepository.save(newReview);

        // 결과 DTO 반환
        return StoreReviewConverter.toAddReviewResultDTO(savedReview);
    }
}