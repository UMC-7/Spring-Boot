package umc.spring.config.conventer;

import org.springframework.data.domain.Page;
import umc.spring.domain.common.Rating;
import umc.spring.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Rating rating){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(rating.getMember().getName())
                .score(Float.valueOf(rating.getRate()))
                .createdAt(rating.getCreatedAt().toLocalDate())
                .body(rating.getRatingContent())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Rating> rateList){
        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = rateList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(rateList.isLast())
                .isFirst(rateList.isFirst())
                .totalPage(rateList.getTotalPages())
                .totalElements(rateList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
