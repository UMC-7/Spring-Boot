

package umm.spring.study.converter;

import org.springframework.data.domain.Page;
import umm.spring.study.domain.Region;
import umm.spring.study.domain.Review;
import umm.spring.study.domain.Store;
import umm.spring.study.web.dto.StoreRequestDTO;
import umm.spring.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {
    public static StoreResponseDTO.AddResultDTO toAddResultDTO(Store store){
        return StoreResponseDTO.AddResultDTO.builder()
                .storeId(store.getId())
                .createAt(LocalDateTime.now())
                .storeName(store.getName())
                .regionName(store.getRegion().getName())
                .storeScore(store.getScore())
                .build();
    }

    public static Store toStore(StoreRequestDTO.AddDTO request, Region region){
        return Store.builder()
                .name(request.getStoreName())
                .score(request.getStoreScore())
                .address(request.getStoreAddress())
                .region(region)
                .build();

    }

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
