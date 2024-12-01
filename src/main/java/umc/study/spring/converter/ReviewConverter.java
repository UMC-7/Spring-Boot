package umc.study.spring.converter;

import umc.study.spring.domain.Member;
import umc.study.spring.domain.Review;
import umc.study.spring.domain.Store;
import umc.study.spring.web.dto.ReviewRequestDTO;
import umc.study.spring.web.dto.ReviewResponseDTO;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.AddDTO request, Store store, Member member){
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
