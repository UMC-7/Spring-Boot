package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.StoreResponseDTO;
import umc.study.web.dto.StoreReviewRequestDTO;
import umc.study.web.dto.StoreReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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


    public static StoreReviewResponseDTO.ReviewPreviewDTO reviewPreViewDTO(Review review){
        return StoreReviewResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static StoreReviewResponseDTO.ReviewPreviewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreReviewResponseDTO.ReviewPreviewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreReviewConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreReviewResponseDTO.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listsize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}