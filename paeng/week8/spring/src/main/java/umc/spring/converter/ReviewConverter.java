package umc.spring.converter;


import umc.spring.domain.Review;
import umc.spring.repository.ReviewRepository;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;
import umc.spring.domain.Member;
import umc.spring.domain.Store;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.CreateResultDTO toCreateResultDTO(Review review){
        return ReviewResponseDTO.CreateResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.CreateDto request, Member member, Store store){

    return Review.builder()
            .title(request.getTitle())
            .score(request.getScore())
            .member(member)
            .store(store)
            .build();
    }

}
