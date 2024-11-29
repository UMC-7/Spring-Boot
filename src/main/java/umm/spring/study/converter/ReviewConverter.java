package umm.spring.study.converter;

import umm.spring.study.domain.Member;
import umm.spring.study.domain.Review;
import umm.spring.study.domain.Store;
import umm.spring.study.web.dto.ReviewRequestDTO;
import umm.spring.study.web.dto.ReviewResponseDTO;

import java.util.Optional;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.AddReviewDTO request, Store store, Member member){
        return Review.builder()
                .title(request.getTitle())
                .body((request.getBody()))
                .score(request.getScore())
                .store(store)
                .member(member)
                .build();
    }

    public static ReviewResponseDTO.AddResultDTO toAddResultDTO(Review review){
        return ReviewResponseDTO.AddResultDTO.builder()
                .reviewId(review.getId())
                .body(review.getBody())
                .score(review.getScore())
                .title(review.getTitle())
                .createdAt(review.getCreatedAt())
                .storeId(review.getStore().getId())
                .memberId(review.getMember().getId())
                .build();
    }
}
