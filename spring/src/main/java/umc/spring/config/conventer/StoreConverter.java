package umc.spring.config.conventer;

import org.springframework.data.domain.Page;
import umc.spring.domain.common.Mission;
import umc.spring.domain.common.Rating;
import umc.spring.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

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

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Rating rating){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(rating.getMember().getName())
                .score(Float.valueOf(rating.getRate()))
                .createdAt(rating.getCreatedAt().toLocalDate())
                .body(rating.getRatingContent())
                .build();
    }

    public static StoreResponseDTO.MissionPreviewListDTO missionPreviewListDTO(Page<Mission> missionList) {
        List<StoreResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.stream()
                .map(StoreConverter::missionPreviewDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionPreviewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionList.getSize())
                .missionList(missionPreviewDTOList)
                .build();
    }

    public static StoreResponseDTO.MissionPreviewDTO missionPreviewDTO(Mission mission) {
        return StoreResponseDTO.MissionPreviewDTO.builder()
                .missionName(mission.getMissionName())
                .build();
    }
}
