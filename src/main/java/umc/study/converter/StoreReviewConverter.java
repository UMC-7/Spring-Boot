package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.StoreReviewRequestDTO;
import umc.study.web.dto.StoreReviewResponseDTO;

public class StoreReviewConverter {

    public static Review toReviewEntity(StoreReviewRequestDTO.AddReviewDTO request, Member member, Store store) {
        return Review.builder()
                .body(request.getContent())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();
    }

    public static StoreReviewResponseDTO.AddReviewResultDTO toAddReviewResultDTO(Review review) {
        return StoreReviewResponseDTO.AddReviewResultDTO.builder()
                .reviewId(review.getId())
                .storeId(review.getStore().getId())
                .memberId(review.getMember().getId())
                .build();
    }
}