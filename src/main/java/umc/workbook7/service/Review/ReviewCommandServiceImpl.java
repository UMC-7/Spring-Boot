package umc.workbook7.service.Review;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import umc.workbook7.converter.ReviewConverter;
import umc.workbook7.domain.entity.Member;
import umc.workbook7.domain.entity.Review;
import umc.workbook7.domain.entity.Store;
import umc.workbook7.repository.MemberRepository;
import umc.workbook7.repository.ReviewRepository;
import umc.workbook7.repository.StoreRepository;
import umc.workbook7.web.dto.Review.ReviewRequestDTO;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    public Review createReview(Long memberId, ReviewRequestDTO.CreateReviewRequestDTO request){ //throws IOException {
        Review newReview = ReviewConverter.toReview(request);

        Member getMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        Store getStore = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        newReview.setMember(getMember);
        newReview.setStore(getStore);

        return reviewRepository.save(newReview);

    }
}
