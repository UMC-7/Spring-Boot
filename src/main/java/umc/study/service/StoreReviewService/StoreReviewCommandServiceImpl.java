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

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found with id: " + storeId));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + memberId));
        Review newReview = StoreReviewConverter.toReviewEntity(request, member, store);

        Review savedReview = reviewRepository.save(newReview);

        return StoreReviewConverter.toAddReviewResultDTO(savedReview);
    }
}